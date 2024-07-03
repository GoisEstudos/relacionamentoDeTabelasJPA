package br.bielsoft.relacionamentoDeTabelasJPA.entities;

import br.bielsoft.relacionamentoDeTabelasJPA.DTO.CarroDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String cor;
    private Boolean disponivel;
    private Long ano;
    private Double valorlocacao;

    @ManyToOne
    @JoinColumn(name = "id_fabricante")
    private Fabricante fabricante;

    @OneToOne
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;

    public Carro(CarroDTO carroDTO){
        this.id = carroDTO.id();
        this.fabricante = new Fabricante();
        this.fabricante.setId(carroDTO.idFabricante());
        this.modelo = new Modelo();
        this.modelo.setId(carroDTO.idModelo());
        this.placa = carroDTO.placa();
        this.cor = carroDTO.cor();
        this.disponivel = carroDTO.disponivel();
        this.ano = carroDTO.ano();
        this.valorlocacao = carroDTO.valorlocacao();
    }
}
