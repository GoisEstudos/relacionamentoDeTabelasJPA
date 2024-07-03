package br.bielsoft.relacionamentoDeTabelasJPA.entities;

import br.bielsoft.relacionamentoDeTabelasJPA.DTO.ModeloDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "modelo")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_fabricante")
    private Fabricante fabricante;


    public Modelo(ModeloDTO modeloDTO){
        this.id = modeloDTO.id();
        this.nome = modeloDTO.nome();
        this.fabricante = new Fabricante();
        this.fabricante.setId(modeloDTO.idFabricante());
    }
}
