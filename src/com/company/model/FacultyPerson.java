package com.company.model;

import com.company.helpers.FacultyPersonBuilder;

public class FacultyPerson extends Person{

    private static FacultyBuilder facultyBuilder = null;

    private String department;
    private String degree;
    private String lastSchool;
    private String civilStatus;
    private String facultyId;

    public static FacultyBuilder getFacultyBuilder() {
        if(facultyBuilder == null)
            facultyBuilder = new FacultyBuilder();
        return facultyBuilder;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getLastSchool() {
        return lastSchool;
    }

    public void setLastSchool(String lastSchool) {
        this.lastSchool = lastSchool;
    }

    public String getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public static class FacultyBuilder extends FacultyPersonBuilder<FacultyBuilder>{
        private FacultyBuilder(){}
    }
}
