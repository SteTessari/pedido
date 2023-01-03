package org.example.service;

import org.example.model.Cadastro;
import org.example.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository cadastroRepository;

    public Cadastro salvarRegistro(Cadastro cadastro) {
        return cadastroRepository.save(cadastro);
    }

    public Cadastro buscarRegistro(UUID id) {
        Optional<Cadastro> cadastroOptional = cadastroRepository.findById(id);
        return cadastroOptional.orElse(null);
    }

    public void deletarRegistro(UUID id) {
        cadastroRepository.deleteById(id);
    }
}
