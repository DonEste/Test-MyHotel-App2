package com.test2.test2MyHotel.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "job_history")
@IdClass(JobHistoryId.class)
public class JobHistory{

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @Id
    @JsonBackReference
    private Employee employee;
    @Id
    private Timestamp startDate;
    private Timestamp endDate;
    private String jobId;
    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;
    
    public JobHistory() {
    }

    public JobHistory(Employee employee, Timestamp startDate, Timestamp endDate, String jobId, Department department) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobId = jobId;
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
