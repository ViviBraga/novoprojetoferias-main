package br.com.gestaoferias.demo01.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.gestaoferias.demo01.entities.Departamento;
import br.com.gestaoferias.demo01.repositorio.DepartamentoRepositorio;

@Service
public class DepartamentoServico {
    
    @Autowired
    private DepartamentoRepositorio dr;

    @GetMapping("/")
    public Iterable<Departamento> listar() {
        return dr.findAll();
    }

    public ResponseEntity<Departamento> cadastrarAlterar(Departamento dc, String acao) {
        if(acao.equals("cadastrar")) {
            return new ResponseEntity<Departamento>(dr.save(dc), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Departamento>(dr.save(dc), HttpStatus.OK);
        }
    }

    public ResponseEntity<Departamento> remover(int codigo) {
        dr.deleteById(codigo);
        return new ResponseEntity<Departamento>(HttpStatus.OK);
    }
}
