package com.navegacaoDeTerreno.data.dataAccess.robo;

import com.navegacaoDeTerreno.domain.robo.*;

public interface RoboDataAccess {

    PosicaoRobo obterPosicao(String statusPosicaoRobo);
    ComandoRobo obterComandoDoRobo();
}