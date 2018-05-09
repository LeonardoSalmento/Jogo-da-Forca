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

    public List<Texto> sortearPalavras(Box<Texto> textoBox, Box<Tema> temaBox) {
        List<Texto> textosSorteados = new ArrayList<Texto>();
        List<Tema> temas = temaBox.getAll();
        int contador = 0;

        Collections.shuffle(temas);
        long temaId = temas.get(0).getId();

        List<Texto> textos = textoBox.query().equal(Texto_.temaToOneId, temaId).build().find();

        Collections.shuffle(textos);

        for(int i = 0; i < textos.size(); i++) {
            if(!textos.get(i).getEhFrase()) {
                textosSorteados.add(textos.get(i));
                contador++;

                if(contador == 3) {
                    break;
                }
            }

            else {
                textosSorteados.add(textos.get(i));
                break;
            }
        }

        return textosSorteados;
    }
    
    public Integer pontucaoRodada(boolean acertou, Integer qtdLetrasEscondidas){
    	if (!acertou){
    		return 0;
    	}
    	Integer pontuacao;
    	
    	pontuacao = qtdLetrasEscondidas * 15;
    	return pontuacao;
    }
    
    public Integer pontuacaoTotal(Integer pontuacaoAnterior, Integer pontuacaoRodada){
    	Integer somaPontuacao;
    	somaPontuacao = pontuacaoAnterior + pontuacaoRodada;
    	return somaPontuacao;
    }
}
