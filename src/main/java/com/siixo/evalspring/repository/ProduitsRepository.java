package com.siixo.evalspring.repository;

import com.siixo.evalspring.entity.Produits;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitsRepository extends CrudRepository<Produits, Integer> {


}
