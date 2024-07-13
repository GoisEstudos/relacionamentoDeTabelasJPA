package br.bielsoft.relacionamentoDeTabelasJPA.service;

import br.bielsoft.relacionamentoDeTabelasJPA.DTO.ModeloDTO;
import br.bielsoft.relacionamentoDeTabelasJPA.entities.Fabricante;
import br.bielsoft.relacionamentoDeTabelasJPA.entities.Modelo;
import br.bielsoft.relacionamentoDeTabelasJPA.repository.FabricanteRepository;
import br.bielsoft.relacionamentoDeTabelasJPA.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModeloService {

    @Autowired
    private FabricanteRepository fabricanteRepository;
    @Autowired
    private ModeloRepository modeloRepository;

    public List<Modelo> getModelos(){
        return modeloRepository.findAll();
    }

    public Modelo getModelo(Long id){
        return modeloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID NAO ENCONTRADO"));
    }

    @Transactional
    public Modelo saveModelo(ModeloDTO modeloDTO){
        Fabricante fabricante = fabricanteRepository.findById(modeloDTO.idFabricante())
                .orElseThrow(() -> new RuntimeException("FABRICANTE NAO ENCONTRADO!"));

        Modelo newModelo = new Modelo(modeloDTO);
        newModelo.setNome(modeloDTO.nome());
        newModelo.setFabricante(fabricante);

        return modeloRepository.save(newModelo);
    }

    public Modelo updateModelo(ModeloDTO modeloDTO){
        Modelo newModelo = modeloRepository.findById(modeloDTO.id())
                .orElseThrow(() -> new RuntimeException("ID NAO ENCONTRADO"));

        newModelo.setNome(modeloDTO.nome());
        return modeloRepository.save(newModelo);
    }

    public void deleteModelo(Long id){
        modeloRepository.deleteById(id);
    }
}
