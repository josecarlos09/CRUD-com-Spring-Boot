package com.food.food.dto.pagamento;


import com.food.food.model.pagamento.FormaDePagamento;
import com.food.food.model.pagamento.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter

public class CadastroPagamentoDto{
   private UUID id;
    private BigDecimal valor;
    private String nome;
    private String numero;
    private String expiracao;
    private String codigo;
    private Status status;
    private Long pedido_id;
    private FormaDePagamento forma_pagamento;
}
