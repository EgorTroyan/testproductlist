package com.egortroyan.testproductlist.service.impl;

import com.egortroyan.testproductlist.repository.ProductListRepo;
import com.egortroyan.testproductlist.repository.entity.ProductEntity;
import com.egortroyan.testproductlist.repository.entity.ProductListEntity;
import com.egortroyan.testproductlist.service.ProductListService;
import com.egortroyan.testproductlist.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProductListServiceImpl implements ProductListService {

    private final ProductListRepo productListRepo;

    private final ProductService productService;

    public ProductListServiceImpl(ProductListRepo productListRepo, ProductService productService) {
        this.productListRepo = productListRepo;
        this.productService = productService;
    }


    @Override
    public void addNewProductList(ProductListEntity productList) {
        ProductListEntity fpl = productListRepo.findByName(productList.getName());
        if (fpl == null){
            productListRepo.save(productList);
        }
    }

    @Override
    public ProductListEntity findProductList(String name) {
        return productListRepo.findByName(name);
    }

    @Override
    public void addProductToList(String productName, String listName) {
        ProductListEntity productList = productListRepo.findByName(listName);
        productList.addProduct(productService.findProduct(productName));
        productListRepo.save(productList);
    }

    @Override
    public List<ProductListEntity> getLists() {
        List<ProductListEntity> list = new ArrayList<>();
        Iterable<ProductListEntity> it = productListRepo.findAll();
        it.forEach(list::add);
        return list;
    }
}
