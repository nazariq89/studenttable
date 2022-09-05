package com.zariqmattproject.studenttable.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Class extends AuditAbstract {
    @Id
    private String id;
    private String name;
    private boolean status;

    private List<Student> student;
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isStatus() {
        return status;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Class(String id, String name, boolean status, List<Student> student) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.student = student;
        this.setCreatedOn(new Date());
    }

    @Override
    public String toString() {
        return "Class{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}