package com.ren.productcategory.model;

import com.ren.product.model.ProductVO;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ProductCategory")
public class ProductCategoryVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pCatNo")
    private Integer pCatNo;
    @Column(name = "pCatName")
    private String pCatName;
    @OneToMany(mappedBy = "Product", cascade = CascadeType.ALL)
    @OrderBy("pCatNo asc")
    private Set<ProductVO> products;

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

    public Set<ProductVO> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductVO> products) {
        this.products = products;
    }
}
