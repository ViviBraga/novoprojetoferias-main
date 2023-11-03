package br.com.gestaoferias.demo01.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "departamento_tabela")
@Getter
@Setter
public class Departamento {
    
    @Id
    private int codigo;

    private String nome_dep;

}
