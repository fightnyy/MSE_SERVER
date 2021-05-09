package mse.exam.tutorial.entity;


import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;


@NoArgsConstructor(access= AccessLevel.PUBLIC)
@AllArgsConstructor
@Setter
@Getter
@Embeddable

public class Chito {

    private Integer timePoint;
    private Double grade;
    private Integer intelligence;
    private Integer health;
    private Integer speech;


}
