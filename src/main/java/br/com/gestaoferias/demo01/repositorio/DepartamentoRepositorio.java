package br.com.gestaoferias.demo01.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.gestaoferias.demo01.entities.Departamento;

public interface DepartamentoRepositorio extends CrudRepository<Departamento, Integer> {
    
}
