package com.navegacaoDeTerreno.domain.robo.movimento.comando;

import org.springframework.stereotype.Service;
import java.util.Map;

import com.navegacaoDeTerreno.domain.terreno.Terreno;
import com.navegacaoDeTerreno.domain.robo.*;

@Service
public class ComandoParaDireita extends Comando {
    
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

    private String rotacionar(PosicaoRobo posicaoRobo, Terreno terreno){
        Integer novaDirecao = obterNovaDirecao(posicaoRobo, terreno);

        if(novaDirecao > terreno.obterDirecoes().size()){
            novaDirecao = novaDirecao - terreno.obterDirecoes().size();
        }

        return terreno.obterDirecoes().get(novaDirecao);
    }

    private Integer obterNovaDirecao(PosicaoRobo posicaoRobo, Terreno terreno){
        Integer novaDirecao = 0;
        for (Map.Entry<Integer, String> item : terreno.obterDirecoes().entrySet()) {
            String direcao = item.getValue();
            if (posicaoRobo.obterDirecao().equals(direcao)){
                novaDirecao = item.getKey()+posicaoRobo.obterQuantidadeRotacao();
                break;
            }
        }

        return novaDirecao;
    }
}