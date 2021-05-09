package mse.exam.tutorial.controller;

import mse.exam.tutorial.entity.Chito;
import mse.exam.tutorial.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activity")
public class ActivityController {

    private final ActivityService as;
    @Autowired
    public ActivityController(ActivityService as)
    {
        this.as = as;
    }



    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/study")
    public Chito doStudy()
    {

        Chito chito = as.doStudy();
        return chito;
    }

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/workout")
    public Chito doWorkout()
    {
        return new Chito();
    }

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/interview")
    public Chito doInterview()
    {
        return new Chito();
    }


}
