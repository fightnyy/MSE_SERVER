package mse.exam.tutorial.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mse.exam.tutorial.entity.User;

@Getter
@Setter
public class QuestionInput {

    private Long groupId;
    private String questionContent;
    private String s1Body;
    private String s2Body;
    private String s3Body;
    private String s4Body;
    private Integer ans;
    private String hint;
    private User createdBy;
}
