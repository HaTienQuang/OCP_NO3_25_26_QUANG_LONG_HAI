package com.sieuthi.model;
import jakarta.persistence.*;

@Entity
public class BillItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Bill bill;

    @ManyToOne
    private SanPham sanPham;

    private int soLuong;
    private double gia;

    public BillItem() {}
    public BillItem(SanPham sanPham, int soLuong, double gia){this.sanPham=sanPham;this.soLuong=soLuong;this.gia=gia;}
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Bill getBill(){return bill;}
    public void setBill(Bill bill){this.bill=bill;}
    public SanPham getSanPham(){return sanPham;}
    public void setSanPham(SanPham sanPham){this.sanPham=sanPham;}
    public int getSoLuong(){return soLuong;}
    public void setSoLuong(int soLuong){this.soLuong=soLuong;}
    public double getGia(){return gia;}
    public void setGia(double gia){this.gia=gia;}
}
