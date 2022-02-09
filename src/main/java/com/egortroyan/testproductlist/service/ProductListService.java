package com.egortroyan.testproductlist.service;

import com.egortroyan.testproductlist.repository.entity.ProductEntity;
import com.egortroyan.testproductlist.repository.entity.ProductListEntity;

import java.util.List;

public interface ProductListService {
    void addNewProductList(ProductListEntity productList);
    ProductListEntity findProductList(String name);
    void addProductToList(String productName, String listName);
    List<ProductListEntity> getLists();
}
