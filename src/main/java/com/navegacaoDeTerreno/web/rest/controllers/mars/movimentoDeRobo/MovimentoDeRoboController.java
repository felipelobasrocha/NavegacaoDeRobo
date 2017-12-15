package com.navegacaoDeTerreno.web.rest.controllers.mars.movimentoDeRobo;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.navegacaoDeTerreno.service.message.movimentoDeRobo.MovimentoRoboRequest;
import com.navegacaoDeTerreno.service.message.movimentoDeRobo.MovimentoRoboResponse;
import com.navegacaoDeTerreno.service.contract.movimentoDeRobo.MovimentoRoboService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class MovimentoDeRoboController {

    @Autowired
    private MovimentoRoboService movimentoService;
    
    @RequestMapping("/")
    public String index() {
        return "Index";
    }   
    
    @PostMapping("/rest/mars/{request}")
    public String movimentarRobo(@PathVariable MovimentoRoboRequest request){
        MovimentoRoboResponse response = new MovimentoRoboResponse();
        
        try{
            if (request.movimento == null || request.movimento.isEmpty()) {
                throw new IllegalArgumentException("O 'request' não deve ser 'null' ou 'empty'");
            }

            response = movimentoService.movimentarRobo(request);

            if (response == null){
                throw new IllegalArgumentException();
            }
            if (!response.valido){
                throw new IllegalArgumentException(response.mensagemErro);
            }
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e){
            throw e;
        }

        return response.posicaoDoRobo;
    }

    @GetMapping("/rest/mars/{request}")
    public String get(@PathVariable MovimentoRoboRequest request)
    {
          return movimentarRobo(request);
    }     
    
    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class, Exception.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
        
}