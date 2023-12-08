package com.example.quanlychitieu.Model;

import java.io.Serializable;

public class KhoanThu implements Serializable {

    public KhoanThu() {
    }

    public String getTenkt() {
        return tenkt;
    }

    public void setTenkt(String tenkt) {
        this.tenkt = tenkt;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getSotien() {
        return sotien;
    }

    public void setSotien(String sotien) {
        this.sotien = sotien;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    private String tenkt,ngay,sotien, ghichu;

    public KhoanThu(String tenkt, String ngay, String sotien, String ghichu) {
        this.tenkt = tenkt;
        this.ngay = ngay;
        this.sotien = sotien;
        this.ghichu = ghichu;
    }
}

