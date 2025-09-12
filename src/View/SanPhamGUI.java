package View;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Model.SanPhamXML;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
import Controller.SanPhamDAO;
import Model.SanPhamDTO;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;


/**
 *
 * @author Admin
 */

public class SanPhamGUI extends javax.swing.JFrame {

    /**
     * Creates new form DanhMucView
     */
    protected SanPhamDAO spDAO;
    protected SanPhamXML spXML;
    private static final int SORT_BY_NAME = 0;
    private static final int SORT_BY_ID = 1;
    private static final int SORT_BY_QUANTITY = 2;
    private static final int SORT_BY_PRICE = 3;
    
    public SanPhamGUI() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        spDAO = new SanPhamDAO();
        spXML = new SanPhamXML();
        showListProducts(spDAO.readListProducts());
        DefaultTableModel spTable = (DefaultTableModel) tbl_danhSach.getModel();
        // Thêm sự kiện lắng nghe cho tbl_danhSach
        tbl_danhSach.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // Kiểm tra xem có đang chọn hàng không
                if (!event.getValueIsAdjusting()) {
                    // Lấy chỉ số của hàng được chọn
                    int selectedRow = tbl_danhSach.getSelectedRow();
                    if (selectedRow != -1) { // Đảm bảo rằng đã chọn một hàng
                        // Lấy dữ liệu từ bảng và fill vào các textfield
                        fillProductFromSelectedRow();
                    }
                }
            }
        });
        
        txt_search.addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            String searchText = txt_search.getText().trim();
            searchProduct(searchText);
        }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_giaNhap = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_soLuongNhap = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbbox_phanLoai = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_ngayNhap = new javax.swing.JTextField();
        txt_tenSanPham = new javax.swing.JTextField();
        txt_giaDeXuat = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_chinhSua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_sapXep = new javax.swing.JButton();
        btn_quayLai = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_danhSach = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý kho hàng");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));
        jPanel1.setForeground(new java.awt.Color(153, 255, 255));

        jLabel1.setText("ID : ");

        txt_ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_IDActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên Sản Phẩm :");

        jLabel3.setText("Giá Nhập :");

        jLabel4.setText("Số Lượng Nhập :");

        jLabel6.setText("Giá Đề Xuất :");

        jLabel7.setText("Phân Loại :");

        cbbox_phanLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thực phẩm", "Hoa quả", "Bánh kẹo", "Giày dép", "May mặc" }));
        cbbox_phanLoai.setToolTipText("");
        cbbox_phanLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbox_phanLoaiActionPerformed(evt);
            }
        });

        jLabel5.setText("Ngày Nhập :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_giaDeXuat)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbbox_phanLoai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_tenSanPham)
                        .addComponent(txt_ID)
                        .addComponent(txt_ngayNhap)
                        .addComponent(txt_soLuongNhap)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_tenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_ngayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_soLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbbox_phanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txt_giaDeXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btn_them.setBackground(new java.awt.Color(204, 255, 255));
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/add.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_chinhSua.setBackground(new java.awt.Color(204, 255, 255));
        btn_chinhSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/editing.png"))); // NOI18N
        btn_chinhSua.setText("Chỉnh sửa");
        btn_chinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chinhSuaActionPerformed(evt);
            }
        });

        btn_xoa.setBackground(new java.awt.Color(255, 204, 204));
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/delete.png"))); // NOI18N
        btn_xoa.setText("Xoá");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_sapXep.setBackground(new java.awt.Color(204, 255, 255));
        btn_sapXep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/sort.png"))); // NOI18N
        btn_sapXep.setText("Sắp xếp");
        btn_sapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sapXepActionPerformed(evt);
            }
        });

        btn_quayLai.setBackground(new java.awt.Color(204, 204, 255));
        btn_quayLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/return.png"))); // NOI18N
        btn_quayLai.setText("Quay lại");
        btn_quayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quayLaiActionPerformed(evt);
            }
        });

        btn_reset.setBackground(new java.awt.Color(204, 255, 255));
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/reset.png"))); // NOI18N
        btn_reset.setText("Làm mới");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        tbl_danhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên", "Ngày nhập", "Số lượng", "Phân loại", "Giá nhập", "Giá đề xuất", "Lãi suất"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_danhSach);
        if (tbl_danhSach.getColumnModel().getColumnCount() > 0) {
            tbl_danhSach.getColumnModel().getColumn(0).setResizable(false);
            tbl_danhSach.getColumnModel().getColumn(1).setResizable(false);
            tbl_danhSach.getColumnModel().getColumn(2).setResizable(false);
            tbl_danhSach.getColumnModel().getColumn(3).setResizable(false);
            tbl_danhSach.getColumnModel().getColumn(4).setResizable(false);
            tbl_danhSach.getColumnModel().getColumn(5).setResizable(false);
            tbl_danhSach.getColumnModel().getColumn(6).setResizable(false);
            tbl_danhSach.getColumnModel().getColumn(7).setResizable(false);
        }

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ico/search16.png"))); // NOI18N
        jLabel8.setText("Tìm kiếm:");

        txt_search.setBackground(new java.awt.Color(204, 255, 204));
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btn_reset)
                        .addGap(35, 35, 35)
                        .addComponent(btn_chinhSua)
                        .addGap(35, 35, 35)
                        .addComponent(btn_sapXep)
                        .addGap(35, 35, 35)
                        .addComponent(btn_xoa)
                        .addGap(35, 35, 35)
                        .addComponent(btn_quayLai)
                        .addGap(0, 85, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_quayLai)
                    .addComponent(btn_them)
                    .addComponent(btn_reset)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_chinhSua)
                        .addComponent(btn_sapXep)
                        .addComponent(btn_xoa)))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_IDActionPerformed

    private void cbbox_phanLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbox_phanLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbox_phanLoaiActionPerformed
    
    //Hàm in các thông tin lên bảng
    public void showListProducts(List<SanPhamDTO> list) {
        DefaultTableModel spTable = (DefaultTableModel) tbl_danhSach.getModel();
        
        spTable.setRowCount(0);

        for (SanPhamDTO sp : list) {
            Object[] rowSP = new Object[8];
            rowSP[0] = sp.getID();
            rowSP[1] = sp.getTenSP();
            rowSP[2] = sp.getNgayNhap();
            rowSP[3] = sp.getSoLuong();
            rowSP[4] = sp.getPhanLoai();
            rowSP[5] = sp.getGiaNhap();
            rowSP[6] = sp.getGiaDeXuat();
            rowSP[7] = sp.getLaiSuat();
            spTable.addRow(rowSP);
        }
    }
    
    //Hàm lấy string từ JComboBox, với các số tương ứng như bên dưới
    private String getComboBox(int i){
        if(i == 1){
            return "thuc_pham";
        } else if (i == 2){
            return "hoa_qua";
        } else if(i == 3){
            return "banh_keo";
        } else if(i == 4){
            return "giay_dep";
        } else {
            return "may_mac";
        }
    }
    
    public SanPhamDTO getProductInfo() {
        // validate product
        if (!checkTenSP() || !checkGia() || !checkNgayNhap() || !checkSoLuong()) {
            return null;
        }
        try {
            SanPhamDTO product = new SanPhamDTO();
            if (txt_tenSanPham.getText() != null && !"".equals(txt_ID.getText())) {
                product.setID(txt_ID.getText());
            }
            product.setTenSP(txt_tenSanPham.getText().trim());
            product.setGiaNhap(Integer.parseInt(txt_giaNhap.getText().trim()));
            product.setNgayNhap(txt_ngayNhap.getText().trim());
            product.setSoLuong(Integer.parseInt(txt_soLuongNhap.getText().trim()));
            return product;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại thông tin nhập!");
        }
        return null;
    }
    //check form ten san pham
    private boolean checkTenSP(){
        String name = txt_tenSanPham.getText();
        if(name == null || "".equals(name.trim())){
            txt_tenSanPham.requestFocus();
            return false;
        }
        return true;
    }
    
    //check form ngay nhap ( theo dinh danh dd/mm/yy)
    public static boolean checkDateFormat(String date) {
        // Sử dụng biểu thức chính quy để kiểm tra định dạng ngày
        String regex = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        
        return matcher.matches();
    }
    
    //check form ngay nhap
    private boolean checkNgayNhap() {
        String importDay = txt_ngayNhap.getText();
        if (importDay == null || "".equals(importDay.trim()) || !checkDateFormat(importDay)) {
            txt_ngayNhap.requestFocus();
            return false;
        }
        return true;
    }
    
    //check form gia nhap vao
    private boolean checkGia() {
        try {
            double price =  Double.parseDouble(txt_giaNhap.getText().trim());
            if (price < 0) {
                txt_giaNhap.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Giá nhập phải là một số dương!");
            txt_giaNhap.requestFocus();
            return false;
        }
        return true;
    }
    
    //check form so luong nhap vao
    private boolean checkSoLuong() {
        try {
            int quantity = Integer.parseInt(txt_soLuongNhap.getText().trim());
            if (quantity < 0 || quantity > 1000) {
                txt_soLuongNhap.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Số lượng nhập phải là một số nguyên dương!");
            txt_soLuongNhap.requestFocus();
            return false;
        }
        return true;
    }
    
    //Xử lý cho nút Thêm
    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        if (checkTenSP() && checkGia() && checkNgayNhap() && checkSoLuong()) {
            SanPhamDTO sp = new SanPhamDTO();
            sp.setID(txt_ID.getText());
            sp.setTenSP(txt_tenSanPham.getText());
            sp.setNgayNhap(txt_ngayNhap.getText());
            sp.setSoLuong(Integer.parseInt(txt_soLuongNhap.getText()));
            sp.setPhanLoai(getComboBox(cbbox_phanLoai.getSelectedIndex() + 1));
            sp.setGiaNhap(Double.parseDouble(txt_giaNhap.getText()));
            sp.setGiaDeXuat(Double.parseDouble(txt_giaDeXuat.getText()));
            this.spDAO.add(sp);
            showListProducts(spDAO.readListProducts());
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại thông tin nhập!");
        }
    }//GEN-LAST:event_btn_themActionPerformed
    
    //khi bấm vào một phần tử trong table thì sẽ tự động fill toàn bộ dữ liệu của nó vào textfield
    public void fillProductFromSelectedRow() {
        int selectedRow = tbl_danhSach.getSelectedRow();
        if (selectedRow != -1) { // Đảm bảo rằng đã chọn một hàng
            txt_ID.setText(tbl_danhSach.getValueAt(selectedRow, 0).toString());
            txt_tenSanPham.setText(tbl_danhSach.getValueAt(selectedRow, 1).toString());
            txt_ngayNhap.setText(tbl_danhSach.getValueAt(selectedRow, 2).toString());
            txt_giaNhap.setText(tbl_danhSach.getModel().getValueAt(selectedRow, 5).toString());
            txt_soLuongNhap.setText(tbl_danhSach.getValueAt(selectedRow, 3).toString());
            txt_giaDeXuat.setText(tbl_danhSach.getModel().getValueAt(selectedRow, 6).toString());
            String phanLoai = tbl_danhSach.getValueAt(selectedRow, 4).toString();
            switch (phanLoai) {
                case "thuc_pham":
                    cbbox_phanLoai.setSelectedIndex(0);
                    break;
                case "hoa_qua":
                    cbbox_phanLoai.setSelectedIndex(1);
                    break;
                case "banh_keo":
                    cbbox_phanLoai.setSelectedIndex(2);
                    break;
                case "giay_dep":
                    cbbox_phanLoai.setSelectedIndex(3);
                    break;
                case "may_mac":
                    cbbox_phanLoai.setSelectedIndex(4);
                    break;
                default:
                    // Xử lý trường hợp không tìm thấy
                    break;
            }
        }
    }

    private void showSortOptionDialog() {
        String[] options = {"Tên", "ID", "Số lượng", "Giá"};
        int choice = JOptionPane.showOptionDialog(null, "Chọn cách sắp xếp:", "Sắp xếp",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        switch (choice) {
            case SORT_BY_NAME:
                spDAO.sortProductByName();
                showListProducts(spDAO.getListProducts());
                break;
            case SORT_BY_ID:
                spDAO.sortProductById();
                showListProducts(spDAO.getListProducts());
                break;
            case SORT_BY_QUANTITY:
                spDAO.sortProductByQuantity();
                showListProducts(spDAO.getListProducts());
                break;
            case SORT_BY_PRICE:
                spDAO.sortProductByPrice();
                showListProducts(spDAO.getListProducts());
                break;
            default:
                // Do nothing
                break;
        }
    }
    
   //Xử lý cho nút Quay lại
    private void btn_quayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quayLaiActionPerformed
        // TODO add your handling code here:
        MenuGUI menu = new MenuGUI();
        menu.show();
        dispose();
    }//GEN-LAST:event_btn_quayLaiActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        String idToDelete = txt_ID.getText().trim();

        // Tạo một sản phẩm với ID để tìm kiếm trong danh sách
        SanPhamDTO productToDelete = new SanPhamDTO();
        productToDelete.setID(idToDelete);

        // Xác nhận xóa
        int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa sản phẩm này?", "Xác nhận Xoá", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            boolean isDeleted = spDAO.delete(productToDelete);
            if (isDeleted) {
                JOptionPane.showMessageDialog(null, "Xoá sản phẩm thành công!");
                showListProducts(spDAO.readListProducts());
                clearFormFields();
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm cần xoá hoặc có lỗi xảy ra!");
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed
    private void clearFormFields() {
        txt_ID.setText("");
        txt_tenSanPham.setText("");
        txt_ngayNhap.setText("");
        txt_soLuongNhap.setText("");
        txt_giaNhap.setText("");
        txt_giaDeXuat.setText("");
    }
    
    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        // TODO add your handling code here:
        txt_ID.setText("");
        txt_tenSanPham.setText("");
        txt_ngayNhap.setText("");
        txt_soLuongNhap.setText("");
        txt_giaNhap.setText("");
        txt_giaDeXuat.setText("");
    }//GEN-LAST:event_btn_resetActionPerformed
    
    private void btn_chinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chinhSuaActionPerformed
        // TODO add your handling code here:
        if (checkTenSP() && checkGia() && checkNgayNhap() && checkSoLuong()) {
            SanPhamDTO sp = new SanPhamDTO();
            sp.setID(txt_ID.getText());
            sp.setTenSP(txt_tenSanPham.getText());
            sp.setNgayNhap(txt_ngayNhap.getText());
            sp.setSoLuong(Integer.parseInt(txt_soLuongNhap.getText()));
            sp.setPhanLoai(getComboBox(cbbox_phanLoai.getSelectedIndex() + 1));
            sp.setGiaNhap(Double.parseDouble(txt_giaNhap.getText()));
            sp.setGiaDeXuat(Double.parseDouble(txt_giaDeXuat.getText()));
            spDAO.edit(sp);
            showListProducts(spDAO.readListProducts());
            JOptionPane.showMessageDialog(null, "Đã chỉnh sửa!");
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại thông tin nhập!");
        }
    }//GEN-LAST:event_btn_chinhSuaActionPerformed

    private void btn_sapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sapXepActionPerformed
        // TODO add your handling code here:
        showSortOptionDialog();
    }//GEN-LAST:event_btn_sapXepActionPerformed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed
    
    //ham tim kiem cho txt_search
    private void searchProduct(String searchText) {
        DefaultTableModel model = (DefaultTableModel) tbl_danhSach.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tbl_danhSach.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(searchText)));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SanPhamGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_chinhSua;
    private javax.swing.JButton btn_quayLai;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_sapXep;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbbox_phanLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_danhSach;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_giaDeXuat;
    private javax.swing.JTextField txt_giaNhap;
    private javax.swing.JTextField txt_ngayNhap;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_soLuongNhap;
    private javax.swing.JTextField txt_tenSanPham;
    // End of variables declaration//GEN-END:variables
}
