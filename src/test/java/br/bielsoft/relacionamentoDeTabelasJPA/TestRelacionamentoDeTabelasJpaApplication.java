package br.bielsoft.relacionamentoDeTabelasJPA;

import org.springframework.boot.SpringApplication;

public class TestRelacionamentoDeTabelasJpaApplication {

	public static void main(String[] args) {
		SpringApplication.from(RelacionamentoDeTabelasJpaApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
