package br.com.gestaoferias.demo01.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.gestaoferias.demo01.entities.Funcionario;
import br.com.gestaoferias.demo01.servico.FuncionarioServico;


@RestController
@CrossOrigin(origins = "*")
public class FuncionarioControle {
    
    @Autowired
    private FuncionarioServico fs;

    @DeleteMapping("/remover/{matricula}")
    public ResponseEntity<Funcionario> remover(@PathVariable int matricula) {
        return fs.remover(matricula);
    }

    @PutMapping("/alterar")
    public ResponseEntity<Funcionario> alterar(@RequestBody Funcionario fc) {
        return fs.cadastrarAlterar(fc, "alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Funcionario> cadastrar(@RequestBody Funcionario fc) {
        return fs.cadastrarAlterar(fc, "cadastrar");
    }

    @GetMapping(value = "/listar/{matricula}")
	public ResponseEntity<Funcionario> findById(@PathVariable("matricula") int matricula) {
		Funcionario funcionario = fs.findById(matricula);
		return ResponseEntity.ok().body(funcionario);
	}

    @GetMapping("/listar")
    public Iterable<Funcionario> listar() {
        return fs.listar();
    }

    
}
