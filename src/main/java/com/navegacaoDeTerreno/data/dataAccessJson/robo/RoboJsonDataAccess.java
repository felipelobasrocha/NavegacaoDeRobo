package com.navegacaoDeTerreno.data.dataAccessJson.robo;

import com.navegacaoDeTerreno.domain.robo.*;
import com.navegacaoDeTerreno.data.dataAccess.robo.RoboDataAccess;
import com.navegacaoDeTerreno.data.mapper.*;
import com.navegacaoDeTerreno.data.helper.JsonHelper;
import org.springframework.stereotype.Repository;
import org.springframework.cache.annotation.Cacheable;
import java.util.Map;

@Repository
public class RoboJsonDataAccess implements RoboDataAccess {

    @Override
    @Cacheable(value = "posicaoRobo", key = "#statusPosicaoRobo")
    public PosicaoRobo obterPosicao(String statusPosicaoRobo){
        try {
            String connectionString = "database/json/robo.json";        
            Map<String,Object> map = JsonHelper.parseJsonFile(connectionString);
            PosicaoRobo posicaoRobo = RoboJsonMapper.mapper(map);
            posicaoRobo.statusPosicaoRobo = statusPosicaoRobo;

            return posicaoRobo;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Override
    @Cacheable("comandos")
    public ComandoRobo obterComandoDoRobo(){
        try {
            String connectionString = "database/json/comandoRobo.json";            
            Map<String,Object> map = JsonHelper.parseJsonFile(connectionString);
            return ComandoRoboJsonMapper.mapper(map);      
        } catch (Exception e) {
            throw e;
        }
    }    
}