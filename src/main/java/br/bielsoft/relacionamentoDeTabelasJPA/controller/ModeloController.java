package br.bielsoft.relacionamentoDeTabelasJPA.controller;

import br.bielsoft.relacionamentoDeTabelasJPA.DTO.ModeloDTO;
import br.bielsoft.relacionamentoDeTabelasJPA.entities.Modelo;
import br.bielsoft.relacionamentoDeTabelasJPA.service.ModeloService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/modelo")
@RequiredArgsConstructor
public class ModeloController {

    @Autowired
    private ModeloService service;

    @GetMapping
    public ResponseEntity<List<Modelo>> getModelos(){
        List<Modelo> modelos = service.getModelos();
        return ResponseEntity.ok(modelos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Modelo> getModelo(@PathVariable Long id){
        Modelo modelo = service.getModelo(id);
        return ResponseEntity.ok(modelo);
    }

    @PostMapping
    public ResponseEntity<Modelo> saveModelo(@RequestBody ModeloDTO modeloDTO){
        Modelo newModelo = service.saveModelo(modeloDTO);
        return ResponseEntity.ok(newModelo);
    }

    @PatchMapping
    public ResponseEntity<Modelo> updateModelo(@RequestBody ModeloDTO modeloDTO){
        Modelo newModelo = service.updateModelo(modeloDTO);
        return ResponseEntity.ok(newModelo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteModelo(@PathVariable Long id){
        service.deleteModelo(id);
        return ResponseEntity.ok("MODELO EXCLUIDO COM SUCESSO!");
    }
}