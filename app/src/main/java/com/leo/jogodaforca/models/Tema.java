package com.leo.jogodaforca.models;

import java.util.List;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

/**
 * Created by Leo on 5/6/2018.
 */

@Entity
public class Tema {
    @Id
    private Long id;
    private String nome;


    @Backlink
    private ToMany<Texto> textoToMany;

    public Tema() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public ToMany<Texto> getTextoToMany() {
        return textoToMany;
    }

    public void setTextoToMany(ToMany<Texto> textoToMany) {
        this.textoToMany = textoToMany;
    }
}
