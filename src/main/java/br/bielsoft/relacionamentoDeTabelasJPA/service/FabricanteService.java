package br.bielsoft.relacionamentoDeTabelasJPA.service;

import br.bielsoft.relacionamentoDeTabelasJPA.DTO.FabricanteDTO;
import br.bielsoft.relacionamentoDeTabelasJPA.entities.Fabricante;
import br.bielsoft.relacionamentoDeTabelasJPA.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository repository;

    public List<Fabricante> getFabricantes(){
        return repository.findAll();
    }

    public Fabricante getFabricante(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID NAO ENCONTRADO"));
    }

    @Transactional
    public Fabricante saveFabricante(FabricanteDTO fabricanteDTO){
        Fabricante newFabricante = new Fabricante(fabricanteDTO);
        return repository.save(newFabricante);
    }

    public Fabricante updateFabricante(FabricanteDTO fabricanteDTO){
        Fabricante newFabricante = repository.findById(fabricanteDTO.id())
                .orElseThrow(() -> new RuntimeException());

        newFabricante.setNome(fabricanteDTO.nome());
        return repository.save(newFabricante);
    }

    public void deleteFabricante(Long id){
      repository.deleteById(id);
    }
}
