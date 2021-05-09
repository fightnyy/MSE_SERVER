package mse.exam.tutorial.controller;

import mse.exam.tutorial.entity.Chito;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserControllerTest {

    @Autowired ActivityController ac;

    @Test
    @DisplayName("공부하기")
    public void studyTest()
    {

        Chito chito = ac.doStudy();
    }
}
