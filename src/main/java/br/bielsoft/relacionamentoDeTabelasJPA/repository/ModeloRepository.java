package br.bielsoft.relacionamentoDeTabelasJPA.repository;

import br.bielsoft.relacionamentoDeTabelasJPA.entities.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
