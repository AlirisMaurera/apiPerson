package br.com.alirismaurera.apiperson.repository;

import br.com.alirismaurera.apiperson.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
