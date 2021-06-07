package mse.exam.tutorial.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "question")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Question implements Serializable {

    //Column in Database
    @Id
    @Column(name = "QUESTION_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long questionId;

    @Column(name = "Q_BODY", length = 512, nullable = false)
    private String questionContent;

    @Column(name = "S1_BODY", length = 512, nullable = false)
    private String s1Body;

    @Column(name = "S2_BODY", length = 512, nullable = false)
    private String s2Body;

    @Column(name = "S3_BODY", length = 512)
    private String s3Body;

    @Column(name = "S4_BODY", length = 512)
    private String s4Body;

    @Column(name = "ANS")
    private Integer ans;

    @Column(name = "HINT", length = 512)
    private String hint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User createdBy;

    @Column(name = "CREATED_AT")
    private Date createdAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID")
    private Group group;

}
