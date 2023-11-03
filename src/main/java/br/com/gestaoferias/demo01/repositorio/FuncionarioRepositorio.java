package br.com.gestaoferias.demo01.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.gestaoferias.demo01.entities.Funcionario;

public interface FuncionarioRepositorio extends CrudRepository <Funcionario, Integer>{
    
}
