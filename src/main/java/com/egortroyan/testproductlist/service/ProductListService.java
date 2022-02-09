package com.egortroyan.testproductlist.service;

import com.egortroyan.testproductlist.repository.entity.ProductListEntity;
import com.egortroyan.testproductlist.response.Response;

import java.util.List;

public interface ProductListService {
    Response addNewProductList(ProductListEntity productList);
    ProductListEntity findProductList(String name);
    Response addProductToList(String productName, String listName);
    List<ProductListEntity> getLists();
}
