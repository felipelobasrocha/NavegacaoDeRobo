package com.navegacaoDeTerreno.service.implementation.movimentoDeRobo;

import com.navegacaoDeTerreno.service.message.movimentoDeRobo.*;
import com.navegacaoDeTerreno.TesteHelper;
import com.navegacaoDeTerreno.data.dataAccess.robo.*;
import com.navegacaoDeTerreno.data.dataAccess.terreno.TerrenoDataAccess;
import com.navegacaoDeTerreno.domain.robo.*;
import com.navegacaoDeTerreno.domain.robo.movimento.MovimentoRobo;
import com.navegacaoDeTerreno.domain.terreno.Terreno;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@RunWith(SpringRunner.class)
public class MovimentoRoboServiceImplTest {

    @Mock
    private RoboDataAccess roboDataAccess;
    @Mock
    private TerrenoDataAccess terrenoDataAccess;
    @Mock
    private MovimentoRobo movimentoRobo;    

	@InjectMocks
    private MovimentoRoboServiceImpl movimentoService;
    
    private ComandoRobo comandoRobo;
    private PosicaoRobo posicaoInicialRobo;
    private Terreno terreno;
    private Robo robo;
    private MovimentoRoboRequest request;

	@Before
	public void setup(){
        MockitoAnnotations.initMocks(this);
        comandoRobo = TesteHelper.iniciarComandoRobo();
        posicaoInicialRobo = TesteHelper.iniciarPosicaoRobo();
        terreno = TesteHelper.iniciarTerreno();
        robo = new Robo(comandoRobo, posicaoInicialRobo);
        request = new MovimentoRoboRequest();
        request.movimento = "M";
	}    

    @Test
    public void movimentarRoboTest() {
        given(roboDataAccess.obterComandoDoRobo())
        .willReturn(comandoRobo);

        given(roboDataAccess.obterPosicao(PosicaoStatus.INICIAL.toString()))
        .willReturn(posicaoInicialRobo);

        given(terrenoDataAccess.obterTamanhoDoTerreno())
        .willReturn(terreno); 

        PosicaoRobo posicaoRobo = TesteHelper.iniciarPosicaoRobo();
        given(movimentoRobo.movimentarRobo(request.movimento, robo, terreno))
        .willReturn(posicaoRobo);

        MovimentoRoboResponse response = movimentoService.movimentarRobo(request);
        assertTrue(response.valido);
        assertFalse(response.posicaoDoRobo.isEmpty());
    }

    @Test
    public void movimentarRoboComandoInvalidoTest() {
        Boolean fail = false;
        try{
            given(roboDataAccess.obterComandoDoRobo())
            .willReturn(comandoRobo);

            given(roboDataAccess.obterPosicao(PosicaoStatus.INICIAL.toString()))
            .willReturn(posicaoInicialRobo);

            given(terrenoDataAccess.obterTamanhoDoTerreno())
            .willReturn(terreno); 

            request.movimento = "Z";
            PosicaoRobo posicaoRobo = TesteHelper.iniciarPosicaoRobo();
            given(movimentoRobo.movimentarRobo(request.movimento, robo, terreno))
            .willReturn(posicaoRobo);

            movimentoService.movimentarRobo(request);
        } catch (Exception e){
            fail = true;
        }

        assertTrue(fail);
    }    
}
