package com.example.kt3_dothihongkhanh;

public class Model {
    int anh;
    String tenThi,moTa;

    public Model(int anh, String tenThi, String moTa) {
        this.anh = anh;
        this.tenThi = tenThi;
        this.moTa = moTa;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getTenThi() {
        return tenThi;
    }

    public void setTenThi(String tenThi) {
        this.tenThi = tenThi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
