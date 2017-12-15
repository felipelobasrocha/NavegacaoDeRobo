package com.navegacaoDeTerreno.domain.robo.movimento.deslocamento;

import org.springframework.stereotype.Service;
import com.navegacaoDeTerreno.domain.terreno.Terreno;
import com.navegacaoDeTerreno.domain.robo.*;

@Service
public class MovimentoParaSul extends Movimento {
    public PosicaoRobo moverPara(Robo robo, Terreno terreno){
        PosicaoRobo posicao = robo.obterPosicaoRobo();
        try {
            Integer coordenada = posicao.obterCoordenadaY();
            if (coordenada <= 0){
                throw new IllegalArgumentException("Posição inválida.");
            }
            posicao.alterarCoordenadaY(coordenada-1);        
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } 

        return posicao;
    }      
}