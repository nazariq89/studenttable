package com.zariqmattproject.studenttable.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("Student")

public class Student extends AuditAbstract {
    @Id
    private String id;

    private String name;

    private boolean status;

    private int age;

    private String address;

    //constructor
    public Student(String id, String name, boolean status, int age, String address) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.age = age;
        this.address = address;
        this.setCreatedOn(new Date());

    }

    //Getter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isStatus() {
        return status;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }




    //setter
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    //to string
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
