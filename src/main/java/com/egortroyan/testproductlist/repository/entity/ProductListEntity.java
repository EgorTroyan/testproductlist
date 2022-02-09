package com.egortroyan.testproductlist.repository.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="list", indexes = {@Index(name = "list_name_indx", columnList = "name")})
public class ProductListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "list_product",
            joinColumns = @JoinColumn(name = "list_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<ProductEntity> products = new HashSet<>();

    public void addProduct(ProductEntity product){
        this.products.add(product);
        product.getLists().add(this);
    }

    public void removeProduct(ProductEntity product){
        this.products.remove(product);
        product.getLists().remove(this);
    }

    public ProductListEntity() {
    }

    public ProductListEntity(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductListEntity that = (ProductListEntity) o;
        return id == that.id && name.equals(that.name) && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, products);
    }
}
