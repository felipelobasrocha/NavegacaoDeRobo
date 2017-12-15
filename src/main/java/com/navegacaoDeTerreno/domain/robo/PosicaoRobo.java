package com.navegacaoDeTerreno.domain.robo;

public class PosicaoRobo {
    public PosicaoRobo(Integer coordenadaX, Integer coordenadaY
                        , String direcao, Integer quantidadeRotacao){
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.direcao = direcao;
        this.quantidadeRotacao = quantidadeRotacao;
    }

    public PosicaoRobo(PosicaoRobo posicaoRobo){
        this.coordenadaX = posicaoRobo.coordenadaX;
        this.coordenadaY = posicaoRobo.coordenadaY;
        this.direcao = posicaoRobo.direcao;
        this.quantidadeRotacao = posicaoRobo.quantidadeRotacao;
    }    

    private Integer coordenadaX;
    public Integer obterCoordenadaX()
    {
         return this.coordenadaX;
    }    
    public void alterarCoordenadaX(Integer value){
        this.coordenadaX = value;
    }

    private Integer coordenadaY;
    public Integer obterCoordenadaY()
    {
         return this.coordenadaY;
    }      
    public void alterarCoordenadaY(Integer value){
        this.coordenadaY = value;
    }

    private String direcao;
    public String obterDirecao()
    {
         return this.direcao;
    }    
    public void alterarDirecao(String value){
        this.direcao = value;
    }

     public String posicaoCompleta(){
         return String.format("(%d, %d, %s)", coordenadaX, coordenadaY, direcao);
    }

    private Integer quantidadeRotacao;
    public Integer obterQuantidadeRotacao()
    {
         return this.quantidadeRotacao;
    }

    public String statusPosicaoRobo;
}