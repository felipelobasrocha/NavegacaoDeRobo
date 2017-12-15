package com.navegacaoDeTerreno.domain.robo.movimento.deslocamento;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;
import com.navegacaoDeTerreno.domain.terreno.Terreno;
import com.navegacaoDeTerreno.domain.robo.*;
import com.navegacaoDeTerreno.TesteHelper;

public class MovimentoParaOesteTest {

    private MovimentoParaOeste movimento;
    private Terreno terreno;
    private Robo robo;

    @Before
	public void setup(){
        movimento = new MovimentoParaOeste();        
        terreno = TesteHelper.iniciarTerreno();
        robo = TesteHelper.iniciarRobo();       
    }

    @Test
    public void moverRoboParaOesteTest() {
        robo.obterPosicaoRobo().alterarCoordenadaX(2);

        PosicaoRobo posicaoRobo = movimento.moverPara(robo, terreno);
        Integer retorno = posicaoRobo.obterCoordenadaX();

        assertTrue(1 == retorno);
    }

    @Test
    public void moverRoboParaOesteCoordenadaXZeroTest() {
        Boolean fail = false;
        try{
            PosicaoRobo posicaoRobo = movimento.moverPara(robo, terreno);
            posicaoRobo.obterCoordenadaX();
        } catch (Exception e){
            fail = true;
        }

        assertTrue(fail);
    }        
}