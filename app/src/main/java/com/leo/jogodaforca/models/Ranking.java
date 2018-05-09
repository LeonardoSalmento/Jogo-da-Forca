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
public class Ranking {
    @Id
    private Long id;

    @Backlink
    private ToMany<Jogador> jogadorToMany;

    public Ranking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ToMany<Jogador> getJogadorToMany() {
        return jogadorToMany;
    }

    public void setJogadorToMany(ToMany<Jogador> jogadorToMany) {
        this.jogadorToMany = jogadorToMany;
    }
}
