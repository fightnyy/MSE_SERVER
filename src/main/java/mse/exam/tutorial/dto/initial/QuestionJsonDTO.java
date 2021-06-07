package mse.exam.tutorial.dto.initial;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QuestionJsonDTO {
    private long id;
    @JsonProperty("q_body")
    private String questionBody;
    @JsonProperty("s1_body")
    private String selectionBody1;
    @JsonProperty("s2_body")
    private String selectionBody2;
    @JsonProperty("s3_body")
    private String selectionBody3;
    @JsonProperty("s4_body")
    private String selectionBody4;
    @JsonProperty("ans")
    private int answer;
    private String hint;
}
