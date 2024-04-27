package com.ren.product.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.iting.cart.entity.Cart;
import com.iting.productmyfavorite.entity.ProductMyFavorite;
import com.iting.productorderdetail.entity.ProductOrderDetail;
import com.iting.productpicture.entity.ProductPicture;
import com.ren.productcategory.entity.ProductCategory;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pNo")
    private Integer pNo;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "pCatNo", referencedColumnName = "pCatNo")
    private ProductCategory productCategory;
    @Column(name = "pName")
    private String pName;
    @Column(name = "pInfo")
    private String pInfo;
    @Column(name = "pSize")
    private Integer pSize;
    @Column(name = "pColor")
    private String pColor;
    @Column(name = "pPrice")
    private BigDecimal pPrice;
    @Column(name = "pStat")
    private Byte pStat;
    @Column(name = "pSalQty")
    private Integer pSalQty;
    @Column(name = "pComPeople")
    private Integer pComPeople;
    @Column(name = "pComScore")
    private Integer pComScore;
    @JsonBackReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductOrderDetail> productOrderDetails;
    @JsonBackReference
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Set<ProductMyFavorite> productMyFavorites;
    @JsonBackReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Cart> carts;
    @JsonBackReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductPicture> productPictures;

    public Product() {

    }

    // insert用建構子
    public Product(ProductCategory productCategory, String pName, String pInfo, Integer pSize, String pColor, BigDecimal pPrice, Byte pStat, Integer pSalQty, Integer pComPeople, Integer pComScore) {
        this.productCategory = productCategory;
        this.pName = pName;
        this.pInfo = pInfo;
        this.pSize = pSize;
        this.pColor = pColor;
        this.pPrice = pPrice;
        this.pStat = pStat;
        this.pSalQty = pSalQty;
        this.pComPeople = pComPeople;
        this.pComScore = pComScore;
    }

    // Update用建構子
    public Product(Integer pNo, ProductCategory productCategory, String pName, String pInfo, Integer pSize, String pColor, BigDecimal pPrice, Byte pStat, Integer pSalQty, Integer pComPeople, Integer pComScore) {
        this.pNo = pNo;
        this.productCategory = productCategory;
        this.pName = pName;
        this.pInfo = pInfo;
        this.pSize = pSize;
        this.pColor = pColor;
        this.pPrice = pPrice;
        this.pStat = pStat;
        this.pSalQty = pSalQty;
        this.pComPeople = pComPeople;
        this.pComScore = pComScore;
    }

    public Integer getpNo() {
        return pNo;
    }

    public void setpNo(Integer pNo) {
        this.pNo = pNo;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpInfo() {
        return pInfo;
    }

    public void setpInfo(String pInfo) {
        this.pInfo = pInfo;
    }

    public Integer getpSize() {
        return pSize;
    }

    public void setpSize(Integer pSize) {
        this.pSize = pSize;
    }

    public String getpColor() {
        return pColor;
    }

    public void setpColor(String pColor) {
        this.pColor = pColor;
    }

    public BigDecimal getpPrice() {
        return pPrice;
    }

    public void setpPrice(BigDecimal pPrice) {
        this.pPrice = pPrice;
    }

    public Byte getpStat() {
        return pStat;
    }

    public void setpStat(Byte pStat) {
        this.pStat = pStat;
    }

    public Integer getpSalQty() {
        return pSalQty;
    }

    public void setpSalQty(Integer pSalQty) {
        this.pSalQty = pSalQty;
    }

    public Integer getpComPeople() {
        return pComPeople;
    }

    public void setpComPeople(Integer pComPeople) {
        this.pComPeople = pComPeople;
    }

    public Integer getpComScore() {
        return pComScore;
    }

    public void setpComScore(Integer pComScore) {
        this.pComScore = pComScore;
    }

    public Set<ProductOrderDetail> getProductOrderDetails() {
        return productOrderDetails;
    }

    public void setProductOrderDetails(Set<ProductOrderDetail> productOrderDetails) {
        this.productOrderDetails = productOrderDetails;
    }

    public Set<ProductMyFavorite> getProductMyFavorites() {
        return productMyFavorites;
    }

    public void setProductMyFavorites(Set<ProductMyFavorite> productMyFavorites) {
        this.productMyFavorites = productMyFavorites;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    public Set<ProductPicture> getProductPictures() {
        return productPictures;
    }

    public void setProductPictures(Set<ProductPicture> productPictures) {
        this.productPictures = productPictures;
    }
}