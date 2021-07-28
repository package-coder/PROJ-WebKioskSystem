package com.company.model;

import com.company.helpers.StudentPersonBuilder;

public class StudentPerson extends Person{

    private static StudentBuilder studentBuilder = null;

    private String course;
    private String college;
    private int yearLevel;
    private String studentId;

    public static StudentBuilder getStudentBuilder() {
        if(studentBuilder == null)
            studentBuilder = new StudentBuilder();
        return studentBuilder;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public static class StudentBuilder extends StudentPersonBuilder<StudentBuilder> {
        private StudentBuilder(){}
    }
}
