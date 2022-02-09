package com.egortroyan.testproductlist.service;

import com.egortroyan.testproductlist.repository.entity.ProductEntity;
import com.egortroyan.testproductlist.response.Response;

import java.util.List;


public interface ProductService {
    Response addNewProduct(ProductEntity product);
    ProductEntity findProduct(String productName);
    List<ProductEntity> getProducts();

}
