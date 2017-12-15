package com.navegacaoDeTerreno.data.dataAccessJson.terreno;

import com.navegacaoDeTerreno.domain.terreno.Terreno;
import com.navegacaoDeTerreno.data.dataAccess.terreno.TerrenoDataAccess;
import com.navegacaoDeTerreno.data.mapper.TerrenoJsonMapper;
import com.navegacaoDeTerreno.data.helper.JsonHelper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import java.util.Map;

@Repository
public class TerrenoJsonDataAccess implements TerrenoDataAccess {

    @Override
    @Cacheable("terreno")
    public Terreno obterTamanhoDoTerreno(){
        try {
            String connectionString = "database/json/terreno.json";            
            Map<String,Object> map = JsonHelper.parseJsonFile(connectionString);
            return TerrenoJsonMapper.mapper(map);      
        } catch (Exception e) {
            throw e;
        }
    }    
}