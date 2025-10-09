package com.sieuthi.model;
import jakarta.persistence.*;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenDangNhap;
    private String matKhau;
    private String vaiTro;

    public User() {}
    public User(String tenDangNhap, String matKhau, String vaiTro){this.tenDangNhap=tenDangNhap;this.matKhau=matKhau;this.vaiTro=vaiTro;}
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getTenDangNhap(){return tenDangNhap;}
    public void setTenDangNhap(String tenDangNhap){this.tenDangNhap=tenDangNhap;}
    public String getMatKhau(){return matKhau;}
    public void setMatKhau(String matKhau){this.matKhau=matKhau;}
    public String getVaiTro(){return vaiTro;}
    public void setVaiTro(String vaiTro){this.vaiTro=vaiTro;}
}
