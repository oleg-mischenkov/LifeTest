package com.mischenkov.dto;

import com.mischenkov.entity.Task;

import java.util.Objects;

public class TaskDTO {

    private int id;
    private Task task;
    private int employeeId;

    public int getId() {
        return id;
    }

    public TaskDTO setId(int id) {
        this.id = id;
        return this;
    }

    public Task getTask() {
        return task;
    }

    public TaskDTO setTask(Task task) {
        this.task = task;
        return this;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public TaskDTO setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return id == taskDTO.id && employeeId == taskDTO.employeeId && task.equals(taskDTO.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, task, employeeId);
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", task=" + task +
                ", employeeId=" + employeeId +
                '}';
    }
}
