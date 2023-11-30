package dev.utils.controller;

import dev.utils.model.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personapi")
public class PersonGateway {

    Person personObj = new Person();

    @GetMapping("{id}")
    public Person getPersonDetails(String id)  {
        return new Person("1002","DefaultPerson");
    }

    @GetMapping("")
    public Person getPersonDetails()  {
        return personObj;
    }

    @PostMapping
    public String setPersonDetail(@RequestBody Person personObj) {
        this.personObj = personObj;
        System.out.println(" Record Successfully Created ");
        return "{Record Created}";
    }

    @PutMapping
    public String updatePersonDetail(@RequestBody Person personObj) {
        this.personObj = personObj;
        System.out.println(" Updated Record Successfully ");
        return  "{Record Updated}";
    }

    @DeleteMapping("{id}")
    public String deletePersonDetails(String id)  {
        this.personObj = null;
        return "Deleted Successfully";
    }

}
