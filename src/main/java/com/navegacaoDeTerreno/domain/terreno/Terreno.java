package com.navegacaoDeTerreno.domain.terreno;

import java.util.Map;

public class Terreno {

    public Terreno(Integer tamanhoX, Integer tamanhoY, Map<Integer, String> direcoes){
        this.tamanhoX = tamanhoX;
        this.tamanhoY = tamanhoY;
        this.direcoes = direcoes;
    }

    private Integer tamanhoX;
    public Integer obterTamanhoX(){
        return tamanhoX;
    }

    private Integer tamanhoY;
    public Integer obterTamanhoY(){
        return tamanhoY;
    }    

    private Map<Integer, String> direcoes;
    public Map<Integer, String> obterDirecoes(){
        return direcoes;
    }
}