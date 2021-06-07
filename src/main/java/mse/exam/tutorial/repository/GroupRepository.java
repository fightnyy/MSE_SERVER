package mse.exam.tutorial.repository;

import mse.exam.tutorial.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group , Long> {
}
