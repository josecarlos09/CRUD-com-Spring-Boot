package com.food.food.model.pagamento;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "pagamentos")

@EqualsAndHashCode(of = "id")// Indica a chave primary-key.
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private BigDecimal valor;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotNull
    private Long pedido_id; // O ideal seria receber um pedido.

    @NotNull
    @Size(max = 19)
    private String numero;

    @NotNull
    @Size(max = 15)
    private String expiracao;

    @NotNull
    @Size(max = 3, min = 3)
    private String codigo;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private FormaDePagamento forma_pagamento;
}
