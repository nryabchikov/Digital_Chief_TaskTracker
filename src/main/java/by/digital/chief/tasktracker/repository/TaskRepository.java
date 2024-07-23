package by.digital.chief.tasktracker.repository;

import by.digital.chief.tasktracker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProjectId(Long projectId);
    Optional<Task> findByIdAndProjectId(Long taskId, Long projectId);
}

