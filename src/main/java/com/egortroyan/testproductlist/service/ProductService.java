package com.egortroyan.testproductlist.service;

import com.egortroyan.testproductlist.repository.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    void addNewProduct(ProductEntity product);
    ProductEntity findProduct(String productName);
    List<ProductEntity> getProducts();

}
