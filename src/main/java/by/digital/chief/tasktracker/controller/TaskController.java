package by.digital.chief.tasktracker.controller;

import by.digital.chief.tasktracker.model.Task;
import by.digital.chief.tasktracker.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects/{projectId}/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<Task> getAllTasksByProjectId(@PathVariable Long projectId) {
        return taskService.getAllTasksByProjectId(projectId);
    }

    @GetMapping("/{taskId}")
    public Task getTaskByIdAndProjectId(@PathVariable Long projectId, @PathVariable Long taskId) {
        return taskService.getTaskByIdAndProjectId(taskId, projectId);
    }

    @PostMapping
    public Task createTask(@PathVariable Long projectId, @RequestBody Task task) {
        return taskService.addTask(projectId, task);
    }

    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable Long projectId, @PathVariable Long taskId, @RequestBody Task taskDetails) {
        return taskService.updateTask(projectId, taskId, taskDetails);
    }

    @PatchMapping("/{taskId}")
    public Task moveTask(@PathVariable Long projectId, @PathVariable Long taskId, @RequestParam Long newProjectId) {
        return taskService.moveTaskToAnotherProject(projectId, taskId, newProjectId);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long projectId, @PathVariable Long taskId) {
        taskService.deleteTask(projectId, taskId);
        return ResponseEntity.noContent().build();
    }
}
