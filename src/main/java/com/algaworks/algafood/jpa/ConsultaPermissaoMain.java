package com.algaworks.algafood.jpa;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

public class ConsultaPermissaoMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        PermissaoRepository PermissaoRepository = context.getBean(PermissaoRepository.class);
        List<Permissao> todosPermissaos = PermissaoRepository.listar();
        todosPermissaos.forEach(permissao -> System.out.printf("%s - %s\n",permissao.getNome(), permissao.getDescricao()));
    }
}
