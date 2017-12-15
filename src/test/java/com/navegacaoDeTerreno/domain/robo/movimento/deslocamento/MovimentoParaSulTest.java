package com.navegacaoDeTerreno.domain.robo.movimento.deslocamento;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;

import com.navegacaoDeTerreno.domain.terreno.Terreno;
import com.navegacaoDeTerreno.domain.robo.*;
import com.navegacaoDeTerreno.TesteHelper;

public class MovimentoParaSulTest {

    private MovimentoParaSul movimento;
    private Terreno terreno;
    private Robo robo;

    @Before
	public void setup(){
        movimento = new MovimentoParaSul();        
        terreno = TesteHelper.iniciarTerreno();
        robo = TesteHelper.iniciarRobo();       
    }

    @Test
    public void moverRoboParaSulTest() {

        robo.obterPosicaoRobo().alterarCoordenadaY(2);

        PosicaoRobo posicaoRobo = movimento.moverPara(robo, terreno);
        Integer retorno = posicaoRobo.obterCoordenadaY();

        assertTrue(1 == retorno);
    }

    @Test
    public void moverRoboParaSulCoordenadaYZeroTest() {
        Boolean fail = false;
        try{

            PosicaoRobo posicaoRobo = movimento.moverPara(robo, terreno);
            posicaoRobo.obterCoordenadaY();
        } catch (Exception e){
            fail = true;
        }

        assertTrue(fail);
    }        
}