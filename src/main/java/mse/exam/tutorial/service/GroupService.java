package mse.exam.tutorial.service;

import mse.exam.tutorial.convert.Converter;
import mse.exam.tutorial.dto.input.GroupInput;
import mse.exam.tutorial.dto.output.GroupOutput;
import mse.exam.tutorial.dto.output.GroupResponse;
import mse.exam.tutorial.entity.Group;
import mse.exam.tutorial.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Group updateGroup(GroupInput groupInput) {
        Group group = Converter.toModel(groupInput, Group.class);

        return groupRepository.save(group);
    }

    public GroupResponse getGroups() {
        List<Group> entities = groupRepository.findAll();
        List<GroupOutput> result1 = entities.stream().map(item -> {
            GroupOutput dto = Converter.toModel(item , GroupOutput.class);
            dto.setNumProblems(item.getQuestions().size());
            return dto;
        }).collect(Collectors.toList());
        GroupResponse result = new GroupResponse();
        result.setGroups(result1);
        return result;
    }

//
//    public Group updateGroup(GroupInput groupInput){
//        Group group = Converter.toModel(groupInput, Group.class);
//        group = groupRepository.save(group);
//        return group;
//    }

    public boolean deleteGroup(GroupInput groupInput){
        Optional<Group> optional = groupRepository.findById(groupInput.getGroupId());
        if (optional.isPresent()) {
            groupRepository.delete(groupRepository.getOne(groupInput.getGroupId()));
            return true;
        } else {
            return false;
        }
    }

    // Only create group by ID and set this group name = Undefined
    public boolean create(Long id) {
        Group group = new Group();
        group.setGroupId(id);
        group.setName("Undefined");
        groupRepository.save(group);
        return true;
    }
}
