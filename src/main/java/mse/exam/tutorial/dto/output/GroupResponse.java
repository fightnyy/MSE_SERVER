package mse.exam.tutorial.dto.output;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupResponse {
    private List<GroupOutput> groups;
}
