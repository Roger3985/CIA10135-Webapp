package com.chihyun.servicepicture.entity;

import com.chihyun.servicerecord.entity.ServiceRecord;

import javax.persistence.*;

@Entity
@Table(name = "ServicePicture")
public class ServicePicture {
    @Id
    @Column(name = "servicePicNo")
    private Integer servicePicNo;
    @ManyToOne
    @JoinColumn(name = "recordNo", referencedColumnName = "recordNo")
    private ServiceRecord serviceRecord;
    @Column(name = "servicePic", columnDefinition = "longblob")
    private byte[] servicePic;

    public Integer getServicePicNo() {
        return servicePicNo;
    }

    public void setServicePicNo(Integer servicePicNo) {
        this.servicePicNo = servicePicNo;
    }

    public ServiceRecord getServiceRecord() {
        return serviceRecord;
    }

    public void setServiceRecord(ServiceRecord serviceRecord) {
        this.serviceRecord = serviceRecord;
    }

    public byte[] getServicePic() {
        return servicePic;
    }

    public void setServicePic(byte[] servicePic) {
        this.servicePic = servicePic;
    }
}
