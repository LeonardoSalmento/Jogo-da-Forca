package com.leo.jogodaforca.models;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

/**
 * Created by Leo on 5/6/2018.
 */
@Entity
public class Jogador {
    @Id
    private Long id;
    private String nome;
    private Integer pontuacao;

    @Backlink
    private ToOne<Ranking> rankingToOne;

    public Jogador() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    public ToOne<Ranking> getRankingToOne() {
        return rankingToOne;
    }

    public void setRankingToOne(ToOne<Ranking> rankingToOne) {
        this.rankingToOne = rankingToOne;
    }
}
