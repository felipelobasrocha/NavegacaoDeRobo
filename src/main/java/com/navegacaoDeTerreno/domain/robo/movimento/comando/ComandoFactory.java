package com.navegacaoDeTerreno.domain.robo.movimento.comando;

import com.navegacaoDeTerreno.domain.robo.ComandoRobo;

public final class ComandoFactory {
    private ComandoFactory(){
        
    }

    public static Comando criar(String movimento, ComandoRobo comando){
        try{
            if (movimento.equals(comando.paraFrente())){
                return new ComandoParaFrente();
            }
            if (movimento.equals(comando.paraDireita())){
                return new ComandoParaDireita();
            }                        
            if (movimento.equals(comando.paraEsquerda())){
                return new ComandoParaEsquerda();
            }

            throw new NullPointerException();
        } catch (Exception e) {
            throw e;
        }
    }
}