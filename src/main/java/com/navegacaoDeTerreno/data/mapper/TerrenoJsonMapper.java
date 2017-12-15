package com.navegacaoDeTerreno.data.mapper;

import com.navegacaoDeTerreno.domain.terreno.Terreno;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public final class TerrenoJsonMapper {

    private TerrenoJsonMapper(){
    }

    public static Terreno mapper(Map<String,Object> map){
        Map<Integer, String> direcoes = new HashMap<Integer, String>();
        Integer key = 1;
        for (Object item : (ArrayList<String>)map.get("direcoes")) {
            direcoes.put(key, item.toString());
            key++;
        }

        Terreno terreno = 
                    new Terreno((Integer)map.get("tamanhoX")
                                    , (Integer)map.get("tamanhoY")
                                        , direcoes);

        return terreno;
    }
}