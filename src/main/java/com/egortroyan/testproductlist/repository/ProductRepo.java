package com.egortroyan.testproductlist.repository;

import com.egortroyan.testproductlist.repository.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<ProductEntity, Long> {
    ProductEntity findByName (String name);
}
