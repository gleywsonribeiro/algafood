package com.algaworks.algafood.jpa;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;

public class InclusaoRestauranteMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restauranteRepository = context.getBean(RestauranteRepository.class);

        Restaurante restaurante1 = new Restaurante();
        restaurante1.setNome("Comida Brasileita");
        restaurante1.setTaxaFrete(new BigDecimal("20"));

        Restaurante restaurante2 = new Restaurante();
        restaurante2.setNome("Sabor Paraibano");
        restaurante2.setTaxaFrete(new BigDecimal("15"));

        restauranteRepository.adicionar(restaurante1);
        restauranteRepository.adicionar(restaurante2);

    }
}
