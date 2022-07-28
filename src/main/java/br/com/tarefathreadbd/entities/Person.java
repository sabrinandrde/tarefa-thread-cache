package br.com.tarefathreadbd.entities;

import com.sun.jdi.NativeMethodException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity(name = "pessoa")
public class Person {

    @Id
    @Column(name = "ID")
    private Long id;

    @Basic
    @Column(name = "NOME")
    private String name;


    @Basic
    @Column(name = "SOBRENOME")
    private String lastName;
}
