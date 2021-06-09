package mse.exam.tutorial.dto.initial;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class ExamsJsonDTO {
    @JsonProperty("gid")
    private long groupId;

    @JsonProperty("num_problem")
    private String numProblems;

    @JsonProperty("cut_off")
    private int [] cutOff;
}
