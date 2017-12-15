package com.navegacaoDeTerreno.domain.robo.movimento.deslocamento;

import com.navegacaoDeTerreno.domain.robo.Robo;
import com.navegacaoDeTerreno.domain.robo.PosicaoRobo;
import com.navegacaoDeTerreno.domain.terreno.Terreno;

public abstract class Movimento {

    public abstract PosicaoRobo moverPara(Robo robo, Terreno terreno);
}