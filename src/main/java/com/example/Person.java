package com.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Parameters;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Person extends PanacheEntity {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static List<Person> findAllByFirstName(String firstName) {
        return Person.find("firstName", firstName).list();
    }

    public static Person findByFirstNameAndLastName(String firstName, String lastName) {
        return Person.find("firstName = :firstName and lastName = :lastName", Parameters.with("firstName", firstName
        ).and("lastName", lastName).map()).firstResult();
    }
}
