package org.example.controller;

import org.example.model.Cadastro;
import org.example.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @PostMapping
    public ResponseEntity<Object> inserirRegistro(@RequestBody Cadastro cadastro) {
        return ResponseEntity.ok().body(cadastro);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> buscarRegistro(@PathVariable UUID id) {
        Cadastro cadastro = cadastroService.buscarRegistro(id);
        return ResponseEntity.ok().body(cadastro);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> atualizarRegistro(@RequestBody Cadastro cadastro) {
        if (cadastro.getId() == null) {
            throw new RuntimeException();
        }
        Cadastro cadastroAtualizado = cadastroService.salvarRegistro(cadastro);
        return ResponseEntity.ok().body(cadastroAtualizado);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deletarRegistro(@PathVariable UUID id) {
        cadastroService.deletarRegistro(id);
        return ResponseEntity.ok().body("Removido com sucesso!");
    }
}
