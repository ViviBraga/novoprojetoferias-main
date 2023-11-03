package br.com.gestaoferias.demo01.servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.gestaoferias.demo01.entities.Funcionario;
import br.com.gestaoferias.demo01.repositorio.FuncionarioRepositorio;



@Service
public class FuncionarioServico {
    
    @Autowired
    private FuncionarioRepositorio fr;

    public Iterable<Funcionario> listar() {
        return fr.findAll();
    }

    public Funcionario findById(int matricula) {
        Optional<Funcionario> obj = fr.findById(matricula);
        return obj.get();
    }

    public ResponseEntity<Funcionario> cadastrarAlterar(Funcionario fc, String acao) {
        if(acao.equals("cadastrar")) {
            return new ResponseEntity<Funcionario>(fr.save(fc), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Funcionario>(fr.save(fc), HttpStatus.OK);
        }    
    }

    public ResponseEntity<Funcionario> remover(int matricula) {
        fr.deleteById(matricula);
        return new ResponseEntity<Funcionario>(HttpStatus.OK);
    }
}
