package mse.exam.tutorial.controller;

import mse.exam.tutorial.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

}
