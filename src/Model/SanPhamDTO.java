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
public class SanPhamDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String ID;
    private String tenSP;
    private String ngayNhap;
    private int soLuong;
    private String phanLoai;
    private double giaNhap;
    private double giaDeXuat;

    public SanPhamDTO() {
    }

    public SanPhamDTO(String ID, String tenSP, String ngayNhap, int soLuong, String phanLoai, double giaNhap, double giaDeXuat) {
        this.ID = ID;
        this.tenSP = tenSP;
        this.ngayNhap = ngayNhap;
        this.soLuong = soLuong;
        this.phanLoai = phanLoai;
        this.giaNhap = giaNhap;
        this.giaDeXuat = giaDeXuat;
    }

    public String getID() {
        return ID;
    }

    public String getTenSP() {
        return tenSP;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public double getGiaDeXuat() {
        return giaDeXuat;
    }

    public String getPhanLoai() {
        return phanLoai;
    }
    
    public void setID(String ID) {
        this.ID = ID;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public void setGiaDeXuat(double giaDeXuat) {
        this.giaDeXuat = giaDeXuat;
    }

    public void setPhanLoai(String phanLoai) {
        this.phanLoai = phanLoai;
    }
    
    public double getLaiSuat(){
        return this.giaDeXuat - this.giaNhap;
    }
    
}
