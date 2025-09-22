  # Quản Lý Bán Hàng Siêu Thị
## 👨‍💻 Nhóm thực hiện
- **Chu Việt Long** - 22010107  
- **Hà Tiến Quang** - 22010136  
- **Đỗ Thanh Hải** - 21011122  

---

## 📌 Giới thiệu
Đây là bài tập lớn môn **Lập trình Hướng Đối Tượng (OOP)** của nhóm sinh viên CNTT, Đại học Phenikaa.  
Ứng dụng được xây dựng nhằm hỗ trợ siêu thị trong việc quản lý sản phẩm, bán hàng và thống kê doanh thu.  
Hệ thống được phát triển bằng **Java (Swing, OOP, MVC)** và sử dụng **XML** để lưu trữ dữ liệu.

---
## UML Sequence Diagram
<p align="center">
  <img src="UML%20Sequence%20Diagram.png" alt="Sequence Diagram" width="600">
</p>

## UML Class Diagram
<p align="center">
  <img src="UML%20Class%20Diagram.jpg" alt="Class Diagram" width="600">
</p>




## ✨ Chức năng chính
- **Quản lý sản phẩm**
  - Thêm, sửa, xóa, tìm kiếm, sắp xếp (theo ID, tên, số lượng, giá).
- **Quản lý bán hàng**
  - Tạo hóa đơn, thêm/xóa mặt hàng, tính tổng tiền, in hóa đơn.
- **Thống kê**
  - Tổng số admin

---

### 2.3. LoginGUI (Giao diện đăng nhập)
#### 2.3.1. Methods
- **code()**: xử lý logic giao diện đăng nhập
- **design()**: hiển thị giao diện đăng nhập

---

### 2.4. SanPhamDTO (Thông tin sản phẩm)
#### 2.4.1. Attributes (Thuộc tính)
- **String id** (mã sản phẩm)
- **String name** (tên sản phẩm)
- **String donvitinh** (đơn vị tính, ví dụ: cái, hộp, chai)
- **double soluong** (số lượng sản phẩm trong kho)
- **double dongia** (đơn giá sản phẩm)
- **double giamgia** (giảm giá áp dụng, nếu có)

#### 2.4.2. Methods (Phương thức)
- **SanPhamDTO()**
- **get(), set() cho từng thuộc tính**

---

### 2.5. SanPhamXML (Quản lý XML sản phẩm)
#### 2.5.1. Attributes
- **product: SanPhamDTO** (lưu trữ thông tin sản phẩm)

#### 2.5.2. Methods
- **getProduct()**: lấy dữ liệu sản phẩm từ file XML
- **setProduct()**: ghi dữ liệu sản phẩm vào file XML

---

### 2.6. SanPhamDAO (Xử lý sản phẩm)
#### 2.6.1. Attributes
- **listProducts: SanPhamDTO[]** (danh sách sản phẩm)

#### 2.6.2. Methods
- **readProducts()**
- **addProduct()**
- **removeProduct()**
- **updateProduct()**
- **getListProducts()**
- **setListProducts()**

---

### 2.7. BanHangGUI (Giao diện bán hàng)
#### 2.7.1. Methods
- **code()**: xử lý logic giao diện bán hàng
- **design()**: thiết kế giao diện hiển thị sản phẩm, giỏ hàng, hóa đơn

---

### 2.8. BillDTO (Chi tiết hóa đơn)
#### 2.8.1. Attributes
- **String id** (mã hóa đơn)
- **String tensanpham** (tên sản phẩm trong hóa đơn)
- **int soluong** (số lượng sản phẩm)
- **double gia** (đơn giá sản phẩm)
- **double giamgia** (giảm giá áp dụng)

#### 2.8.2. Methods
- **BillDTO()**
- **get(), set() cho từng thuộc tính**

---

### 2.9. BillXML (Quản lý file hóa đơn XML)
#### 2.9.1. Attributes
- **bill: BillDTO** (chi tiết hóa đơn)

#### 2.9.2. Methods
- **getBill()**
- **setBill()**

---

### 2.10. BillDAO (Xử lý hóa đơn)
#### 2.10.1. Attributes
- **listBill: BillDTO[]** (danh sách hóa đơn)

#### 2.10.2. Methods
- **readBill()**
- **addBill()**
- **removeBill()**
- **updateBill()**
- **getListBill()**
- **setListBill()**

##  CRUD cho 3 đối tượng chính

### 4.1 SanPhamDAO.java
```java
//  CREATE
public void add(SanPhamDTO product) {
    // kiểm tra trùng ID
    if (isIdUnique(product.getID())) {
        listProducts.add(product);
        JOptionPane.showMessageDialog(null, "Đã thêm!");
    } else {
        JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại ID!");
    }
    writeListProducts(listProducts); // lưu lại file
}

//  READ
public List<SanPhamDTO> getListProducts() {
    return listProducts;
}

//  UPDATE
public void edit(SanPhamDTO product) {
    for (SanPhamDTO sp : listProducts) {
        if (sp.getID().equals(product.getID())) {
            sp.setTenSP(product.getTenSP());
            sp.setSoLuong(product.getSoLuong());
            sp.setGiaNhap(product.getGiaNhap());
            sp.setGiaDeXuat(product.getGiaDeXuat());
            sp.setPhanLoai(product.getPhanLoai());
            sp.setNgayNhap(product.getNgayNhap());
            break;
        }
    }
    writeListProducts(listProducts); // lưu lại file
}

//  DELETE
public void delete(SanPhamDTO product) {
    listProducts.removeIf(sp -> sp.getID().equals(product.getID()));
    writeListProducts(listProducts); // lưu lại file
}

```

### 4.2 BillDAO.java
```java
public void add(BillDTO product) {
    if(isIdUnique(product.getID())){
        BillXML.add(product);
        JOptionPane.showMessageDialog(null, "Đã thêm!");
    } else {
        JOptionPane.showMessageDialog(null, "Đã có mặt hàng này!");
    }
    writeBillXML(BillXML);
}
public List<BillDTO> readListBills() {
    List<BillDTO> list = new ArrayList<BillDTO>();
    BillXML productXML = (BillXML) FileUtils.readXMLFile(PRODUCT_FILE_NAME, BillXML.class);
    if (productXML != null) {
        list = productXML.getProduct();
    }
    return list;
}

public List<BillDTO> getBillXML() {
    return BillXML;
}
public void edit(BillDTO product) {
    int size = BillXML.size();
    for (int i = 0; i < size; i++) {
        if (BillXML.get(i).getID().equals(product.getID())) {
            BillXML.get(i).setTenHang(product.getTenHang());
            BillXML.get(i).setSoLuong(product.getSoLuong());
            BillXML.get(i).setGiaBan(product.getGiaBan());
            writeBillXML(BillXML);
            break;
        }
    }
}
public boolean delete(BillDTO product) {
    int size = BillXML.size();
    for (int i = 0; i < size; i++) {
        if (BillXML.get(i).getID().equals(product.getID())) {
            BillXML.remove(i);
            writeBillXML(BillXML);
            return true;
        }
    }
    return false;
}

```
4.3 UserDAO.java
```java
public class UserDAO {
    List <UserDTO> ls = new ArrayList<>();

    public UserDAO() {
        
        ls.add(new UserDTO("hatienquang", "123456", true));
        ls.add(new UserDTO("chuvietlong", "123456", true));
        ls.add(new UserDTO("dothanhhai", "123456", true));
        ls.add(new UserDTO("admin", "admin", true));
        ls.add(new UserDTO("username", "password", true));
        ls.add(new UserDTO("taikhoan", "matkhau", true));
          
    }
    public boolean checkLogIn(String username, String password){
        for(UserDTO u : ls){
            if(u.getUsername().equals(username)
                    &&u.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}

```



## 🚀 Hướng dẫn sử dụng
1. **Đăng nhập**  
   - Tài khoản mặc định:
     - `admin / admin`
2. **Menu chính** gồm:
   - Sản phẩm
   - Hóa đơn
   - Thống kê
   - Đăng xuất
3. **Thao tác quản lý**:
   - Thêm, sửa, xóa, tìm kiếm và sắp xếp sản phẩm.
   - Tạo hóa đơn bán hàng, tính tổng tiền và in hóa đơn.
   - Xem thống kê doanh thu, lợi nhuận.

---

## 📖 Tài liệu tham khảo
- [Chuyển đổi giữa CSDL quan hệ và XML – ĐHQG Hà Nội, PGS.TS. Đỗ Trung Tuấn (2011)]  
- [Tìm hiểu về XML](https://topdev.vn/blog/xml-la-gi/)  
- [Mô hình MVC là gì?](https://vietnix.vn/tim-hieu-mo-hinh-mvc-la-gi/)  
