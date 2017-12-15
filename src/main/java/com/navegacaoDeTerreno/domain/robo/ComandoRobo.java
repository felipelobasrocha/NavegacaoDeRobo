package com.navegacaoDeTerreno.domain.robo;

public class ComandoRobo {
    private String frente;
    public String paraFrente()
    {
         return this.frente;
    }

    private String direita;
    public String paraDireita()
    {
         return this.direita;
    }    

    private String esquerda;
    public String paraEsquerda()
    {
         return this.esquerda;
    }

    public ComandoRobo(String frente, String direita, String esquerda){
        this.frente = frente;
        this.direita = direita;
        this.esquerda = esquerda;
    }    

    public Boolean validarComando(String comando){
        if (comando.equals(this.frente) || comando.equals(this.direita) || comando.equals(this.esquerda)){
            return true;
        }

        return false;
    }
}