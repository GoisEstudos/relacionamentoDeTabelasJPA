package br.bielsoft.relacionamentoDeTabelasJPA.DTO;

public record CarroDTO(Long id, Long idFabricante, Long idModelo, String placa, String cor, Boolean disponivel, Long ano, Double valorlocacao) {
}
