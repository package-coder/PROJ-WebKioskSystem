package com.company.helpers;

import com.company.interfaces.PersonBuilder;
import com.company.model.ParentPerson;
import com.company.model.StudentPerson;

import java.util.List;

public class ParentPersonBuilder<T extends ParentPersonBuilder<T>>
    extends PersonBuilder.PersonInfoBuilder<ParentPersonBuilder<T>> {

    public ParentPersonBuilder() {
        this.setObject(new ParentPerson());
    }

    public T parentId(String parentId){
        var person = (ParentPerson) this.getObject();
        person.setParentId(parentId);
        return (T) this;
    }

    public T occupation(String occupation){
        var person = (ParentPerson)this.getObject();
        person.setOccupation(occupation);
        return (T) this;
    }

    public T degree(String degree){
        var person = (ParentPerson)this.getObject();
        person.setDegree(degree);
        return (T) this;
    }

    public T lastSchool(String lastSchool){
        var person = (ParentPerson)this.getObject();
        person.setLastSchool(lastSchool);
        return (T) this;
    }

    public T civilStatus(String status){
        var person = (ParentPerson)this.getObject();
        person.setCivilStatus(status);
        return (T) this;
    }

    public T childrenStudentId(List<String> list){
        var person = (ParentPerson)this.getObject();
        person.setChildrenId(list);
        return (T) this;
    }
}
