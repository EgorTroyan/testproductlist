package com.egortroyan.testproductlist.controller;

import com.egortroyan.testproductlist.repository.entity.ProductEntity;
import com.egortroyan.testproductlist.repository.entity.ProductListEntity;
import com.egortroyan.testproductlist.response.Response;
import com.egortroyan.testproductlist.service.ProductListService;
import com.egortroyan.testproductlist.service.ProductService;
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
        Response response = productService.addNewProduct(product);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/addnewproductlist")
    public ResponseEntity<Object> addProductList(@RequestBody ProductListEntity productList){
        Response response = productListService.addNewProductList(productList);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/addproducttolist")
    public ResponseEntity<Object> addProductToList(@RequestParam(name = "product") String productName, @RequestParam(name = "list") String listName){
        Response response = productListService.addProductToList(productName,listName);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/getproducts")
    public ResponseEntity<Object> getProducts(){
        List<ProductEntity> list = productService.getProducts();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/api/getproductslists")
    public ResponseEntity<Object> getProductsLists(){
        List<ProductListEntity> list = productListService.getLists();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/api/getproductlist")
    public ResponseEntity<Object> getProductsList(@RequestParam(name = "id") long id){
        ProductListEntity list = productListService.getListById(id);
        return ResponseEntity.ok(list);
    }
}
