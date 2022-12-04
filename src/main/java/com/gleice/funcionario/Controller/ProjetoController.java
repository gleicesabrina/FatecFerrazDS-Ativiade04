package com.gleice.funcionario.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gleice.funcionario.Model.Projeto;
import com.gleice.funcionario.Repository.ProjetoRepository;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/projeto")
@AllArgsConstructor
public class ProjetoController {

    ProjetoRepository ProjetoRepository;

    @GetMapping
    public List<Projeto>getAllFuncinonario(){
        return ProjetoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Projeto> getFuncionarioById(@PathVariable("id") Long id) {
        return  ProjetoRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED) 
    public Projeto create (@RequestBody Projeto projeto) {
        return ProjetoRepository.save(projeto);
    }


    @PutMapping("/{id}")
    Optional<Object> update(@RequestBody Projeto newProjeto, @PathVariable Long id) {
      
      return ProjetoRepository.findById(id).
        map(projeto -> {
            projeto.setTitulo(newProjeto.getTitulo());
            projeto.setDescricao(newProjeto.getDescricao());
            projeto.setDataInicio(newProjeto.getDataInicio());            
            projeto.setDataFim(newProjeto.getDataFim());
            projeto.setValorPrevisto(newProjeto.getValorPrevisto());
            projeto.setValorGasto(newProjeto.getValorGasto());

          return ProjetoRepository.save(projeto);
        });
    }
    

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ProjetoRepository.deleteById(id);
    }
}