package com.leo.jogodaforca.models;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

/**
 * Created by Leo on 5/6/2018.
 */

@Entity
public class Texto {
    @Id
    private Long id;
    private String texto;
    private boolean ehFrase;

    private ToOne<Tema> temaToOne;

    public Texto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public ToOne<Tema> getTemaToOne() {
        return temaToOne;
    }

    public void setTemaToOne(ToOne<Tema> temaToOne) {
        this.temaToOne = temaToOne;
    }

    public void setEhFrase(boolean ehFrase) {
        this.ehFrase = ehFrase;
    }

    public boolean getEhFrase() {
        return ehFrase;
    }
}
