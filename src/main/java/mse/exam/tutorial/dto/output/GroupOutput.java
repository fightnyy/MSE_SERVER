package mse.exam.tutorial.dto.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupOutput {
    private Long groupId;
    private String name;
    private Integer numProblems;
}
