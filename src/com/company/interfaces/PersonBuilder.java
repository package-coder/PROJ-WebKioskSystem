package com.company.interfaces;

import com.company.model.Person;

import java.time.LocalDate;

public abstract class PersonBuilder<T extends PersonBuilder<T>>
    extends Builder<Person>{

    public static abstract class PersonNameBuilder<T extends PersonNameBuilder<T>>
             extends PersonBuilder<PersonNameBuilder<T>> {
        public T firstName(String firstName){
            this.getObject().setFirstName(firstName);
            return (T) this;
        }

        public T lastName(String lastName){
            this.getObject().setLastName(lastName);
            return (T) this;
        }
    }

    public static abstract class PersonContactBuilder<T extends PersonContactBuilder<T>>
            extends PersonNameBuilder<PersonContactBuilder<T>> {
        public T address(String address){
            this.getObject().setAddress(address);
            return (T) this;
        }

        public T contactNumber(String number){
            this.getObject().setContact(number);
            return (T) this;
        }

        public T email(String email){
            this.getObject().setEmail(email);
            return (T) this;
        }
    }

    public static abstract class PersonInfoBuilder<T extends PersonInfoBuilder<T>>
            extends PersonContactBuilder<PersonInfoBuilder<T>> {

        public T birthdate(LocalDate date){
            this.getObject().setBirthDate(date);
            return (T) this;
        }

        public T age(int age){
            this.getObject().setAge(age);
            return (T) this;
        }

        public T gender(boolean gender){
            this.getObject().setGender(gender);
            return (T) this;
        }
    }

}


