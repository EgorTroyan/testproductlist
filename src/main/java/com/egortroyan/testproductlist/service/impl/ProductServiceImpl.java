package com.egortroyan.testproductlist.service.impl;

import com.egortroyan.testproductlist.repository.ProductRepo;
import com.egortroyan.testproductlist.repository.entity.ProductEntity;
import com.egortroyan.testproductlist.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public void addNewProduct(ProductEntity product) {
        ProductEntity pf = productRepo.findByName(product.getName());
        if(pf == null){
            productRepo.save(product);
        }
    }

    @Override
    public ProductEntity findProduct(String productName) {
        return productRepo.findByName(productName);
    }

    @Override
    public List<ProductEntity> getProducts() {
        List<ProductEntity> list = new ArrayList<>();
        Iterable<ProductEntity> it = productRepo.findAll();
        it.forEach(list::add);
        return list;
    }


}
