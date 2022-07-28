package br.com.tarefathreadbd.repository;

import br.com.tarefathreadbd.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
