package br.com.tarefathreadbd.controller;

import br.com.tarefathreadbd.entities.Person;
import br.com.tarefathreadbd.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    PersonService personService; //atributo

    @GetMapping
    @ResponseBody
    public List<Person> searchPerson(){
        return personService.searchPerson();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Person searchPerson(@PathVariable Long id) {return personService.searchPerson(id);}
}
