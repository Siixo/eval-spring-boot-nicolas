package com.siixo.evalspring.services;

import com.siixo.evalspring.exceptions.ProduitInvalideException;
import com.siixo.evalspring.exceptions.ProduitIntrouvableException;
import com.siixo.evalspring.repository.ProduitsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProduitsService {
    private final ProduitsRepository repository;


    /**
     *
     * @param Produit Le Produit à ajouter
     * @return Le produit ajouté avec son id généré
     * @throws ProduitInvalideException si le produit est null
     */
    public Produit ajouterProduit(Produit produit) {
        if (produit == null) {
            throw new ProduitInvalideException("Le produit ne peut pas être null");
        }

        try {
            return produitRepository.save(produit);
        } catch (Exception e) {
            throw new ProduitInvalideException("Erreur lors de l'ajout du produit : " + e.getMessage());
        }
    }

    /**
     * @param void
     * @return La liste de tous les produits
     */
    public List<Produit> recupererTousLesProduits() {
        return produitRepository.findAll();
    }

    /**
     * Récuperer un produit par l'ID
     * @param id
     * @return Le produit trouvé
     * @throws ProduitIntrouvableException
     */
    public Optional<Produit> recupererProduitParId(int id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new ProduitIntrouvableException(id));
    }
}
