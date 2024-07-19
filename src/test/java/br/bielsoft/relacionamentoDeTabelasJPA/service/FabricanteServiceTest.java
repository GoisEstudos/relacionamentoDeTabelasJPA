package br.bielsoft.relacionamentoDeTabelasJPA.service;

import br.bielsoft.relacionamentoDeTabelasJPA.DTO.FabricanteDTO;
import br.bielsoft.relacionamentoDeTabelasJPA.entities.Fabricante;
import br.bielsoft.relacionamentoDeTabelasJPA.repository.FabricanteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;


class FabricanteServiceTest {

    private final FabricanteRepository repository = Mockito.mock(FabricanteRepository.class);

    private FabricanteService service = new FabricanteService(repository);
    @Test()
    @DisplayName("""
           Dados sem nenhum parameto
           Quando consultado todos os fabricantes
           Deve ser retornado uma lista de fabricantes.
    """)
    public void testFabricanteGetFabricantes(){
        Mockito.when(repository.findAll()).thenReturn(List.of(new Fabricante()));

        List<Fabricante> listFabricante = service.getFabricantes();

        Assertions.assertEquals(1, listFabricante.size());
    }

    @Test()
    @DisplayName("""
            Dados o ID como parametro
            Quando consultado todos os fabricantes
            Deve ser retornado um igual ao ID do fabricante.
            """)
    public void testFabricanteById(){
        Long id = 1L;

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(new Fabricante()));

        Fabricante newFabricante = service.getFabricanteById(id);

        Assertions.assertEquals(new Fabricante(), newFabricante);
    }

    @Test()
    @DisplayName("""
            Dados nome do fabricante como parametro
            Quando consultado todos os fabricantes
            Deve ser retornado o fabricante salvo.
            """)
    public void testSaveFabricante(){
        FabricanteDTO newFabricanteDTO = new FabricanteDTO(1L, "FORD");

        Fabricante newFabricante = new Fabricante(newFabricanteDTO);
        Mockito.when(repository.save(newFabricante)).thenReturn(newFabricante);

        Fabricante body = service.saveFabricante(newFabricanteDTO);

        Assertions.assertEquals(newFabricante, body);
    }

    @Test()
    @DisplayName("""
            Dados nome do fabricante como parametro
            Quando consultado todos os fabricantes
            Deve ser retornado o fabricante atualizado
            """)
    public void testUpdateFabricante(){
        FabricanteDTO newFabricanteDTO = new FabricanteDTO(1L, "FORD");
        Fabricante newFabricante = new Fabricante(newFabricanteDTO);

        Mockito.when(repository.findById(newFabricanteDTO.id())).thenReturn(Optional.of(newFabricante));

        Mockito.when(repository.save(Mockito.any(Fabricante.class))).thenReturn(newFabricante);

        Fabricante body = service.updateFabricante(newFabricanteDTO);

        Assertions.assertEquals(newFabricante, body);
    }

    @Test()
    @DisplayName("""
            Dados um ID do fabricante como parametro
            Qundo consultado todos os fabricantes
            Dever ser retornado a frase: FABRICANTE DELETADO COM SUCESSO!
            """)
    public void testDeleteFabricante(){
        Assertions.assertDoesNotThrow(() -> {
            Long id = 1L;

            service.deleteFabricante(id);

            Mockito.verify(repository).deleteById(id);
        });
    }
}