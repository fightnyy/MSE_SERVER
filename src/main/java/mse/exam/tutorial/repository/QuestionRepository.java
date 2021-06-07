package mse.exam.tutorial.repository;

import mse.exam.tutorial.entity.Group;
import mse.exam.tutorial.entity.Question;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question , Long> {
    List<Question> findAllByGroup(Group group);

    @Query(value = "select * from question where 1=1", nativeQuery = true)
    List<Question> findAllQuestion(Pageable pageable);

    @Query(value = "select * from question where 1=1 and GROUP_ID = ?", nativeQuery = true)
    List<Question> findAllQuestionByGroupId(Long groupId);
}
