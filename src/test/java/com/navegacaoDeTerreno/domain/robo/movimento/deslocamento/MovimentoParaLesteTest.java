package com.navegacaoDeTerreno.domain.robo.movimento.deslocamento;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;
import com.navegacaoDeTerreno.domain.terreno.Terreno;
import com.navegacaoDeTerreno.domain.robo.*;
import com.navegacaoDeTerreno.TesteHelper;

public class MovimentoParaLesteTest {

    private MovimentoParaLeste movimento;
    private Terreno terreno;
    private Robo robo;

    @Before
	public void setup(){
        movimento = new MovimentoParaLeste();        
        terreno = TesteHelper.iniciarTerreno();
        robo = TesteHelper.iniciarRobo();       
    }

    @Test
    public void moverRoboParaLesteTest() {
        PosicaoRobo posicaoRobo = movimento.moverPara(robo, terreno);
        Integer retorno = posicaoRobo.obterCoordenadaX();

        assertTrue(1 == retorno);
    }

    @Test
    public void moverRoboParaLesteCoordenadaLimiteTest() {
        Boolean fail = false;
        try{
            robo.obterPosicaoRobo().alterarCoordenadaX(5);

            PosicaoRobo posicaoRobo = movimento.moverPara(robo, terreno);
            posicaoRobo.obterCoordenadaX();
        } catch (Exception e){
            fail = true;
        }

        assertTrue(fail);
    }    

    @Test
    public void moverRoboParaSulTest() {
        MovimentoParaSul movimento = new MovimentoParaSul();

        Terreno terreno = TesteHelper.iniciarTerreno();
        Robo robo = TesteHelper.iniciarRobo();
        robo.obterPosicaoRobo().alterarCoordenadaY(2);

        PosicaoRobo posicaoRobo = movimento.moverPara(robo, terreno);
        Integer retorno = posicaoRobo.obterCoordenadaY();

        assertTrue(1 == retorno);
    } 
}