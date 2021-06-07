package mse.exam.tutorial.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import mse.exam.tutorial.dto.initial.GroupsJsonDTO;
import mse.exam.tutorial.entity.Group;
import mse.exam.tutorial.entity.Question;
import mse.exam.tutorial.repository.GroupRepository;
import mse.exam.tutorial.repository.QuestionRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class InitialDataConfig {

    private ObjectMapper mapper = new ObjectMapper();
    private String examsDefaultData = "initial_data/exams.json";
    private String groupsDefaultData = "initial_data/groups.json";
    private final GroupRepository groupRepository;
    private final QuestionRepository questionRepository;

    @Bean
    public ApplicationRunner initGroupsTable() {
        return $ -> {
            ClassPathResource resource = new ClassPathResource(groupsDefaultData);
            TypeReference<List<GroupsJsonDTO>> type = new TypeReference<List<GroupsJsonDTO>>() {};
            var dtoList = mapper.readValue(resource.getInputStream(), type);
            log.info("initGroupsTable: dtoList: {}", dtoList);
            for (var $group : dtoList) {
                Group group = Group.builder()
//                        .groupId($group.getGroupId())
                        .name($group.getGroupName())
                        .questions(new ArrayList<Question>())
                        .build();

                for (var $question : $group.getQuestions()) {
                    Question question = Question.builder()
//                            .questionId($question.getId())
                            .questionContent($question.getQuestionBody())
                            .s1Body($question.getSelectionBody1())
                            .s2Body($question.getSelectionBody2())
                            .s3Body($question.getSelectionBody3())
                            .s4Body($question.getSelectionBody4())
                            .hint($question.getHint())
                            .ans($question.getAnswer())
                            .group(group)
                            .build();
                    group.getQuestions().add(question);
                }
                groupRepository.save(group);
            }
            log.info("initGroupsTable: persit done");
        };
    }

    private String toStringFromInputStream(InputStream inputStream) throws IOException {
        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        if (data == null || data.length == 0) {
            return "";
        }
        return new String(data);
    }
}
