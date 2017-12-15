package com.navegacaoDeTerreno.domain.robo.movimento.comando;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;
import com.navegacaoDeTerreno.domain.robo.*;
import com.navegacaoDeTerreno.TesteHelper;

public class ComandoFactoryTest {

    private Robo robo;
    
    @Before
    public void setup(){
        robo = TesteHelper.iniciarRobo();       
    } 

    @Test
    public void instanciarComandoParaFrenteTest() {
        Comando factory = ComandoFactory.criar("M", robo.obterComandoRobo());
        assertTrue(factory instanceof Comando);
    }

    @Test
    public void instanciarComandoParaDireitaTest() {
        Comando factory = ComandoFactory.criar("R", robo.obterComandoRobo());
        assertTrue(factory instanceof Comando);
    }

    @Test
    public void instanciarComandoParaEsquerdaTest() {
        Comando factory = ComandoFactory.criar("L", robo.obterComandoRobo());
        assertTrue(factory instanceof Comando);
    }    

    @Test
    public void instanciarComandoInvalidoTest() {
        Boolean fail = false;
        try{
            ComandoFactory.criar("Z", robo.obterComandoRobo());
        } catch(Exception e){
            fail = true;
        }
        assertTrue(fail);
    }    
}