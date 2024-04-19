package com.yu.rentalpic.model;

public class RentalPic implements java.io.Serializable{
    private Integer rPicNo;
    private Integer rNo;
    private byte[] rPic;

    public Integer getrPicNo() {
        return rPicNo;
    }

    public void setrPicNo(Integer rPicNo) {
        this.rPicNo = rPicNo;
    }

    public Integer getrNo() {
        return rNo;
    }

    public void setrNo(Integer rNo) {
        this.rNo = rNo;
    }

    public byte[] getrPic() {
        return rPic;
    }

    public void setrPic(byte[] rPic) {
        this.rPic = rPic;
    }
}
