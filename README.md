# Quản Lý Bán Hàng Siêu Thị

## 👨‍💻 Nhóm thực hiện
- **Chu Việt Long** - 22010107
- **Hà Tiến Quang** - 22010136
- **Đỗ Thanh Hải** - 21011122

---

## 📌 Giới thiệu
Đây là bài tập lớn môn **Lập trình Hướng Đối Tượng (OOP)** của nhóm sinh viên CNTT, Đại học Phenikaa.

Ứng dụng được xây dựng nhằm hỗ trợ siêu thị trong việc quản lý sản phẩm, bán hàng, tài khoản người dùng và thống kê doanh thu.

Hệ thống được phát triển bằng **Spring Boot** sử dụng kiến trúc phân lớp (MVC) với các công nghệ:
- **Backend:** Java, Spring Boot, Spring Security
- **Frontend:** Thymeleaf, HTML, CSS
- **Dữ liệu:** Spring Data JPA, Cloud MySQL (Aiven)

---
##  UML Sequence Diagram
<p align="center">
  <i>*Lưu ý: Các sơ đồ cần được vẽ lại để phản ánh kiến trúc Spring Boot (Controller, Service, Repository).*</i>
  <br>
  <i>(Vui lòng thay thế tệp ảnh `UML Sequence Diagram.png` bằng sơ đồ mới)</i>
  <br>
  <img src="UML%20Sequence%20Diagram.png" alt="Sequence Diagram" width="600">
</p>

## UML Class Diagram
<p align="center">
  <i>*Lưu ý: Sơ đồ lớp cần được vẽ lại để bao gồm các Entity, Repository, Service, và Controller.*</i>
  <br>
  <i>(Vui lòng thay thế tệp ảnh `UML Class Diagram.jpg` bằng sơ đồ mới)</i>
  <br>
  <img src="UML%20Class%20Diagram.jpg" alt="Class Diagram" width="600">
</p>

---

## ✨ Chức năng chính
- **Bảo mật & Phân quyền (Spring Security)**
  - Đăng nhập (trang tùy chỉnh) và Đăng xuất.
  - Phân quyền dựa trên vai trò (`ROLE_ADMIN`, `ROLE_USER`).
  - Giao diện (Menu, Nút) tự động ẩn/hiện theo quyền.
  - Mã hóa mật khẩu người dùng (BCrypt).

- **Chức năng Quản trị (Admin)**
  - **Quản lý Sản phẩm (CRUD):** Thêm, Sửa, Xóa sản phẩm (với validation).
  - **Quản lý Người dùng (CRUD):** Thêm, Sửa, Xóa tài khoản (ngăn tự xóa).
  - **Quản lý Hóa đơn:** Sửa (tên khách hàng) và Xóa (có trả lại tồn kho).
  - **Thống kê:** Xem trang thống kê tổng hợp (doanh thu, tồn kho, số lượng...).
  - **Lịch sử:** Xem nhật ký toàn bộ hành động (Audit Log) của hệ thống.

- **Chức năng Nghiệp vụ (User & Admin)**
  - **Bán hàng:** Giao diện 2 cột (Sản phẩm & Giỏ hàng).
  - **Giỏ hàng (Session):** Thêm, Sửa số lượng, Xóa khỏi giỏ.
  - **Quản lý Tồn kho:** Tự động trừ tồn kho khi thêm vào giỏ, trả lại tồn kho khi xóa khỏi giỏ/sửa giảm.
  - **Lưu Hóa đơn:** Chuyển giỏ hàng (Session) thành hóa đơn chính thức (lưu vào CSDL).
  - **Xem Hóa đơn:** Xem danh sách và chi tiết các hóa đơn đã lưu.

---

## 🏛️ Cấu trúc Dự án (Spring Boot)
Dự án được xây dựng theo kiến trúc phân lớp `Controller` - `Service` - `Repository`.

### 1. Model (Gói `Model`)
Định nghĩa các đối tượng Entity (ánh xạ CSDL) và POJO (đối tượng dữ liệu tạm).
- **`User.java`**: (Entity) Lưu thông tin tài khoản (username, password, role).
- **`SanPham.java`**: (Entity) Lưu thông tin sản phẩm (tên, giá nhập, giá bán, tồn kho...).
- **`HoaDon.java`**: (Entity) Thông tin chính của hóa đơn (tên khách, ngày tạo, tổng tiền).
- **`HoaDonChiTiet.java`**: (Entity) Các mặt hàng chi tiết trong một hóa đơn (liên kết Many-to-One với `HoaDon`).
- **`AuditLog.java`**: (Entity) Lưu nhật ký hành động (ai, làm gì, khi nào, chi tiết).
- **`CartItem.java`**: (POJO) Đối tượng biểu diễn một mặt hàng trong giỏ hàng (Session), không lưu vào CSDL.

### 2. Repository (Gói `Repository`)
Các `interface` kế thừa `JpaRepository` để Spring Data JPA tự động xử lý các thao tác CSDL.
- **`UserRepository`**: CRUD cho `User`, có hàm `findByUsername`.
- **`SanPhamRepository`**: CRUD cho `SanPham`, có hàm `findByTenSP`.
- **`HoaDonRepository`**: CRUD cho `HoaDon`.
- **`HoaDonChiTietRepository`**: CRUD cho `HoaDonChiTiet`.
- **`AuditLogRepository`**: CRUD cho `AuditLog`.

### 3. Service (Gói `Service`)
Nơi xử lý logic nghiệp vụ (business logic) phức tạp.
- **`UserService`**: Xử lý logic Thêm/Sửa/Xóa user, kiểm tra trùng lặp, mã hóa mật khẩu, ngăn tự xóa.
- **`CartService`**: (`@SessionScope`) Quản lý giỏ hàng ảo, xử lý logic Thêm/Xóa/Sửa giỏ hàng và cập nhật tồn kho (liên kết với `SanPhamRepository`).
- **`AuditLogService`**: Cung cấp hàm `logAction` để ghi nhật ký và `getAllLogs` để lấy lịch sử.
- **`ThongKeService`**: Tính toán các số liệu thống kê cho trang Admin.
- **`UserDetailsServiceImpl`**: Lớp dịch vụ để Spring Security tìm và xác thực người dùng từ `UserRepository`.

### 4. Controller (Gói `Controller`)
Tiếp nhận yêu cầu HTTP từ trình duyệt, gọi Service/Repository, và trả về View (HTML) cho người dùng.
- **`SanPhamController`**: Xử lý CRUD cho sản phẩm (`/sanpham`).
- **`UserController`**: Xử lý CRUD cho người dùng (`/users`).
- **`BillController`**: Xử lý trang bán hàng, giỏ hàng (`/banhang`) và lưu hóa đơn.
- **`HoaDonController`**: Xử lý xem danh sách (`/hoadon`), chi tiết, sửa, xóa hóa đơn.
- **`ThongKeController`**: Hiển thị trang thống kê (`/thongke`).
- **`AuditLogController`**: Hiển thị trang lịch sử (`/auditlog`).
- **`AuthController`**: Hiển thị trang đăng nhập tùy chỉnh (`/login`).

### 5. Config (Gói `Config`)
Cấu hình hệ thống.
- **`SecurityConfig.java`**: Cấu hình Spring Security (mã hóa, phân quyền URL, trang đăng nhập/logout).

### 6. View (Thư mục `src/main/resources/templates`)
Các tệp HTML sử dụng **Thymeleaf** để hiển thị giao diện.
- **`login.html`**: Trang đăng nhập tùy chỉnh.
- **`_header.html`**: (Fragment) Thanh điều hướng chung, hiển thị menu theo quyền.
- **`banhang.html`**: Trang bán hàng chính (danh sách SP và giỏ hàng).
- **`sanpham-list.html`**, **`sanpham-form.html`**: Trang CRUD sản phẩm.
- **`user-list.html`**, **`user-form.html`**: Trang CRUD người dùng.
- **`hoadon-list.html`**, **`hoadon-detail.html`**, **`hoadon-form.html`**: Trang CRUD hóa đơn.
- **`thongke.html`**: Trang hiển thị thống kê.
- **`audit-log.html`**: Trang hiển thị lịch sử.

---

## 🛠️ Mã nguồn CRUD (Controller & Service)
Logic CRUD trong Spring Boot chủ yếu được xử lý bởi `JpaRepository`. Controller và Service gọi các hàm này và thêm logic nghiệp vụ (validation, ghi log).

### 4.1. SanPhamController (Create/Update)
Sử dụng `@Valid` để kiểm tra validation từ Entity `SanPham`.

```java
// CREATE & UPDATE
@PostMapping("/sanpham/luu")
public String luuSanPham(@Valid @ModelAttribute("sanPhamMoi") SanPham sanPham,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         Model model) {
    if (bindingResult.hasErrors()) {
        model.addAttribute("pageTitle", (sanPham.getId() == null) ? "Thêm Sản phẩm Mới (Lỗi)" : "Sửa Sản phẩm (Lỗi)");
        return "sanpham-form"; // Quay lại form nếu có lỗi
    }
    try {
        boolean isNew = (sanPham.getId() == null || sanPham.getId() == 0);
        SanPham savedSanPham = sanPhamRepo.save(sanPham); // JPA xử lý save
        
        // Ghi log
        String action = isNew ? "CREATE_PRODUCT" : "UPDATE_PRODUCT";
        String details = String.format("ID: %d, Tên: %s, SL: %d",
                                       savedSanPham.getId(), savedSanPham.getTenSP(), savedSanPham.getSoLuong());
        auditLogService.logAction(action, details);
        
        redirectAttributes.addFlashAttribute("successMessage", isNew ? "Đã thêm!" : "Đã cập nhật!");
    } catch (Exception e) {
        auditLogService.logAction("SAVE_PRODUCT_ERROR", e.getMessage());
        redirectAttributes.addFlashAttribute("errorMessage", "Lỗi khi lưu sản phẩm.");
    }
    return "redirect:/sanpham";
}
