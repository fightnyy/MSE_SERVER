package mse.exam.tutorial.controller;

import mse.exam.tutorial.dto.UserDto;
import mse.exam.tutorial.entity.Chito;
import mse.exam.tutorial.entity.User;
import mse.exam.tutorial.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Rollback(value = false)
@WithUserDetails(value = "user1")
@Transactional
public class ActivityControllerTest {
    static final Logger log = LoggerFactory.getLogger(ActivityControllerTest.class);
    @Autowired ActivityController ac;
    @Autowired UserService userService;
    User loginUser;

    @BeforeTransaction
    public void afterLogin()
    {
        if (!userService.getUserWithAuthorities("user1").isPresent()) {
            UserDto userDto = new UserDto("user1", "user1", "nick_user");
            loginUser = userService.signup(userDto);
        }
    }

    @Test
    @DisplayName("공부하기")
    public void studyTest()
    {
        Chito outChito = ac.doStudy();
        log.error("outChito = {}", outChito);
        if (userService.getUserWithAuthorities("loginUser").isPresent()) {
            loginUser = userService.getUserWithAuthorities("loginUser").get();
        }
        assertThat(outChito.getIntelligence()).isEqualTo(53);
    }


    @Test
    @DisplayName("운동하기")
    public void doExercise()
    {
        Chito outChito = ac.doWorkout();
        log.debug("outChito = {}", outChito);
        if (userService.getUserWithAuthorities("loginUser").isPresent()) {
            loginUser = userService.getUserWithAuthorities("loginUser").get();
        }
        assertThat(outChito.getHealth()).isEqualTo(53);
    }

    @Test
    @DisplayName("인터뷰하기")
    public void doInterview()
    {
        Chito outChito = ac.doInterview();
        log.debug("outChito = {}",outChito);
        if (userService.getUserWithAuthorities("loginUser").isPresent()) {
            loginUser = userService.getUserWithAuthorities("loginUser").get();
        }
        assertThat(outChito.getSpeech()).isEqualTo(53);
//        assertThat(loginUser.getChito().getSpeech()).isEqualTo(53);
    }

}
