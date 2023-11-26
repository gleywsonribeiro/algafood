package com.algaworks.algafood.jpa;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

public class ConsultaCidadeMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CidadeRepository cidadeRepository = context.getBean(CidadeRepository.class);
        List<Cidade> todasCidades = cidadeRepository.listar();
        todasCidades.forEach(cidade -> System.out.printf("%s - %s\n", cidade.getNome(), cidade.getEstado().getNome()));
    }
}
