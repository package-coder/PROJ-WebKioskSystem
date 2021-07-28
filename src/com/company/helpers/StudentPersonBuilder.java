package com.company.helpers;

import com.company.interfaces.PersonBuilder;
import com.company.model.StudentPerson;

public class StudentPersonBuilder<T extends StudentPersonBuilder<T>>
        extends PersonBuilder.PersonInfoBuilder<StudentPersonBuilder<T>> {

    public StudentPersonBuilder() {
        this.setObject(new StudentPerson());
    }

    public T studentId(String studentId){
        var person = (StudentPerson) this.getObject();
        person.setStudentId(studentId);
        return (T) this;
    }

    public T course(String course){
        var person = (StudentPerson) this.getObject();
        person.setCourse(course);
        return (T) this;
    }

    public T college(String college){
        var person = (StudentPerson) this.getObject();
        person.setCollege(college);
        return (T) this;
    }

    public T level(int yearLevel){
        var person = (StudentPerson) this.getObject();
        person.setYearLevel(yearLevel);
        return (T) this;
    }
}
