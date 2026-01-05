package com.siixo.evalspring.services;

import com.siixo.evalspring.entity.Categorie;
import com.siixo.evalspring.exceptions.CategorieInvalideException;
import com.siixo.evalspring.exceptions.CategorieIntrouvableException;
import com.siixo.evalspring.repository.CategorieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategorieService {

    private final CategorieRepository categorieRepository;

    /**
     * Ajouter une catégorie
     * @param categorie
     * @return La catégorie ajoutée avec son ID généré
     * @throws CategorieInvalideException
     */
    public Categorie ajouterCategorie(Categorie categorie) {
        if (categorie == null) {
            throw new CategorieInvalideException("La catégorie ne peut pas être null");
        }

        if (categorie.getLibele() == null || categorie.getLibele().trim().isEmpty()) {
            throw new CategorieInvalideException("Le libellé de la catégorie ne peut pas être vide"); //Puisque déclaré non nulle dans l'entité
        }

        try {
            return categorieRepository.save(categorie);
        } catch (Exception e) {
            throw new CategorieInvalideException("Erreur lors de l'ajout de la catégorie : " + e.getMessage());
        }
    }

    /**
     * Récupérer la liste de toutes les catégories
     * @return Liste de toutes les catégories
     */
    public List<Categorie> recupererToutesLesCategories() {
        return categorieRepository.findAll(); //Le fameux problème entre list et itérable, à fixer!
    }

    /**
     * Récupérer une catégorie par ID
     * @param id
     * @return La catégorie trouvée
     * @throws CategorieIntrouvableException
     */
    public Categorie recupererCategorieParId(int id) {
        return categorieRepository.findById(id)
                .orElseThrow(() -> new CategorieIntrouvableException(id));
    }
}