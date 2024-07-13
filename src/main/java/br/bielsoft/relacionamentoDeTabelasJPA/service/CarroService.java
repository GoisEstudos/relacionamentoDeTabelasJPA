package br.bielsoft.relacionamentoDeTabelasJPA.service;

import br.bielsoft.relacionamentoDeTabelasJPA.DTO.CarroDTO;
import br.bielsoft.relacionamentoDeTabelasJPA.entities.Carro;
import br.bielsoft.relacionamentoDeTabelasJPA.entities.Fabricante;
import br.bielsoft.relacionamentoDeTabelasJPA.entities.Modelo;
import br.bielsoft.relacionamentoDeTabelasJPA.repository.CarroRepository;
import br.bielsoft.relacionamentoDeTabelasJPA.repository.FabricanteRepository;
import br.bielsoft.relacionamentoDeTabelasJPA.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    FabricanteRepository fabricanteRepository;

    @Autowired
    ModeloRepository modeloRepository;

    @Autowired
    CarroRepository carroRepository;

    public List<Carro> getCarros(){
        return carroRepository.findAll();
    }

    public Carro getCarro(Long id){
        return carroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID NAO ENCONTRADO"));
    }

    @Transactional
    public Carro saveCarro(CarroDTO carroDTO){
        Fabricante fabricante = fabricanteRepository.findById(carroDTO.idFabricante())
                .orElseThrow(() -> new RuntimeException("FABRICANTE NAO ENCONTRADO!"));

        Modelo modelo = modeloRepository.findById(carroDTO.idModelo())
                .orElseThrow(() -> new RuntimeException("MODELO NAO ENCONTRADO!"));

        Carro newCarro = new Carro(carroDTO);
        newCarro.setFabricante(fabricante);
        newCarro.setModelo(modelo);
        newCarro.setPlaca(carroDTO.placa());
        newCarro.setCor(carroDTO.cor());
        newCarro.setDisponivel(carroDTO.disponivel());
        newCarro.setAno(carroDTO.ano());
        newCarro.setValorlocacao(carroDTO.valorlocacao());

        return carroRepository.save(newCarro);
    }

    public Carro updateCarro(CarroDTO carroDTO){
        Carro newCarro = carroRepository.findById(carroDTO.id())
                .orElseThrow(() -> new RuntimeException("ID NAO ENCONTRADO"));

        newCarro.setPlaca(carroDTO.placa());
        newCarro.setCor(carroDTO.cor());
        newCarro.setDisponivel(carroDTO.disponivel());
        newCarro.setAno(carroDTO.ano());
        newCarro.setValorlocacao(carroDTO.valorlocacao());

        return carroRepository.save(newCarro);
    }

    public void deleteCarro(Long id){
        carroRepository.deleteById(id);
    }
}
