package mse.exam.tutorial.controller;

import mse.exam.tutorial.dto.LoginDto;
import mse.exam.tutorial.dto.TokenDto;
import mse.exam.tutorial.dto.UserDto;
import mse.exam.tutorial.entity.Authority;
import mse.exam.tutorial.entity.Chito;
import mse.exam.tutorial.entity.User;
import mse.exam.tutorial.jwt.TokenProvider;
import mse.exam.tutorial.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import static javax.security.auth.callback.ConfirmationCallback.OK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})//Junit5 를 사용할 때 문서 스니펫 생성의 첫번째 단계는
@Transactional
class AuthControllerTest {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthController authController;


    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }

    //controller 테스트 말고 더 작은 단위로 테스트를 해보자
    @Test
    @DisplayName("회원가입")
    void SignUp() throws Exception {
        //given

        String cont = "{\"username\":\"youngyun\",\"password\":\"54256\",\"nickname\":\"YYY\"}";
        //when
        //then

        mockMvc.perform(post("/api/signup").content(cont).contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("index"));

    }
    @Test
    @DisplayName("로그인")
    void LoginTest() {
        //given
        UserDto userDto = new UserDto("youngyun1", "54256", "YY");
        LoginDto loginDto = new LoginDto(userDto.getUsername(), userDto.getPassword());
        //when
        User user = userService.signup(userDto);
        Optional<User> savedUser = userService.getUserWithAuthorities(user.getUsername());

        //then
        ResponseEntity<TokenDto> authorize = authController.authorize(loginDto);
        assertThat(authorize).isNotNull();
    }

}
