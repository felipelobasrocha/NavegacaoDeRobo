package com.navegacaoDeTerreno.data.mapper;

import com.navegacaoDeTerreno.domain.robo.PosicaoRobo;
import java.util.Map;

public final class RoboJsonMapper {

    private RoboJsonMapper(){

    }

    public static PosicaoRobo mapper(Map<String,Object> map){
        PosicaoRobo posicaoRobo = 
            new PosicaoRobo((Integer)map.get("coordenadaInicialX")
                            , (Integer)map.get("coordenadaInicialY")
                                , map.get("apontaPara").toString()
                                    ,(Integer)map.get("quantidadeRotacao"));
        return posicaoRobo;
    }
}