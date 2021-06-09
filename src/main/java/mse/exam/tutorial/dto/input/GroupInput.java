package mse.exam.tutorial.dto.input;

import lombok.Getter;
import lombok.Setter;
import mse.exam.tutorial.entity.Question;

import java.util.List;

@Getter
@Setter
public class GroupInput {
    private Long groupId;
    private String name;
    private List<Question> questions;
}
