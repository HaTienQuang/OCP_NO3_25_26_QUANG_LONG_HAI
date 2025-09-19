/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class BillDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String ID;
    private String tenHang;
    private int soLuong;
    private double giaBan;

    public BillDTO() {
    }

    public BillDTO(String ID, String tenHang, int soLuong, double giaBan) {
        this.ID = ID;
        this.tenHang = tenHang;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getID() {
        return ID;
    }
    public String getTenHang() {
        return tenHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    
}