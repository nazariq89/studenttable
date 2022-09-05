package com.zariqmattproject.studenttable.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "class")    //class

public class ClassAPI {
    @Autowired
    ClassRepo classRepo;

    @Autowired
    StudentRepo studentRepo;


    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Class addClass(@RequestBody Class classparam) {
        Optional<Class> classname = classRepo.findById("fddf");
        return classRepo.save(classparam);
    }

    @RequestMapping(value = "/listsclass", method = RequestMethod.GET)
    public List<Class> listallclass() {
        return classRepo.findAll();
    }

    @RequestMapping(value = "/find/{classId}", method = RequestMethod.GET)
    public Object getClassById(@PathVariable String classId) {
        Optional<Class> idclass = classRepo.findById(classId);
        if (idclass.isPresent()) {
            return idclass;
        } else {
            return "User not found.";
        }
    }




    @RequestMapping(value = "delete/{classId}" , method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable String classId) {
        Optional<Class> classtest= classRepo.findById(classId);   //1 find object id.
        if (classtest.isPresent()) {
            classRepo.deleteById(classId);
            return "Done delete the Id : " + classId ;
        } else {
            return "User not found.";
        }
    }




    @RequestMapping(value = "update/{clasId}" , method = RequestMethod.PUT)
    public String updateClass(@RequestBody Class classtestParam, @PathVariable String clasId) {
        Optional<Class> classx = classRepo.findById(clasId);
        if (classx.isPresent()) {
            classx.get().setName(classtestParam.getName());
            classx.get().setModifiedOn(new Date());
            classx.get().setStatus(classtestParam.isStatus());
            classRepo.save(classx.get());
            return "student : " + clasId + " updated" ;
        } else {
            return "User not found.";
        }
    }









}



