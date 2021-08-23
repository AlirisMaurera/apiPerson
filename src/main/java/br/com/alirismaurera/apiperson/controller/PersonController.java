package br.com.alirismaurera.apiperson.controller;

import br.com.alirismaurera.apiperson.dto.response.MessageResponseDTO;
import br.com.alirismaurera.apiperson.entity.Person;
import br.com.alirismaurera.apiperson.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {


    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){

        return personService.createPerson(person);
    }


}
