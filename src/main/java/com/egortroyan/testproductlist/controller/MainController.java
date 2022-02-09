package com.egortroyan.testproductlist.controller;

import com.egortroyan.testproductlist.repository.entity.ProductEntity;
import com.egortroyan.testproductlist.repository.entity.ProductListEntity;
import com.egortroyan.testproductlist.service.ProductListService;
import com.egortroyan.testproductlist.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    private final ProductService productService;
    private final ProductListService productListService;

    public MainController(ProductService productService, ProductListService productListService) {
        this.productService = productService;
        this.productListService = productListService;
    }

    @PostMapping("/api/addnewproduct")
    public ResponseEntity<Object> addProduct(@RequestBody ProductEntity product){
        productService.addNewProduct(product);
        return new ResponseEntity<Object> (HttpStatus.OK);
    }

    @PostMapping("/api/addnewproductlist")
    public ResponseEntity<Object> addProductList(@RequestBody ProductListEntity productList){
        productListService.addNewProductList(productList);
        return new ResponseEntity<Object> (HttpStatus.OK);
    }

    @PostMapping("/api/addproducttolist")
    public ResponseEntity<Object> addProductToList(@RequestParam(name = "product") String productName, @RequestParam(name = "list") String listName){
        productListService.addProductToList(productName,listName);
        return new ResponseEntity<Object> (HttpStatus.OK);
    }

    @GetMapping("/api/getproducts")
    public ResponseEntity<Object> getProducts(){
        //System.out.println("пришел запрос");
        List<ProductEntity> list = productService.getProducts();
        //System.out.println("список получен");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/api/getproductslists")
    public ResponseEntity<Object> getProductsLists(){
        List<ProductListEntity> list = productListService.getLists();
        return ResponseEntity.ok(list);
    }
}
