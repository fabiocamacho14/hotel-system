package com.oranet.hotelsystem.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "quarto")
public class Quarto {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "codigo_quarto", length = 255, nullable = false)
    private String codigoQuarto;

    @Column(name = "tipo_quarto", length = 255, nullable = false)
    private TipoQuarto tipoQuarto;

    @Column(name = "tem_banheiro", nullable = false)
    private Boolean temBanheiro;

    @Column(name = "valor_diaria", nullable = false)
    private Double valorDiaria;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false, foreignKey = @ForeignKey(name = "FK_QUARTO_HOTEL"))
    private Hotel hotel;

    @Column(name = "criado_em", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    @UpdateTimestamp
    private LocalDateTime atualizadoEm;
}
