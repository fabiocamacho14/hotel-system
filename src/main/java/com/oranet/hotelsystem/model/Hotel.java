package com.oranet.hotelsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode()
@Getter
@Setter
@Table(name = "hotel")
public class Hotel {

    @Id
    private Integer id;

    private String name;

    private String descricao;


}
