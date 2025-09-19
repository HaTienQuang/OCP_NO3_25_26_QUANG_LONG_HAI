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
![Sequence Diagram](UML%20Sequence%20Diagram.png)

## UML Class Diagram
![Class Diagram](UML%20Class%20Diagram.jpg)



## ✨ Chức năng chính
- **Quản lý sản phẩm**
  - Thêm, sửa, xóa, tìm kiếm, sắp xếp (theo ID, tên, số lượng, giá).
- **Quản lý bán hàng**
  - Tạo hóa đơn, thêm/xóa mặt hàng, tính tổng tiền, in hóa đơn.
- **Thống kê**
  - Tổng số sản phẩm nhập.
  - Tổng tiền nhập.
  - Tổng số lượng bán.
  - Tổng doanh thu và lợi nhuận.

---

## 🛠 Công nghệ sử dụng
- **Ngôn ngữ lập trình:** Java (OOP)
- **Giao diện:** Java Swing
- **Kiến trúc phần mềm:** MVC (Model - View - Controller)
- **Cơ sở dữ liệu:** XML (`product.xml`, `bill.xml`)

---

## ⚙️ Cài đặt và chạy chương trình
1. Cài đặt **JDK 8+** và **NetBeans / IntelliJ / Eclipse**.
2. Clone hoặc tải về mã nguồn dự án.
3. Import dự án vào IDE.
4. Chạy file `Main.java` để khởi động ứng dụng.

---
# Hệ thống Quản lý Bán hàng

## 2. Objects (Đối tượng)

### 2.1. UserDTO (Người dùng)
#### 2.1.1. Attributes (Thuộc tính)
- **String username** (tài khoản đăng nhập của nhân viên bán hàng)
- **String password** (mật khẩu để đăng nhập)
- **boolean isLogin** (trạng thái đăng nhập: true/false)

#### 2.1.2. Methods (Phương thức)
- **UserDTO()**: constructor khởi tạo
- **getUsername(), setUsername()**
- **getPassword(), setPassword()**
- **getIsLogin(), setIsLogin()**

---

### 2.2. UserDAO (Xử lý người dùng)
#### 2.2.1. Methods
- **checkLogin(String username, String password) : boolean**  
  Kiểm tra thông tin đăng nhập từ UserDTO.

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
