package com.navegacaoDeTerreno.domain.robo;

public class Robo {
    public Robo(ComandoRobo comandoRobo, PosicaoRobo posicaoRobo){
        this.comandoRobo = comandoRobo;
        this.posicaoRobo = new PosicaoRobo(posicaoRobo);
    }

    private ComandoRobo comandoRobo;
    public ComandoRobo obterComandoRobo(){
        return comandoRobo;
    }
    private PosicaoRobo posicaoRobo;
    public PosicaoRobo obterPosicaoRobo(){
        return posicaoRobo;
    }
}