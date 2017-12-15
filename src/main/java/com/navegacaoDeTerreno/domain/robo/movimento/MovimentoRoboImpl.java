package com.navegacaoDeTerreno.domain.robo.movimento;

import org.springframework.stereotype.Service;

import com.navegacaoDeTerreno.domain.robo.*;
import com.navegacaoDeTerreno.domain.robo.movimento.comando.*;
import com.navegacaoDeTerreno.domain.terreno.Terreno;

@Service
public class MovimentoRoboImpl implements MovimentoRobo {
    
    public PosicaoRobo movimentarRobo(String movimento, Robo robo, Terreno terreno){
        PosicaoRobo posicao = robo.obterPosicaoRobo();
        try {
            Comando comandoMovimentoRobo = ComandoFactory.criar(movimento, robo.obterComandoRobo());
            posicao = comandoMovimentoRobo.comandarRobo(robo, terreno);
            
        } catch (Exception e) {
            throw e;
        }

        return posicao;
    }
}