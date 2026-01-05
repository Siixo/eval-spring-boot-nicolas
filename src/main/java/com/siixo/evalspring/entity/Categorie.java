package com.siixo.evalspring.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Le libellé de la catégorie ne peut pas être null")
    @NotBlank(message = "Le libellé de la catégorie ne peut pas être vide")
    @Column(nullable = false)
    private String libele;

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<Produit> produits = new ArrayList<>();
}
