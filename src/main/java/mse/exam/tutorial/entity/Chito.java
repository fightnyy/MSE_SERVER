package mse.exam.tutorial.entity;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Embeddable;


@NoArgsConstructor(access= AccessLevel.PUBLIC)
@AllArgsConstructor
@Setter
@Getter
@Embeddable
@ToString
@Builder
@Slf4j
public class Chito {


    private Integer timePoint=10;

    private Double grade=0.0;

    private Integer intelligence=50;

    private Integer health=50;

    private Integer speech=50;


    public void setTimePoint(Integer timePoint) {
        if (timePoint>0) {
            this.timePoint = timePoint;
        }
        else {
            log.warn("Chito의 TimePoint가 0이하 입니다. timepoint : {}",timePoint);
        }
    }
}
