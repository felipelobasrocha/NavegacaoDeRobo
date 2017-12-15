package com.navegacaoDeTerreno;

import java.util.*;

import com.navegacaoDeTerreno.domain.terreno.Terreno;
import com.navegacaoDeTerreno.domain.robo.*;

public final class TesteHelper {
    private TesteHelper(){}

    public static Terreno iniciarTerreno(){
        Map<Integer, String> direcoes = new HashMap<Integer, String>();
        direcoes.put(1, "N");
        direcoes.put(2, "E");
        direcoes.put(3, "S");
        direcoes.put(4, "W");
        return new Terreno(5, 5, direcoes);
    }

    public static ComandoRobo iniciarComandoRobo(){
        return new ComandoRobo("M","R","L");
    }    

    public static PosicaoRobo iniciarPosicaoRobo(){
        return new PosicaoRobo(0, 0, "N", 1);
    }

    public static Robo iniciarRobo(){
        ComandoRobo comandoRobo = iniciarComandoRobo();
        PosicaoRobo posicaoRobo = iniciarPosicaoRobo();

        return new Robo(comandoRobo,posicaoRobo);
    }  
}