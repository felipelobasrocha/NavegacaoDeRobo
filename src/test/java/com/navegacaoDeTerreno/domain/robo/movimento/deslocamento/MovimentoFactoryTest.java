package com.navegacaoDeTerreno.domain.robo.movimento.deslocamento;

import static org.junit.Assert.*;
import org.junit.Test;

import com.navegacaoDeTerreno.domain.terreno.Terreno;
import com.navegacaoDeTerreno.domain.robo.*;
import com.navegacaoDeTerreno.TesteHelper;

public class MovimentoFactoryTest {

    @Test
    public void instanciarMovimentoTest() {

        Terreno terreno = TesteHelper.iniciarTerreno();
        Robo robo = TesteHelper.iniciarRobo();

        Movimento factory = MovimentoFactory.criar(robo.obterPosicaoRobo(), terreno);  
        assertTrue(factory instanceof Movimento);
    }

    @Test
    public void instanciarMovimentoDirecaoInvalidaTest() {
        Boolean fail = false;
        try{
            Terreno terreno = new Terreno(5, 5, null);
            Robo robo = TesteHelper.iniciarRobo();
            MovimentoFactory.criar(robo.obterPosicaoRobo(), terreno);  
        } catch(Exception e){
            fail = true;
        }
        assertTrue(fail);
    }    
}