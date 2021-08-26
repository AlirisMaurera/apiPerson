package br.com.alirismaurera.apiperson.service;

import br.com.alirismaurera.apiperson.dto.response.response.MessageResponseDTO;
import br.com.alirismaurera.apiperson.dto.response.request.PersonDTO;
import br.com.alirismaurera.apiperson.entity.Person;
import br.com.alirismaurera.apiperson.exception.PersonNotFoundException;

import br.com.alirismaurera.apiperson.dto.response.mapper.PersonMapper;
import br.com.alirismaurera.apiperson.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }



    public PersonDTO findById(Long id) throws PersonNotFoundException {
       Person person =  verifyExists(id);
        return personMapper.toDTO(person);
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savePerson = personRepository.save(personToSave);
        return  createMessageResponse(savePerson.getId(), "Create Person with ID");

    }

    public List<PersonDTO> listAll() {
        List<Person> allpeople = personRepository.findAll();
        return allpeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void delete(Long id) throws PersonNotFoundException {
       verifyExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateByID(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);

        Person UpdatePerson = personRepository.save(personToUpdate);
        return createMessageResponse(UpdatePerson.getId(), "Update person with ID");
    }

    private MessageResponseDTO createMessageResponse(Long id, String s) {

        return MessageResponseDTO
                .builder()
                .message(s + id)
                .build();
    }
    private Person verifyExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

    }
}
