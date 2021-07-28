package com.company.helpers;

import com.company.interfaces.PersonBuilder;
import com.company.model.FacultyPerson;
import com.company.model.StudentPerson;

public class FacultyPersonBuilder<T extends FacultyPersonBuilder<T>>
    extends PersonBuilder.PersonInfoBuilder<FacultyPersonBuilder<T>> {

    public FacultyPersonBuilder() {
        this.setObject(new FacultyPerson());
    }

    public T facultyId(String facultyId){
        var person = (FacultyPerson) this.getObject();
        person.setFacultyId(facultyId);
        return (T) this;
    }

    public T department(String department) {
        var person = (FacultyPerson) this.getObject();
        person.setDepartment(department);
        return (T) this;
    }

    public T degree(String degree) {
        var person = (FacultyPerson) this.getObject();
        person.setDegree(degree);
        return (T) this;
    }

    public T lastSchool(String lastSchool) {
        var person = (FacultyPerson) this.getObject();
        person.setLastSchool(lastSchool);
        return (T) this;
    }

    public T civilStatus(String status) {
        var person = (FacultyPerson) this.getObject();
        person.setCivilStatus(status);
        return (T) this;
    }
}
