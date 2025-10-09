package com.sieuthi.model;
import jakarta.persistence.*;
@Entity
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ten;
    private double gia;
    private int soLuong;

    public SanPham() {}
    public SanPham(String ten, double gia, int soLuong) { this.ten = ten; this.gia = gia; this.soLuong = soLuong; }
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getTen(){return ten;}
    public void setTen(String ten){this.ten=ten;}
    public double getGia(){return gia;}
    public void setGia(double gia){this.gia=gia;}
    public int getSoLuong(){return soLuong;}
    public void setSoLuong(int soLuong){this.soLuong=soLuong;}
}
