package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class ParentPerson extends Person{
    private String occupation;
    private String degree;
    private String lastSchool;
    private String civilStatus;
    private final List<String> childrenId = new ArrayList<>();

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
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

    public List<String> getChildrenId() {
        return childrenId;
    }
}
