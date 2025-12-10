package springboot.desafio.itau.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.desafio.itau.dto.TransacaoRequest;
import springboot.desafio.itau.model.Transacao;
import springboot.desafio.itau.service.TransacaoService;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Void> criarTransacao(@Valid @RequestBody TransacaoRequest request) {
        try{
            return transacaoService.addTransacao(new Transacao(request.getValor(), request.getDataHora()));
        }
        catch (Exception e){           
            System.err.println("Erro ao criar transação: " + e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

}