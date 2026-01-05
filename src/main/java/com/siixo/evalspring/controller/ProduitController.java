package com.siixo.evalspring.controller;

import com.siixo.evalspring.services.ProduitsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produits")
@RequiredArgsConstructor

public class ProduitController {
    private final ProduitsService produitsService;

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable int id) {
        Produit produit = produitService.recupererProduitParId(id);
        return ResponseEntity.ok(produit);
    }

    @GetMapping
    public ResponseEntity<List<Produit>> getAllProduits() {
        List<Produit> produits = produitService.recupererTousLesProduits();
        return ResponseEntity.ok(produits);
    }

    @PostMapping
    public ResponseEntity<Produit> ajouterProduit(@Valid @RequestBody Produit produit) {
        Produit nouveauProduit = produitService.ajouterProduit(produit);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouveauProduit);
    }
}
