package dev.restsql.student.entity;

// import javax.persistence.*;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name="STUDENT")
public class Student
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String studentName;
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(long id, String studentName, int age) {
        super();
        this.id = id;
        this.studentName = studentName;
        this.age = age;
    }

    public Student()
    {
        super();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", age=" + age +
                '}';
    }

}
