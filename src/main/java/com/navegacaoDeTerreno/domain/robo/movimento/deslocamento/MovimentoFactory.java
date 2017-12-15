package com.navegacaoDeTerreno.domain.robo.movimento.deslocamento;

import java.util.Map;
import com.navegacaoDeTerreno.domain.robo.PosicaoRobo;
import com.navegacaoDeTerreno.domain.terreno.Terreno;

public final class MovimentoFactory {
    private MovimentoFactory(){
        
    }

    public static Movimento criar(PosicaoRobo posicao, Terreno terreno){
        try {
            Map<Integer, String> direcoes = terreno.obterDirecoes();
            String direcao = posicao.obterDirecao();

            if (direcao.equals(direcoes.get(1))){
                return new MovimentoParaNorte();
            }
            if (direcao.equals(direcoes.get(2))){
                return new MovimentoParaLeste();
            }                        
            if (direcao.equals(direcoes.get(3))){
                return new MovimentoParaSul();
            }
            if (direcao.equals(direcoes.get(4))){
                return new MovimentoParaOeste();
            }            

            throw new NullPointerException();
        } catch (Exception e) {
            throw e;
        }    
    }
}