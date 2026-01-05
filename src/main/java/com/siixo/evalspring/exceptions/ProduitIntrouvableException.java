package com.siixo.evalspring.exceptions;

public class ProduitIntrouvableException extends RuntimeException {
    public ProduitIntrouvableException(int id) {
        super("Le produit avec l'id: " +id + " est introuvable");
    }
}
