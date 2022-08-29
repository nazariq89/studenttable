package com.zariqmattproject.studenttable.model;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/student")

public class StudentAPI {

    @Autowired
    private StudentRepo studentRepo;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Student addNewStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    @RequestMapping (value = "/liststudent", method = RequestMethod.GET)
    public List<Student> listallstudent() {
        return studentRepo.findAll();

    }



    }

