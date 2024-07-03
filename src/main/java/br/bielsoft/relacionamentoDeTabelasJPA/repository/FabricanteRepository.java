package br.bielsoft.relacionamentoDeTabelasJPA.repository;

import br.bielsoft.relacionamentoDeTabelasJPA.entities.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
}
