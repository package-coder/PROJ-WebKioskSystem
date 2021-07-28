package com.company.model;

import com.company.helpers.ParentPersonBuilder;

import java.util.ArrayList;
import java.util.List;

public class ParentPerson extends Person{

    private static ParentBuilder parentBuilder = null;

    private String occupation;
    private String degree;
    private String lastSchool;
    private String civilStatus;
    private List<String> childrenId = new ArrayList<>();
    private String parentId;

    public static ParentBuilder getParentBuilder() {
        if(parentBuilder == null)
            parentBuilder = new ParentBuilder();
        return parentBuilder;
    }

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

    public void setChildrenId(List<String> childrenId) {
        this.childrenId = childrenId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public static class ParentBuilder extends ParentPersonBuilder<ParentBuilder> {
        private ParentBuilder(){}
    }
}
