package br.bielsoft.relacionamentoDeTabelasJPA;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class RelacionamentoDeTabelasJpaApplicationTests {

	//PARA FUNCIONAR PRECISA ESTAR RODANDO O DOCKER.
//	@Test
//	void contextLoads() {
//	}

}
