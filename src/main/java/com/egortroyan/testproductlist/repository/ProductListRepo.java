package com.egortroyan.testproductlist.repository;

import com.egortroyan.testproductlist.repository.entity.ProductListEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductListRepo extends CrudRepository<ProductListEntity, Long> {
    ProductListEntity findByName (String name);
}
