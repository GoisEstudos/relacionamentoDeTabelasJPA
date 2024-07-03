package br.bielsoft.relacionamentoDeTabelasJPA.controller;

import br.bielsoft.relacionamentoDeTabelasJPA.DTO.FabricanteDTO;
import br.bielsoft.relacionamentoDeTabelasJPA.entities.Fabricante;
import br.bielsoft.relacionamentoDeTabelasJPA.service.FabricanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fabricante")
@RequiredArgsConstructor
public class FabricanteController {

    @Autowired
    private FabricanteService service;

    @GetMapping
    public ResponseEntity<List<Fabricante>> getFabricantes(){
        List<Fabricante> fabricantes = service.getFabricantes();
        return ResponseEntity.ok(fabricantes);
    }

    @GetMapping("{id}")
    public ResponseEntity<Fabricante> getFabricanteId(@PathVariable Long id){
        Fabricante fabricante = service.getFabricante(id);
        return ResponseEntity.ok(fabricante);
    }

    @PostMapping
    public ResponseEntity<Fabricante> saveFabricante(@RequestBody FabricanteDTO fabricanteDTO){
        Fabricante newFabricante = service.saveFabricante(fabricanteDTO);
        return ResponseEntity.ok(newFabricante);
    }

    @PatchMapping
    public ResponseEntity<Fabricante> updateFabricante(@RequestBody FabricanteDTO fabricanteDTO){
        Fabricante newFabricante = service.updateFabricante(fabricanteDTO);
        return ResponseEntity.ok(newFabricante);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteFabricante(@PathVariable Long id) {
        service.deleteFabricante(id);
       return ResponseEntity.ok("FABRICANTE EXCLUIDO COM SUCESSO!");
    }
}
