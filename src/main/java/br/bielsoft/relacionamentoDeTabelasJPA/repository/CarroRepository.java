package br.bielsoft.relacionamentoDeTabelasJPA.repository;

import br.bielsoft.relacionamentoDeTabelasJPA.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
}
