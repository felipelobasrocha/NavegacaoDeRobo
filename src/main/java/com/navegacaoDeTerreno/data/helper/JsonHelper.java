package com.navegacaoDeTerreno.data.helper;

import java.io.*;
import java.util.Map;

import org.springframework.boot.json.JacksonJsonParser;

public final class JsonHelper{
    private JsonHelper () {
    }

    public static Map<String,Object> parseJsonFile(String jsonFile){
        StringBuilder strBuilder = new StringBuilder();
        try {
            byte[] buffer = new byte[1000];

            FileInputStream inputStream = 
                new FileInputStream(jsonFile);

            while((inputStream.read(buffer)) != -1) {
                strBuilder.append(new String(buffer));
            }
            inputStream.close();
        }
        catch(FileNotFoundException e) {
            System.out.println(
                "Não foi possível abrir o arquivo '" + 
                jsonFile + "'");                
        }
        catch(IOException e) {
            System.out.println(
                "Erro ao ler o arquivo '" 
                + jsonFile + "'");
        }

        return new JacksonJsonParser().parseMap(strBuilder.toString());
    }
}