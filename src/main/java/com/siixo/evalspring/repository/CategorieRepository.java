package com.siixo.evalspring.repository;

import com.siixo.evalspring.entity.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Integer> {
}
