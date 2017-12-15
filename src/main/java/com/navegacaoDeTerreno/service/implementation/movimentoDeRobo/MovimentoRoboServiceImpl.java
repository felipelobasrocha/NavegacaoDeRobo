package com.navegacaoDeTerreno.service.implementation.movimentoDeRobo;

import com.navegacaoDeTerreno.service.message.movimentoDeRobo.*;
import com.navegacaoDeTerreno.service.contract.movimentoDeRobo.MovimentoRoboService;
import com.navegacaoDeTerreno.data.dataAccess.robo.*;
import com.navegacaoDeTerreno.data.dataAccess.terreno.TerrenoDataAccess;
import com.navegacaoDeTerreno.domain.terreno.Terreno;
import com.navegacaoDeTerreno.domain.robo.*;
import com.navegacaoDeTerreno.domain.robo.movimento.MovimentoRobo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MovimentoRoboServiceImpl implements MovimentoRoboService {

    private RoboDataAccess roboDataAccess;
    private TerrenoDataAccess terrenoDataAccess;
    private MovimentoRobo movimentoRobo;

    @Autowired
    public MovimentoRoboServiceImpl(RoboDataAccess roboDataAccess
                                        , TerrenoDataAccess terrenoDataAccess
                                            ,MovimentoRobo movimentoRobo) {
        this.roboDataAccess = roboDataAccess;
        this.terrenoDataAccess = terrenoDataAccess;
        this.movimentoRobo = movimentoRobo;
    }      

    @Override
    public MovimentoRoboResponse movimentarRobo(MovimentoRoboRequest request){
        MovimentoRoboResponse response = new MovimentoRoboResponse();

        try{
            PosicaoRobo posicaoInicialRobo = roboDataAccess.obterPosicao(PosicaoStatus.INICIAL.toString());
            ComandoRobo comandoRobo = roboDataAccess.obterComandoDoRobo();
            Terreno terreno = terrenoDataAccess.obterTamanhoDoTerreno();
            Robo robo = new Robo(comandoRobo, posicaoInicialRobo);
            
            for (int i = 0; i < request.movimento.length(); i++){
                char comandoMovimento = request.movimento.charAt(i);
                String movimento = Character.toString(comandoMovimento).toUpperCase();

                if (!comandoRobo.validarComando(movimento)){
                    response.valido = false;
                    response.mensagemErro = "Comando Inválido.";
                    throw new IllegalArgumentException(response.mensagemErro);
                }
                
                movimentoRobo.movimentarRobo(movimento, robo, terreno);
            }
            
            response.posicaoDoRobo = robo.obterPosicaoRobo().posicaoCompleta();
            response.valido = true;
        } catch (IllegalArgumentException e) {
            throw e;
        }catch (Exception e){
            throw e;
        }
        
        return response;
    }    
}
 
  