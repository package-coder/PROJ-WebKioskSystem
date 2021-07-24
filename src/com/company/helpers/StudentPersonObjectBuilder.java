package com.company.helpers;

import com.company.model.StudentPerson;

public class StudentPersonObjectBuilder<T extends StudentPersonObjectBuilder<T>>
        extends PersonObjectBuilder.PersonInfoObjectBuilder<StudentPersonObjectBuilder<T>> {

    public StudentPersonObjectBuilder() {
        this.setPerson(new StudentPerson());
    }


    public static abstract class StudentPersonSchoolInfoObjectBuilder<T extends StudentPersonSchoolInfoObjectBuilder<T>>
        extends StudentPersonObjectBuilder<StudentPersonSchoolInfoObjectBuilder<T>> {

        public T course(String course){
            var person = (StudentPerson) this.getPerson();
            person.setCourse(course);
            return (T) this;
        }

        public T college(String college){
            var person = (StudentPerson) this.getPerson();
            person.setCollege(college);
            return (T) this;
        }

        public T level(int yearLevel){
            var person = (StudentPerson) this.getPerson();
            person.setYearLevel(yearLevel);
            return (T) this;
        }
    }

}
