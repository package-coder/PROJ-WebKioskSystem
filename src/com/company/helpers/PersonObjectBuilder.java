package com.company.helpers;

import com.company.model.Person;

import java.time.LocalDate;

public class PersonObjectBuilder {

    private Person person = new Person();

    public Person build(){
        return person;
    }

    protected Person getPerson() {
        return person;
    }

    protected void setPerson(Person person) {
        this.person = person;
    }

    public static abstract class PersonNameObjectBuilder<T extends PersonNameObjectBuilder<T>>
            extends PersonObjectBuilder {
        public T firstName(String firstName){
            this.getPerson().setFirstName(firstName);
            return (T) this;
        }

        public T lastName(String lastName){
            this.getPerson().setLastName(lastName);
            return (T) this;
        }
    }

    public static abstract class PersonContactObjectBuilder<T extends PersonContactObjectBuilder<T>>
            extends PersonNameObjectBuilder<PersonContactObjectBuilder<T>> {
        public T address(String address){
            this.getPerson().setAddress(address);
            return (T) this;
        }

        public T contactNumber(String number){
            this.getPerson().setContact(number);
            return (T) this;
        }

        public T email(String email){
            this.getPerson().setEmail(email);
            return (T) this;
        }
    }

    public static abstract class PersonInfoObjectBuilder<T extends PersonInfoObjectBuilder<T>>
            extends PersonContactObjectBuilder<PersonInfoObjectBuilder<T>> {

        public T birthdate(LocalDate date){
            this.getPerson().setBirthDate(date);
            return (T) this;
        }

        public T age(int age){
            this.getPerson().setAge(age);
            return (T) this;
        }

        public T gender(boolean gender){
            this.getPerson().setGender(gender);
            return (T) this;
        }
    }
}


