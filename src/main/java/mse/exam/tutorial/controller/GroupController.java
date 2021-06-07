package mse.exam.tutorial.controller;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import mse.exam.tutorial.dto.input.GroupInput;
import mse.exam.tutorial.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/group")
@Slf4j
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create() {
        log.info("create");
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        var responseEntity = groupService.getGroups();
        log.info("getAll: responseEntity: {}", responseEntity);
        return ResponseEntity.ok(responseEntity);
    }

    @RequestMapping(value = "/update-group", method = RequestMethod.PUT)
    public ResponseEntity<?> updateGroup(@RequestBody GroupInput input) {
        log.info("updateGroup: GroupInput: {}", input);
        var responseEntity = groupService.create(input);
        log.info("updateGroup: GroupOutput: {}", responseEntity);
        return ResponseEntity.ok(responseEntity);
    }

    @RequestMapping(value = "/delete-group", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteGroup(@RequestBody GroupInput input) {
        log.info("deleteGroup: GroupInput: {}", input);
        var responseEntity = groupService.deleteGroup(input);
        log.info("deleteGroup: GroupOutput: {}", responseEntity);
        return ResponseEntity.ok().build();
    }
}