package com.navegacaoDeTerreno.service.contract.movimentoDeRobo;

import com.navegacaoDeTerreno.service.message.movimentoDeRobo.MovimentoRoboRequest;
import com.navegacaoDeTerreno.service.message.movimentoDeRobo.MovimentoRoboResponse;

public interface MovimentoRoboService {

    MovimentoRoboResponse movimentarRobo(MovimentoRoboRequest request);
}