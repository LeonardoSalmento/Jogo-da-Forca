package com.leo.jogodaforca.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

public class Rodada {
    private int numeroRodada;
    private static int incremento = 0;

    public Rodada() {
        this.numeroRodada = incremento++;
    }

    public Texto sortearPalavras(Box<Texto> textoBox, Box<Tema> temaBox) {
        Texto textoSorteado = null;
        List<Tema> temas = temaBox.getAll();

        Collections.shuffle(temas);
        long temaId = temas.get(0).getId();

        List<Texto> textos = textoBox.query().equal(Texto_.temaToOneId, temaId).build().find();

        Collections.shuffle(textos);

        textoSorteado = textos.get(0);

        return textoSorteado;
    }


    public Integer pontucaoRodada(boolean acertou, Integer qtdLetrasEscondidas){
        if (!acertou){
            return 0;
        }

        Integer pontuacao;

        pontuacao = qtdLetrasEscondidas * 15;
        return pontuacao;
    }
}
