package mse.exam.tutorial.dto.initial;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GroupsJsonDTO {
    @JsonProperty("gid")
    private long groupId;
    @JsonProperty("g_name")
    private String groupName;
    @JsonProperty("problems")
    private List<QuestionJsonDTO> questions;
}
