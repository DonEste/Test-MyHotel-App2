package com.test2.test2MyHotel.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class JobHistoryId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Employee employee;
    private Timestamp startDate;

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

}
