package com.zariqmattproject.studenttable.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;

@Document("Student")
@SuppressWarnings("serial")
public class Student extends AuditAbstract {
    @Id
    private String id;

    private String name;

    private boolean status;

    private int age;

    private String address;



    @ManyToOne(fetch = FetchType.LAZY, optional = false , cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id", nullable = false)
    //@JsonIgnore
    private Class classModel;

    public Student(String id, String name, boolean status, int age, String address ) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.age = age;
        this.address = address;
        this.setCreatedOn(new Date());
    }

    public Class getClassModel() {
        return classModel;
    }

    public void setClassModel(Class classModel) {
        this.classModel = classModel;
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

    @Override
    public String toString() {
        return "Student{" +"\n"+
                "id='" + id + '\'' + "\n"+
                "name='" + name + '\'' + "\n"+
                "status=" + status + "\n"+
                "age=" + age + "\n"+
                "address='" + address + '\'' +"\n"+
                '}';
    }
}
