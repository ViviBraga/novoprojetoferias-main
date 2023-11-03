package br.com.gestaoferias.demo01.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.com.gestaoferias.demo01.entities.Ferias;

public interface FeriasRepositorio extends CrudRepository<Ferias, Long>{
    
}
