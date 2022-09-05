package com.zariqmattproject.studenttable.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/student")  //student

public class StudentAPI {

    @Autowired
     StudentRepo studentRepo;

    @Autowired
     ClassRepo classRepo;
//
//    public StudentAPI(StudentRepo studentRepo) {
//        this.studentRepo = studentRepo;
//    }
//    public StudentAPI(StudentRepo studentRepo) {
//        this.studentRepo = studentRepo;
//    }





    @RequestMapping(value = "/create/{classId}", method = RequestMethod.POST)
    public Student addNewStudent(@RequestBody Student studentParam , @PathVariable String classId) {
        Optional<Class> className = classRepo.findById(classId);
        if (!className.isPresent()){
            throw new RuntimeException("NOt FOUND");
        }

        Student student = studentRepo.save(studentParam);
        student.setClassModel(className.get());
        studentRepo.save(student);

        return student;
    }

    @RequestMapping(value = "/liststudent", method = RequestMethod.GET)
    public List<Student> listallstudent() {
        return studentRepo.findAll();

    }


    @RequestMapping(value = "/find/{Id}", method = RequestMethod.GET)
    public Object getStudentById(@PathVariable String Id) {
        Optional<Student> student = studentRepo.findById(Id);

        if (student.isPresent()) {
            return student.get();

        } else {
            return "User not found.";
        }
    }

    @RequestMapping(value = "delete/{Id}" , method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable String Id) {
        Optional<Student> student = studentRepo.findById(Id);   //1 find object id.
        if (student.isPresent()) {
            studentRepo.deleteById(Id);
            return "Done delete the Id : " + Id ;
        } else {
            return "User not found.";
        }
    }

    @RequestMapping(value = "update/{Id}" , method = RequestMethod.PUT)
    public String updateStudent(@RequestBody Student studentParam, @PathVariable String Id) {
        Optional<Student> student = studentRepo.findById(Id);
        if (student.isPresent()) {
            student.get().setAddress(studentParam.getAddress());
            student.get().setName(studentParam.getName());
            student.get().setAge(studentParam.getAge());
            student.get().setModifiedOn(new Date());
            student.get().setStatus(studentParam.isStatus());
            studentRepo.save(student.get());
            return "student : " + Id + " updated" ;
        } else {
            return "User not found.";
        }
    }
}


