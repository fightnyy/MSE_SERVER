package mse.exam.tutorial.entity;


import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;


@NoArgsConstructor(access= AccessLevel.PUBLIC)
@AllArgsConstructor
@Setter
@Getter
@Embeddable
@ToString
@Builder
public class Chito {


    private Integer timePoint=10;

    private Double grade=0.0;

    private Integer intelligence=50;

    private Integer health=50;

    private Integer speech=50;


}
