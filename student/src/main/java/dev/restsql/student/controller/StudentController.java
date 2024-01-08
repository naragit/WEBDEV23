package dev.restsql.student.controller;

import dev.restsql.student.entity.Student;
import dev.restsql.student.repo.StudentInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentInter studentInter;
    @PostMapping("/api/students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student)
    {
       return new ResponseEntity<>(studentInter.save(student), HttpStatus.CREATED);
    }

    @GetMapping("/api/students")
    public ResponseEntity<List <Student>> getStudents()
    {
        return new ResponseEntity<>(studentInter.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id)
    {
        Optional <Student> student = studentInter.findById(id);
        if (student.isPresent())
        {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/api/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student stud)
    {
        Optional <Student> student = studentInter.findById(id);
        if (student.isPresent())
        {
            student.get().setStudentName(stud.getStudentName());
            student.get().setAge(stud.getAge());
            return new ResponseEntity<>(studentInter.save(student.get()), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id)
    {
        Optional <Student> student = studentInter.findById(id);
        if (student.isPresent())
        {
            studentInter.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
