package com.ren.productcategory.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ren.product.entity.Product;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ProductCategory")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pCatNo")
    private Integer pCatNo;
    @Column(name = "pCatName")
    private String pCatName;
    @JsonBackReference
    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL)
    private Set<Product> products;

    public ProductCategory() {

    }

    public ProductCategory(Integer pCatNo) {
        this.pCatNo = pCatNo;
    }

    public ProductCategory(Integer pCatNo, String pCatName, Set<Product> products) {
        this.pCatNo = pCatNo;
        this.pCatName = pCatName;
        this.products = products;
    }

    public Integer getpCatNo() {
        return pCatNo;
    }

    public void setpCatNo(Integer pCatNo) {
        this.pCatNo = pCatNo;
    }

    public String getpCatName() {
        return pCatName;
    }

    public void setpCatName(String pCatName) {
        this.pCatName = pCatName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
