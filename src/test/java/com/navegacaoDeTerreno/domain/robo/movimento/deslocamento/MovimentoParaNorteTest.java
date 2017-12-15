package com.navegacaoDeTerreno.domain.robo.movimento.deslocamento;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;
import com.navegacaoDeTerreno.domain.terreno.Terreno;
import com.navegacaoDeTerreno.domain.robo.*;
import com.navegacaoDeTerreno.TesteHelper;

public class MovimentoParaNorteTest {

    private MovimentoParaNorte movimento;
    private Terreno terreno;
    private Robo robo;

    @Before
	public void setup(){
        movimento = new MovimentoParaNorte();        
        terreno = TesteHelper.iniciarTerreno();
        robo = TesteHelper.iniciarRobo();       
    }

    @Test
    public void moverRoboParaNorteTest() {
        PosicaoRobo posicaoRobo = movimento.moverPara(robo, terreno);
        Integer retorno = posicaoRobo.obterCoordenadaY();

        assertTrue(1 == retorno);
    }

    @Test
    public void moverRoboParaNorteCoordenadaLimiteZeroTest() {
        Boolean fail = false;
        try{
            robo.obterPosicaoRobo().alterarCoordenadaY(5);

            PosicaoRobo posicaoRobo = movimento.moverPara(robo, terreno);
            posicaoRobo.obterCoordenadaY();
        } catch (Exception e){
            fail = true;
        }

        assertTrue(fail);
    }        
}