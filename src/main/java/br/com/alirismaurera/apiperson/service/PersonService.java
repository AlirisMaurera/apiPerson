package br.com.alirismaurera.apiperson.service;

import br.com.alirismaurera.apiperson.dto.response.MessageResponseDTO;
import br.com.alirismaurera.apiperson.entity.Person;
import br.com.alirismaurera.apiperson.mapper.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(@RequestBody Person person){
        Person savePerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Create Person with ID" + savePerson.getId())
                .build();
    }
}
