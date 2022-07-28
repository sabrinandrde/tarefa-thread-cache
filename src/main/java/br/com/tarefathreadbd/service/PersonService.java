package br.com.tarefathreadbd.service;

import br.com.tarefathreadbd.entities.Person;
import br.com.tarefathreadbd.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    List<Person> cachedPeople = new ArrayList<>();

    @PostConstruct
    public void init() {
        new Thread(() -> {
            while (true) {
                LocalDateTime now = LocalDateTime.now();
                System.out.println(now.format(DateTimeFormatter.ISO_DATE_TIME));
                if (now.getHour() == 9) {
                    cachedPeople.addAll(personRepository.findAll());
                }
                try {
                    Thread.sleep(1000*60*60);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                    throw new RuntimeException();
                }
            }
        }).start();
    }

    public List<Person> searchPerson() {
        if (cachedPeople.isEmpty()) {
            return personRepository.findAll();
        }
        return cachedPeople;
    }

    public Person searchPerson(Long id) {return personRepository.findById(id).orElse(null);}


}
