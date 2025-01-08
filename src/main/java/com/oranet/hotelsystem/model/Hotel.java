package com.oranet.hotelsystem.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Table(name = "hotel")
public class Hotel {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Contato contato;

    @ManyToMany
    @JoinTable(name = "hotel_dono",
            joinColumns = @JoinColumn(name = "hotel_id"), foreignKey = @ForeignKey(name = "FK_HOTEL_USUARIO"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"), inverseForeignKey = @ForeignKey(name = "FK_USUARIO_HOTEL"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"hotel_id", "usuario_id"}))
    private Set<Usuario> donos = new HashSet<Usuario>();

    @OneToMany(mappedBy = "hotel")
    private Set<Quarto> quartos = new HashSet<Quarto>();

    @Column(name = "criado_em", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    @UpdateTimestamp
    private LocalDateTime atualizadoEm;
}
