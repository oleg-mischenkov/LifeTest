package com.mischenkov.dto;

import com.mischenkov.entity.Company;
import com.mischenkov.entity.Employee;

import java.util.List;
import java.util.Objects;

public class CompanyDTO {

    private int id;
    private Company company;
    private List<Employee> employees;

    public int getId() {
        return id;
    }

    public CompanyDTO setId(int id) {
        this.id = id;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public CompanyDTO setCompany(Company company) {
        this.company = company;
        return this;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public CompanyDTO setEmployees(List<Employee> employees) {
        this.employees = employees;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyDTO that = (CompanyDTO) o;
        return id == that.id && company.equals(that.company) && employees.equals(that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, employees);
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id=" + id +
                ", company=" + company +
                ", employees=" + employees +
                '}';
    }
}
