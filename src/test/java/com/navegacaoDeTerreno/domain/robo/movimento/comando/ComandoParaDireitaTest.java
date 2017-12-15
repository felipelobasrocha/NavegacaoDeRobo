package com.navegacaoDeTerreno.domain.robo.movimento.comando;

import static org.junit.Assert.assertEquals;
import org.junit.*;
import org.junit.Test;
import com.navegacaoDeTerreno.domain.robo.movimento.comando.ComandoParaDireita;
import com.navegacaoDeTerreno.domain.terreno.Terreno;
import com.navegacaoDeTerreno.domain.robo.*;
import com.navegacaoDeTerreno.TesteHelper;

public class ComandoParaDireitaTest {

    private ComandoParaDireita comando;
    private Terreno terreno;
    private Robo robo;

    @Before
	public void setup(){
        comando = new ComandoParaDireita();        
        terreno = TesteHelper.iniciarTerreno();
        robo = TesteHelper.iniciarRobo();       
    } 

    @Test
    public void rotacionarRoboParaLesteTest() {
        PosicaoRobo posicaoRobo = comando.comandarRobo(robo, terreno);

        assertEquals("E", posicaoRobo.obterDirecao());
    }

    @Test
    public void rotacionarRoboParaSulTest() {
        robo.obterPosicaoRobo().alterarDirecao("E");
        PosicaoRobo posicaoRobo = comando.comandarRobo(robo, terreno);
        
        assertEquals("S", posicaoRobo.obterDirecao());
    }
    
    @Test
    public void rotacionarRoboParaOesteTest() {
        robo.obterPosicaoRobo().alterarDirecao("S");
        PosicaoRobo posicaoRobo = comando.comandarRobo(robo, terreno);
        
        assertEquals("W", posicaoRobo.obterDirecao());
    }

    @Test
    public void rotacionarRoboParaNorteTest() {
        robo.obterPosicaoRobo().alterarDirecao("W");
        PosicaoRobo posicaoRobo = comando.comandarRobo(robo, terreno);
        
        assertEquals("N", posicaoRobo.obterDirecao());
    }  
}