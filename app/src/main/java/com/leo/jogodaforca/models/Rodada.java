package com.leo.jogodaforca.models;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

@Entity
public class Rodada {
    @Id private Long id;
    private ToOne<Jogador> jogadorToOne;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setJogadorToOne(ToOne<Jogador> jogadorToOne) {
        this.jogadorToOne = jogadorToOne;
    }

    public ToOne<Jogador> getJogadorToOne() {
        return jogadorToOne;
    }
}
