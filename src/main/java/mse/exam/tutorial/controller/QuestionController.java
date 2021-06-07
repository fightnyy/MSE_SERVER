package mse.exam.tutorial.controller;

import mse.exam.tutorial.dto.input.QuestionInput;
import mse.exam.tutorial.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/question/createOrUpdate", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody QuestionInput questionInput) {
        return ResponseEntity.ok(questionService.create(questionInput));
    }


    @RequestMapping(value = "/question/getAllByGroupId", method = RequestMethod.GET)
    public ResponseEntity<?> getAllByGroup(@RequestParam("groupId") Long groupId) {
        return ResponseEntity.ok(questionService.getAllByGroupId(groupId));
    }

    @RequestMapping(value = "/question/getAll", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(@RequestParam Map<String, String> model) {
        Pageable pageable = PageRequest.of(Integer.parseInt(model.get("page")) - 1, Integer.parseInt(model.get("size")));
        return ResponseEntity.ok(questionService.getAll(pageable));
    }

    @RequestMapping(value = "/question/getById", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@RequestParam("questionid") Long questionId) {
        return ResponseEntity.ok(questionService.findById(questionId));
    }

    @RequestMapping(value = "/question/delete", method = RequestMethod.DELETE)
    public void delete(@RequestParam("questionid") Long questionId) {
        questionService.delete(questionId);
    }
}
