package com.navegacaoDeTerreno.domain.robo.movimento;

import com.navegacaoDeTerreno.domain.robo.*;
import com.navegacaoDeTerreno.domain.robo.Robo;
import com.navegacaoDeTerreno.domain.terreno.Terreno;

public interface MovimentoRobo {
    public PosicaoRobo movimentarRobo(String movimento, Robo robo, Terreno terreno);
}