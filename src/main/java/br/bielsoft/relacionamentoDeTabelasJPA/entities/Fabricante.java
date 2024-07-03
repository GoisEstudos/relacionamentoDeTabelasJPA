package br.bielsoft.relacionamentoDeTabelasJPA.entities;

import br.bielsoft.relacionamentoDeTabelasJPA.DTO.FabricanteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fabricante")
public class Fabricante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Fabricante(FabricanteDTO fabricanteDTO){
        this.id = fabricanteDTO.id();
        this.nome = fabricanteDTO.nome();
    }
}
