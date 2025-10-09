package com.sieuthi.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime ngayLap = LocalDateTime.now();
    @ManyToOne
    private User nhanVien;
    private double tongTien;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BillItem> items = new ArrayList<>();

    public Bill() {}
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public LocalDateTime getNgayLap(){return ngayLap;}
    public void setNgayLap(LocalDateTime ngayLap){this.ngayLap=ngayLap;}
    public User getNhanVien(){return nhanVien;}
    public void setNhanVien(User nhanVien){this.nhanVien=nhanVien;}
    public double getTongTien(){return tongTien;}
    public void setTongTien(double tongTien){this.tongTien=tongTien;}
    public List<BillItem> getItems(){return items;}
    public void setItems(List<BillItem> items){this.items=items;}
    public void calculateTotal(){
        this.tongTien = items.stream().mapToDouble(i->i.getGia()*i.getSoLuong()).sum();
    }
}
