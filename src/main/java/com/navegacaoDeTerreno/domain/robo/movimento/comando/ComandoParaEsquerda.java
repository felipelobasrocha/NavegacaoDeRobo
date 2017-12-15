package com.navegacaoDeTerreno.domain.robo.movimento.comando;

import org.springframework.stereotype.Service;
import java.util.Map;

import com.navegacaoDeTerreno.domain.terreno.Terreno;
import com.navegacaoDeTerreno.domain.robo.*;

@Service
public class ComandoParaEsquerda extends Comando {

    @Override
    public PosicaoRobo comandarRobo(Robo robo, Terreno terreno){
        PosicaoRobo posicao = robo.obterPosicaoRobo();
        try {
            String novaDirecao = rotacionar(posicao, terreno);
            posicao.alterarDirecao(novaDirecao);
        } catch (Exception e) {
            throw e;
        }
        return posicao;
    }

    private String rotacionar(PosicaoRobo posicao, Terreno terreno){
        Integer novaDirecao = obterNovaDirecao(posicao, terreno);

        if(novaDirecao < 1){
            novaDirecao = terreno.obterDirecoes().size() + novaDirecao;
        }

        return terreno.obterDirecoes().get(novaDirecao);
    }

    private Integer obterNovaDirecao(PosicaoRobo posicao, Terreno terreno){
        Integer novaDirecao = terreno.obterDirecoes().size()+1;
        for (Map.Entry<Integer, String> item : terreno.obterDirecoes().entrySet()) {
            String direcao = item.getValue();
            if (posicao.obterDirecao().equals(direcao)){
                novaDirecao = item.getKey()-posicao.obterQuantidadeRotacao();
                break;
            }
        }

        return novaDirecao;
    }    
}