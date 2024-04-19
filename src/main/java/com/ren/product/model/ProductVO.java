package com.ren.product.model;

import com.ren.productcategory.model.ProductCategoryVO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "Product")
public class ProductVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pNo")
    private Integer pNo;
    // JDBC、JNDI使用(Hibernate換成ManyToOne)
//    @Column(name = "pCatNo")
//    private Integer pCatNo;
    @ManyToOne
    @JoinColumn(name = "pCatNo", referencedColumnName = "pCatNo")
    private ProductCategoryVO productCategory;
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
    @OneToMany(mappedBy = "ProductOrderDetail", cascade = CascadeType.ALL)
    private Set<ProductVO> productOrderDetails;
    @OneToMany(mappedBy = "ProductMyFavorite",cascade = CascadeType.ALL)
    private Set<ProductVO> productMyFavorites;
    @OneToMany(mappedBy = "Cart", cascade = CascadeType.ALL)
    private Set<ProductVO> carts;
    @OneToMany(mappedBy = "ProductPicture", cascade = CascadeType.ALL)
    private Set<ProductVO> productPictures;

    public Integer getpNo() {
        return pNo;
    }

    public void setpNo(Integer pNo) {
        this.pNo = pNo;
    }

    public ProductCategoryVO getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategoryVO productCategory) {
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

    public Set<ProductVO> getProductOrderDetails() {
        return productOrderDetails;
    }

    public void setProductOrderDetails(Set<ProductVO> productOrderDetails) {
        this.productOrderDetails = productOrderDetails;
    }

    public Set<ProductVO> getProductMyFavorites() {
        return productMyFavorites;
    }

    public void setProductMyFavorites(Set<ProductVO> productMyFavorites) {
        this.productMyFavorites = productMyFavorites;
    }

    public Set<ProductVO> getCarts() {
        return carts;
    }

    public void setCarts(Set<ProductVO> carts) {
        this.carts = carts;
    }

    public Set<ProductVO> getProductPictures() {
        return productPictures;
    }

    public void setProductPictures(Set<ProductVO> productPictures) {
        this.productPictures = productPictures;
    }
}