package br.com.gestaoferias.demo01.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.gestaoferias.demo01.entities.Ferias;
import br.com.gestaoferias.demo01.entities.Funcionario;
import br.com.gestaoferias.demo01.repositorio.FeriasRepositorio;

@Service
public class FeriasServico {
    
    @Autowired
    private FeriasRepositorio feriasRepositorio;

    @GetMapping("/")
    public Iterable <Ferias> listar() {
        return feriasRepositorio.findAll();
    }

    public ResponseEntity<Ferias> cadastrarAlterar(Ferias ferias, String acao) {
        if(acao.equals("cadastrarFerias")) {
            return new ResponseEntity<Ferias>(feriasRepositorio.save(ferias), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Ferias>(feriasRepositorio.save(ferias), HttpStatus.OK);
        }    
    }

    public ResponseEntity<?> remover(Long id) {
        feriasRepositorio.deleteById(id);
        return new ResponseEntity<Funcionario>(HttpStatus.OK);
    }
}
