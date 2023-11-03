package br.com.gestaoferias.demo01.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gestaoferias.demo01.entities.Departamento;
import br.com.gestaoferias.demo01.servico.DepartamentoServico;

@RestController
public class DepartamentoControle {
    
    @Autowired
    private DepartamentoServico ds;

    @DeleteMapping("/removerDep/{codigo}")
    public ResponseEntity<Departamento> remover(@PathVariable int codigo) {
        return ds.remover(codigo);
    }

    @PutMapping("/alterarDep")
    public ResponseEntity<Departamento> alterar(@RequestBody Departamento dc) {
        return ds.cadastrarAlterar(dc, "alterar");
    }

    @PostMapping("/cadastrarDep")
    public ResponseEntity<Departamento> cadastrar(@RequestBody Departamento dc) {
        return ds.cadastrarAlterar(dc, "cadastrar");
    }

    @GetMapping("/listarDep")
    public Iterable<Departamento> listar() {
        return ds.listar();
    }
}
