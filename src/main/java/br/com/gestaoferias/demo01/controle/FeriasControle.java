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

import br.com.gestaoferias.demo01.entities.Ferias;
import br.com.gestaoferias.demo01.servico.FeriasServico;

@RestController
public class FeriasControle {
    
    @Autowired
    private FeriasServico feriasServico;

    @DeleteMapping("/removerFerias/{matricula}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        return feriasServico.remover(id);
    }

    @PutMapping("/alterarFerias")
    public ResponseEntity<Ferias> alterar(@RequestBody Ferias ferias) {
        return feriasServico.cadastrarAlterar(ferias, "alterar");
    }

    @PostMapping("/cadastrarFerias")
    public ResponseEntity<Ferias> cadastrar(@RequestBody Ferias ferias) {
        return feriasServico.cadastrarAlterar(ferias, "cadastrar");
    }

    @GetMapping("/listarFerias")
    public Iterable<Ferias> listar() {
        return feriasServico.listar();
    }

}
