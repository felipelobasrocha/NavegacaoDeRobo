package com.navegacaoDeTerreno.data.mapper;

import com.navegacaoDeTerreno.domain.robo.ComandoRobo;
import java.util.Map;

public final class ComandoRoboJsonMapper {

    private ComandoRoboJsonMapper(){

    }

    public static ComandoRobo mapper(Map<String,Object> map){
        ComandoRobo comandoRobo = 
            new ComandoRobo(map.get("paraFrente").toString()
                            , map.get("paraDireita").toString()
                                , map.get("paraEsquerda").toString());

        return comandoRobo;
    }
}