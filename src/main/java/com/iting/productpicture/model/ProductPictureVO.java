package com.iting.productpicture.model;

import javax.persistence.*;

@Entity
@Table(name = "ProductPicture")
public class ProductPictureVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pPicNo")
    private Integer pPicNo;
    @Column(name = "pNo")
    private Integer pNo;
    @Column(name = "pPic")
    private byte[] pPic;

    public Integer getpPicNo() {
        return pPicNo;
    }

    public void setpPicNo(Integer pPicNo) {
        this.pPicNo = pPicNo;
    }

    public Integer getpNo() {
        return pNo;
    }

    public void setpNo(Integer pNo) {
        this.pNo = pNo;
    }

    public byte[] getpPic() {
        return pPic;
    }

    public void setpPic(byte[] pPic) {
        this.pPic = pPic;
    }

}
