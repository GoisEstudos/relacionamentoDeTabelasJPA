package br.bielsoft.relacionamentoDeTabelasJPA.service;

import br.bielsoft.relacionamentoDeTabelasJPA.DTO.FabricanteDTO;
import br.bielsoft.relacionamentoDeTabelasJPA.entities.Fabricante;
import br.bielsoft.relacionamentoDeTabelasJPA.repository.FabricanteRepository;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class FabricanteServiceTest {

    @Mock
    private FabricanteRepository repository;

    @InjectMocks
    private FabricanteService service;

    @Test
    void getFabricantes() {
        assertDoesNotThrow(() -> {
            List<Fabricante> newFabricante = Instancio.createList(Fabricante.class);
            Mockito.when(repository.findAll()).thenReturn(newFabricante);

            List<Fabricante> fabricantes = service.getFabricantes();
        });
    }

    @Test
    void getFabricante() {
        assertDoesNotThrow(() -> {
            Fabricante newFabricante = Instancio.create(Fabricante.class);
            Mockito.when(repository.findById(anyLong())).thenReturn(Optional.of(newFabricante));

            service.getFabricante(newFabricante.getId());
        });
    }

    @Test
    void saveFabricante() {
        assertDoesNotThrow(() -> {
            FabricanteDTO newFabricanteDTO = Instancio.create(FabricanteDTO.class);
            Fabricante newFabricante = Instancio.create(Fabricante.class);
            Mockito.when(repository.save(any(Fabricante.class))).thenReturn(newFabricante);

            service.saveFabricante(newFabricanteDTO);
        });
    }

    @Test
    void updateFabricante() {
        assertDoesNotThrow(() -> {
            FabricanteDTO newFabricanteDTO = Instancio.create(FabricanteDTO.class);
            Fabricante newFabricante = Instancio.create(Fabricante.class);
            Mockito.when(newFabricante).thenReturn(newFabricante);

            service.updateFabricante(newFabricanteDTO);
        });
    }

    @Test
    void deleteFabricante() {
    }
}