package com.navegacaoDeTerreno.domain.robo.movimento.comando;

import com.navegacaoDeTerreno.domain.robo.Robo;
import com.navegacaoDeTerreno.domain.robo.PosicaoRobo;
import com.navegacaoDeTerreno.domain.terreno.Terreno;

public abstract class Comando {

    public abstract PosicaoRobo comandarRobo(Robo robo, Terreno terreno);
}