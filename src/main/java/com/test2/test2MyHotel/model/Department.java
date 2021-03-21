package com.test2.test2MyHotel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue
    private int departmentId;
    private String departmentName;
    private int managerId;
    @ManyToOne
    @JoinColumn(name = "location_id")
    @JsonBackReference
    private Location location;
    @OneToMany(targetEntity = Employee.class, mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees = new ArrayList<>();
    @OneToMany(targetEntity = JobHistory.class, mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobHistory> jobHistories = new ArrayList<>();

    public Department() {
    }

    public Department(int departmentId, String departmentName, int managerId, Location location) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerId = managerId;
        this.location = location;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<JobHistory> getJobHistories() {
        return jobHistories;
    }

    public void setJobHistories(List<JobHistory> jobHistories) {
        this.jobHistories = jobHistories;
    }

}
