package com.algaworks.algafood.jpa;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

public class ConsultaFormaPagamentoMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        FormaPagamentoRepository FormaPagamentoRepository = context.getBean(FormaPagamentoRepository.class);
        List<FormaPagamento> todosFormaPagamentos = FormaPagamentoRepository.listar();
        todosFormaPagamentos.forEach(formaPagamento -> System.out.printf("%s\n", formaPagamento.getDescricao()));
    }
}
