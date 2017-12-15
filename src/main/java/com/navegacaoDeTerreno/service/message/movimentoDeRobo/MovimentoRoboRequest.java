package com.navegacaoDeTerreno.service.message.movimentoDeRobo;

public class MovimentoRoboRequest {
    public String movimento;

    public static MovimentoRoboRequest findMovimentoRoboRequest(String request) {
        MovimentoRoboRequest obj = new MovimentoRoboRequest();
        obj.movimento = request;
        return obj;
    }
}