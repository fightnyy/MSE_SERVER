package mse.exam.tutorial.dto;

import lombok.Getter;
import lombok.Setter;
import mse.exam.tutorial.entity.Group;
import mse.exam.tutorial.entity.User;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
public class QuestionDTO {

    private Long questionId;
    private String questionContent;
    private String s1Body;
    private String s2Body;
    private String s3Body;
    private String s4Body;
    private Integer ans;
    private String hint;
    private Date createdAt;
    private GroupDTO group;

}
