package com.chihyunro.servicepicture.model;

public class ServicePicture implements java.io.Serializable{
    private Integer servicePicNo;
    private Integer recordNo;
    private byte[] servicePic;

    public Integer getServicePicNo() {
        return servicePicNo;
    }

    public void setServicePicNo(Integer servicePicNo) {
        this.servicePicNo = servicePicNo;
    }

    public Integer getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(Integer recordNo) {
        this.recordNo = recordNo;
    }

    public byte[] getServicePic() {
        return servicePic;
    }

    public void setServicePic(byte[] servicePic) {
        this.servicePic = servicePic;
    }
}
