package com.oranet.hotelsystem.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Getter
@Setter
@Entity
@Table(name = "usuario")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @Column(name = "rg", length = 9, nullable = false)
    private String rg;

    private LocalDate dataNascimento;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Contato contato;

    @Column(name = "idade", nullable = false)
    private Integer idade;

    @Column(name = "nacionalidade", length = 255, nullable = false)
    private String nacionalidade;

    @Column(name = "criado_em", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    @UpdateTimestamp
    private LocalDateTime atualizadoEm;

    @PrePersist
    private void calcularIdade() {
        Period periodo = Period.between(dataNascimento, LocalDate.now());
        setIdade(periodo.getYears());
    }
}
