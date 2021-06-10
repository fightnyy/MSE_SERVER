package mse.exam.tutorial.controller;

import lombok.extern.slf4j.Slf4j;
import mse.exam.tutorial.entity.User;
import mse.exam.tutorial.repository.UserRepository;
import mse.exam.tutorial.util.SecurityUtil;
import mse.exam.tutorial.dto.HintDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@PreAuthorize("isAuthenticated()")
@Transactional
@Slf4j
public class HintController {
    
    private UserRepository ur;
    
    @Autowired
    public HintController(UserRepository ur){
        this.ur = ur;
    }
    
    @PostMapping(value = "/hint", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveHint(HintDto hint)
    {
        log.error("HELLO : " + hint);
        Optional<String> currentUsername = SecurityUtil.getCurrentUsername();
        User findUser = ur.findOneWithUserByUsername(currentUsername.get());
        findUser.setHint(hint.getNum());
    }
}
