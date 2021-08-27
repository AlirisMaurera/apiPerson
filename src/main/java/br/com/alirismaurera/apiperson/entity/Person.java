package br.com.alirismaurera.apiperson.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "cpf")})
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @CPF
    @Column(nullable = false, unique = true)
    private String cpf;

    private String birthDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE})
    private List<Phone> phone;
}
