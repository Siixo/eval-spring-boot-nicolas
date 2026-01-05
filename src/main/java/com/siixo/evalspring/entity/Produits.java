package com.siixo.evalspring.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Produits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produits {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private integer id;

    @NotNull(message = "Le nom du produit ne peut pas être null")
    @NotBlank(message = "Le nom du produit ne peut pas être vide")
    @Size(min = 3, message = "Le nom du produit doit contenir au moins 3 caractères")
    @Column(nullable = false)
    private String nom;

    @NotNull(message = "Le prix du produit ne peut pas être null")
    @DecimalMin(value = "0.01", message = "Le prix du produit doit être supérieur à zéro")
    @Positive(message = "Le prix du produit doit être un montant positif")
    @Column(nullable = false)
    private float prix;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id", nullable = true)
    private Categorie categorie;
}