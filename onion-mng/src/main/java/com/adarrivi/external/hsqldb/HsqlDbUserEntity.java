package com.adarrivi.external.hsqldb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
class HsqlDbUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private int age;

    HsqlDbUserEntity() {
        // Needed by spring
    }

    HsqlDbUserEntity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

}
