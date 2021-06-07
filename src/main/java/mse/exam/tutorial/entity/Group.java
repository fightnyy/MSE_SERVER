package mse.exam.tutorial.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group implements Serializable {

    @Id
    @Column(name = "GROUP_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long groupId;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question> questions;
}
