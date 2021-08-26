package br.com.alirismaurera.apiperson.controller;

import br.com.alirismaurera.apiperson.dto.response.response.MessageResponseDTO;
import br.com.alirismaurera.apiperson.dto.response.request.PersonDTO;
import br.com.alirismaurera.apiperson.exception.PersonNotFoundException;
import br.com.alirismaurera.apiperson.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){

        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return  personService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateByID(@PathVariable Long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException {

        return personService.updateByID(id, personDTO);

    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByID(@PathVariable Long id) throws PersonNotFoundException {
       personService.delete(id);

    }




}
