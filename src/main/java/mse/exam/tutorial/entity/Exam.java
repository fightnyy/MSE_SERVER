package mse.exam.tutorial.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "exams")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Exam implements Serializable {

    @Id
    @Column(name = "GID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long groupId;

    @Column(name = "NUM_PROBLEM")
    private String numPrograms;

//    @OneToMany(mappedBy = "CUT_OFF", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private int[] grades;
}
