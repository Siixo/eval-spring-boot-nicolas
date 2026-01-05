package com.siixo.evalspring.exceptions;

public class CategorieIntrouvableException extends RuntimeException {
    public CategorieIntrouvableException(int id) {
        super("La catégorie avec l'id: " + id + " est introuvable");
    }
}
