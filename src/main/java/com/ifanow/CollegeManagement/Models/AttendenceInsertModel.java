package com.ifanow.CollegeManagement.Models;

import org.springframework.stereotype.Component;


public class AttendenceInsertModel {
    int studentId;
    //float attdendencePercentage
    String studentName,department,loginTime,logoutTime;

    public AttendenceInsertModel(int studentId, String studentName, String department, String loginTime, String logoutTime) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;

    }


    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDepartment() {
        return department;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public void setLogoutTime(String logoutTime) {
        this.logoutTime = logoutTime;
    }


}
