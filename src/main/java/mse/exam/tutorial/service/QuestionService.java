package mse.exam.tutorial.service;

import mse.exam.tutorial.convert.Converter;
import mse.exam.tutorial.dto.QuestionDTO;
import mse.exam.tutorial.dto.input.QuestionInput;
import mse.exam.tutorial.entity.Group;
import mse.exam.tutorial.entity.Question;
import mse.exam.tutorial.repository.GroupRepository;
import mse.exam.tutorial.repository.QuestionRepository;
import mse.exam.tutorial.repository.UserRepository;
import mse.exam.tutorial.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    public QuestionDTO create(QuestionInput questionInput) {
        Group group = groupRepository.findById(questionInput.getGroupId()).get();

        Question question = Converter.toModel(questionInput, Question.class);
        question.setGroup(group);
        question.setCreatedBy(userRepository.findOneWithUserByUsername(SecurityUtil.getUser().getUsername()));

        return Converter.toModel(questionRepository.save(question) , QuestionDTO.class);
    }

    public List<QuestionDTO> getAllByGroupId(Long groupId) {
        Optional<Group> group = groupRepository.findById(groupId);
        if (!group.isPresent()) {
            return new ArrayList<>();
        }
        return Converter.toList(questionRepository.findAllByGroup(group.get()) , QuestionDTO.class);
    }

    public List<QuestionDTO> getAll(Pageable pageable) {
        return Converter.toList(questionRepository.findAllQuestion(pageable),QuestionDTO.class);
    }

    public QuestionDTO findById(Long id) {
        return Converter.toModel(questionRepository.findById(id).get() , QuestionDTO.class);
    }

    public void delete(Long id) {
        questionRepository.deleteById(id);
    }
}
