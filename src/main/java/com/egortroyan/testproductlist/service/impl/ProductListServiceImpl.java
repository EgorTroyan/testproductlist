package com.egortroyan.testproductlist.service.impl;

import com.egortroyan.testproductlist.repository.ProductListRepo;
import com.egortroyan.testproductlist.repository.entity.ProductEntity;
import com.egortroyan.testproductlist.repository.entity.ProductListEntity;
import com.egortroyan.testproductlist.response.Response;
import com.egortroyan.testproductlist.service.ProductListService;
import com.egortroyan.testproductlist.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductListServiceImpl implements ProductListService {

    private final ProductListRepo productListRepo;

    private final ProductService productService;

    public ProductListServiceImpl(ProductListRepo productListRepo, ProductService productService) {
        this.productListRepo = productListRepo;
        this.productService = productService;
    }


    @Override
    public Response addNewProductList(ProductListEntity productList) {
        ProductListEntity fpl = productListRepo.findByName(productList.getName());
        if (fpl != null){
            return new Response("Такой список уже существует");
        } else {
            productListRepo.save(productList);
            return new Response("Новый список добавлен");
        }
    }

    @Override
    public ProductListEntity findProductList(String name) {
        return productListRepo.findByName(name);
    }

    @Override
    public Response addProductToList(String productName, String listName) {
        listName = listName.replaceAll("[|]","");
        ProductListEntity productList = productListRepo.findByName(listName);
        if(productList == null){
            return new Response("Указано неверное название списка");
        }
        productName = productName.replaceAll("[|]","");
        ProductEntity product = productService.findProduct(productName);
        if(product == null){
            return new Response("Указано неверное наименование продукта");
        }
        productList.addProduct(product);
        productListRepo.save(productList);
        return new Response("Продукт " + product.getName() + " добавлен в список " + productList.getName());
    }

    @Override
    public List<ProductListEntity> getLists() {
        List<ProductListEntity> list = new ArrayList<>();
        Iterable<ProductListEntity> it = productListRepo.findAll();
        it.forEach(list::add);
        return list;
    }

    @Override
    public ProductListEntity getListById(long id) {
        Optional<ProductListEntity> optional = productListRepo.findById(id);
        ProductListEntity productList;
        if(optional.isPresent()) {
            productList = optional.get();
        } else {
            return null;
        }
        return productList;
    }
}
