package br.com.gestaoferias.demo01.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="funcionario_tabela")
@Getter
@Setter
public class Funcionario {
    
    @Id
    private int matricula;

    private String nome;

    @ManyToOne
    private Departamento funcsDepto;

    @OneToOne
    private Ferias funcsFerias;
    
}
