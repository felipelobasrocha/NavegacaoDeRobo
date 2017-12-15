package com.navegacaoDeTerreno.domain.robo.movimento.comando;

import org.springframework.stereotype.Service;

import com.navegacaoDeTerreno.domain.terreno.Terreno;
import com.navegacaoDeTerreno.domain.robo.*;
import com.navegacaoDeTerreno.domain.robo.movimento.deslocamento.*;

@Service
public class ComandoParaFrente extends Comando {

    @Override
    public PosicaoRobo comandarRobo(Robo robo, Terreno terreno){
        PosicaoRobo posicao = robo.obterPosicaoRobo();
        try {
            Movimento movimento = MovimentoFactory.criar(posicao, terreno);
            posicao = movimento.moverPara(robo, terreno);
            posicao.statusPosicaoRobo = PosicaoStatus.ULTIMA.toString();

        } catch (Exception e) {
            throw e;
        }

        return posicao;
    }
}