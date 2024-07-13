package br.bielsoft.relacionamentoDeTabelasJPA.controller;

import br.bielsoft.relacionamentoDeTabelasJPA.DTO.CarroDTO;
import br.bielsoft.relacionamentoDeTabelasJPA.entities.Carro;
import br.bielsoft.relacionamentoDeTabelasJPA.service.CarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/carro")
@RequiredArgsConstructor
public class CarroController {

    @Autowired
    private final CarroService service;

    @GetMapping
    public ResponseEntity<List<Carro>> getCarros(){
        List<Carro> newCarros = service.getCarros();
        return ResponseEntity.ok(newCarros);
    }

    @GetMapping("{id}")
    public ResponseEntity<Carro> getCarro(@PathVariable Long id){
        Carro newCarro = service.getCarro(id);
        return ResponseEntity.ok(newCarro);
    }

    @PostMapping
    public ResponseEntity<Carro> saveCarro(@RequestBody CarroDTO carroDTO){
        Carro newCarro = service.saveCarro(carroDTO);
        return ResponseEntity.ok(newCarro);
    }

    @PatchMapping
    public ResponseEntity<Carro> updateCarro(@RequestBody CarroDTO carroDTO){
        Carro newCarro = service.updateCarro(carroDTO);
        return ResponseEntity.ok(newCarro);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCarro(@PathVariable Long id){
        service.deleteCarro(id);
        return ResponseEntity.ok("CARRO DELETADO COM SUCESSO!");
    }
}
