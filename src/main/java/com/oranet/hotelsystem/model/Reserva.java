package com.oranet.hotelsystem.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "reserva")
public class Reserva {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "codigo_reserva", length = 255, nullable = false)
    private String codigoReserva;

    private LocalDate dataEntrada;
    private LocalDate dataSaida;

    @ManyToOne
    @JoinColumn(name = "quarto_id", nullable = false, foreignKey = @ForeignKey(name = "FK_RESERVA_QUARTO"))
    private Quarto quarto;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false, foreignKey = @ForeignKey(name = "FK_RESERVA_HOTEL"))
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false, foreignKey = @ForeignKey(name = "FK_RESERVA_USUARIO"))
    private Usuario usuario;

    @Column(name = "forma_pagamento", nullable = false)
    private FormaPagamento formaPagamento;

    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    @Column(name = "observacoes", length = 255)
    private String observacoes;

    @Column(name = "criado_em", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    @UpdateTimestamp
    private LocalDateTime atualizadoEm;

    @Column(name = "duracao_dias")
    private Integer duracaoDias;

    @PrePersist
    private void calcularDuracaoValor() {
        Integer duracaoDias = dataSaida.getDayOfMonth() - dataEntrada.getDayOfMonth();
        setDuracaoDias(duracaoDias);
        setValorTotal(duracaoDias * quarto.getValorDiaria());
    }

}
