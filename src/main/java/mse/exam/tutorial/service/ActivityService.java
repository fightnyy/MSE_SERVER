package mse.exam.tutorial.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mse.exam.tutorial.entity.Chito;
import mse.exam.tutorial.entity.User;
import mse.exam.tutorial.repository.UserRepository;
import mse.exam.tutorial.util.SecurityUtil;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
@Slf4j
@Transactional
public class ActivityService {

    private final UserRepository ur;
    int upIntelli = 3;
    int upHealth = 3;
    int upInterv = 3;



    @Autowired
    public ActivityService(UserRepository ur)
    {
        this.ur = ur;
    }




    public Chito doStudy()  {
        Optional<String> currentUsername = SecurityUtil.getCurrentUsername();
        User findUser = ur.findOneWithUserByUsername(currentUsername.get());
        Chito findChito = findUser.getChito();
        findChito.setIntelligence(findChito.getIntelligence() + upIntelli);
        findChito.setTimePoint(findChito.getTimePoint()-1);
        return findChito;
    }


    public Chito doWorkout() {
        Optional<String> currentUsername = SecurityUtil.getCurrentUsername();
        User findUser = ur.findOneWithUserByUsername(currentUsername.get());
        Chito findChito = findUser.getChito();
        findChito.setHealth(findChito.getHealth() + upHealth);
        findChito.setTimePoint(findChito.getTimePoint()-1);
        return findChito;
    }

    public Chito doInterview()
    {
        Optional<String> currentUsername = SecurityUtil.getCurrentUsername();
        User findUser = ur.findOneWithUserByUsername(currentUsername.get());
        Chito findChito = findUser.getChito();
        findChito.setSpeech(findChito.getSpeech() + upInterv);
        findChito.setTimePoint(findChito.getTimePoint()-1);
        return findChito;
    }
    
}
