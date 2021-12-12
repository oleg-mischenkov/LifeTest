package com.mischenkov.dto;

import com.mischenkov.entity.Employee;
import com.mischenkov.entity.Task;

import java.util.List;
import java.util.Objects;

public class EmployeeDTO {

    private int id;
    private Employee employee;
    private List<Task> tasks;
    private int companyId;

    public int getId() {
        return id;
    }

    public EmployeeDTO setId(int id) {
        this.id = id;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public EmployeeDTO setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public EmployeeDTO setTasks(List<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

    public int getCompanyId() {
        return companyId;
    }

    public EmployeeDTO setCompanyId(int companyId) {
        this.companyId = companyId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO that = (EmployeeDTO) o;
        return id == that.id && companyId == that.companyId && employee.equals(that.employee) && tasks.equals(that.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee, tasks, companyId);
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", employee=" + employee +
                ", tasks=" + tasks +
                ", companyId=" + companyId +
                '}';
    }
}
