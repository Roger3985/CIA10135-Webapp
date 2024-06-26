package com.yu.rental.entity;


import com.howard.rentalorderdetails.entity.RentalOrderDetails;
import com.yu.rentalcategory.entity.RentalCategory;
import com.yu.rentalmyfavorite.entity.RentalMyFavorite;
import com.yu.rentalpic.entity.RentalPic;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


@Entity  //標示類別為"永續類別"
@Table(name = "Rental")  //此"永續類別"對應到的表格
public class Rental {

    @Id //標示為PK
    @Column(name="rNo")
    private Integer rNo;
    @ManyToOne
    @JoinColumn(name = "rCatNo", referencedColumnName = "rCatNo") //對應rental的rCatNo
    private RentalCategory rentalCategory;
    @Column(name="rName", length=40)
    private String rName;
    @Column(name="rPrice",columnDefinition="BigDecimal")
    private BigDecimal rPrice;
    @Column(name="rSize")
    private Integer rSize;
    @Column(name="rColor", length=10)
    private String rColor;
    @Column(name="rInfo", length=1000)
    private String rInfo;
    @Column(name="rStat",columnDefinition = "TINYINT")
    private Byte rStat;
    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private Set<RentalOrderDetails> rentalOrderDetails;
    @OneToMany(mappedBy = "rental",cascade = CascadeType.ALL)
    private Set<RentalMyFavorite> rentalMyFavorites;
    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private Set<RentalPic> rentalPics;

    public Integer getrNo() {
        return rNo;
    }

    public void setrNo(Integer rNo) {
        this.rNo = rNo;
    }

    public RentalCategory getRentalCategory() {
        return rentalCategory;
    }

    public void setRentalCategory(RentalCategory rentalCategory) {
        this.rentalCategory = rentalCategory;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public BigDecimal getrPrice() {
        return rPrice;
    }

    public void setrPrice(BigDecimal rPrice) {
        this.rPrice = rPrice;
    }

    public Integer getrSize() {
        return rSize;
    }

    public void setrSize(Integer rSize) {
        this.rSize = rSize;
    }

    public String getrColor() {
        return rColor;
    }

    public void setrColor(String rColor) {
        this.rColor = rColor;
    }

    public String getrInfo() {
        return rInfo;
    }

    public void setrInfo(String rInfo) {
        this.rInfo = rInfo;
    }

    public Byte getrStat() {
        return rStat;
    }

    public void setrStat(Byte rStat) {
        this.rStat = rStat;
    }

    public Set<RentalOrderDetails> getRentalOrderDetails() {
        return rentalOrderDetails;
    }

    public void setRentalOrderDetails(Set<RentalOrderDetails> rentalOrderDetails) {
        this.rentalOrderDetails = rentalOrderDetails;
    }

    public Set<RentalMyFavorite> getRentalMyFavorites() {
        return rentalMyFavorites;
    }

    public void setRentalMyFavorites(Set<RentalMyFavorite> rentalMyFavorites) {
        this.rentalMyFavorites = rentalMyFavorites;
    }

    public Set<RentalPic> getRentalPics() {
        return rentalPics;
    }

    public void setRentalPics(Set<RentalPic> rentalPics) {
        this.rentalPics = rentalPics;
    }
}