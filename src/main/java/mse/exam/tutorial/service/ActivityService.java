package mse.exam.tutorial.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mse.exam.tutorial.entity.Chito;
import mse.exam.tutorial.entity.User;
import mse.exam.tutorial.repository.UserRepository;
import mse.exam.tutorial.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ActivityService {

    private final UserRepository ur;

    public Chito doStudy()  {
        Optional<String> currentUsername = SecurityUtil.getCurrentUsername();
        int upIntelli = 3;

        User findUser = ur.findOneWithUserByUsername(currentUsername.get());
        Chito findChito = findUser.getChito();
        findChito.setIntelligence(findChito.getIntelligence() + upIntelli);
        return findChito;
    }
    
}
