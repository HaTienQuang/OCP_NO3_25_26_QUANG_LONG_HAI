package Controller;
import Model.SanPhamDTO;
import Model.SanPhamXML;
import qlst.utils.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class SanPhamDAO {
    private static final String PRODUCT_FILE_NAME = "product.xml";
    private List<SanPhamDTO> listProducts;

    public SanPhamDAO() {
        this.listProducts = readListProducts();

        if (listProducts == null) {
            listProducts = new ArrayList<SanPhamDTO>();
        }
    }

    /**
     * Lưu các đối tượng product vào file product.xml
     * 
     * @param products
     */
    public void writeListProducts(List<SanPhamDTO> products) {
        SanPhamXML productXML = new SanPhamXML();
        productXML.setProduct(products);
        FileUtils.writeXMLtoFile(PRODUCT_FILE_NAME, productXML);
    }

    /**
     * Đọc các đối tượng product từ file product.xml
     * 
     * @return list product
     */
    public List<SanPhamDTO> readListProducts() {
        List<SanPhamDTO> list = new ArrayList<SanPhamDTO>();
        SanPhamXML productXML = (SanPhamXML) FileUtils.readXMLFile(
                PRODUCT_FILE_NAME, SanPhamXML.class);
        if (productXML != null) {
            list = productXML.getProduct();
        }
        return list;
    }
    

    /**
     * thêm product vào listProducts và lưu listProducts vào file
     * 
     * @param product
     */
    public boolean isIdUnique(String newId) {
        for (SanPhamDTO product : listProducts) {
            if (product.getID().equals(newId)) {
                return false; // ID đã tồn tại trong danh sách
            }
        }
        return true; // ID không trùng lặp
    }
    public void add(SanPhamDTO product) {
        if(isIdUnique(product.getID())){
            listProducts.add(product);
            JOptionPane.showMessageDialog(null, "Đã thêm!");
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng kiểm tra lại ID!");
        }
        writeListProducts(listProducts);
    }

    /**
     * cập nhật product vào listProducts và lưu listProducts vào file
     * 
     * @param product
     */
    public void edit(SanPhamDTO product) {
        int size = listProducts.size();
        for (int i = 0; i < size; i++) {
            if (listProducts.get(i).getID().equals(product.getID())) {
                listProducts.get(i).setTenSP(product.getTenSP());
                listProducts.get(i).setNgayNhap(product.getNgayNhap());
                listProducts.get(i).setSoLuong(product.getSoLuong());
                listProducts.get(i).setPhanLoai(product.getPhanLoai());
                listProducts.get(i).setGiaNhap(product.getGiaNhap());
                listProducts.get(i).setGiaDeXuat(product.getGiaDeXuat());

                writeListProducts(listProducts);
                break;
            }
        }
    }


    /**
     * xóa product từ listProducts và lưu listProducts vào file
     * 
     * @param product
     */
    public boolean delete(SanPhamDTO product) {
    int size = listProducts.size();
        for (int i = 0; i < size; i++) {
            if (listProducts.get(i).getID().equals(product.getID())) {
                listProducts.remove(i);
                writeListProducts(listProducts);
                return true;
            }
        }
        return false;
    }


    public void sortProductByName() {
        Collections.sort(listProducts, new Comparator<SanPhamDTO>() {
            public int compare(SanPhamDTO product1, SanPhamDTO product2) {
                return product1.getTenSP().compareTo(product2.getTenSP());
            }
        });
    }
    
    public void sortProductById() {
        Collections.sort(listProducts, new Comparator<SanPhamDTO>() {
            public int compare(SanPhamDTO product1, SanPhamDTO product2) {
                return product1.getID().compareTo(product2.getID()); // So sánh ngược lại để sắp xếp giảm dần
            }
        });
    }

 
    public void sortProductByQuantity() {
        Collections.sort(listProducts, new Comparator<SanPhamDTO>() {
            public int compare(SanPhamDTO product1, SanPhamDTO product2) {
                if (product1.getSoLuong()> product2.getSoLuong()) {
                    return 1;
                }
                return -1;
            }
        });
    }
    
     public void sortProductByPrice() {
        Collections.sort(listProducts, new Comparator<SanPhamDTO>() {
            public int compare(SanPhamDTO product1, SanPhamDTO product2) {
                if (product1.getGiaNhap()> product2.getGiaNhap()) {
                    return 1;
                }
                return -1;
            }
        });
    }
     /**
     * Tính tổng số sản phẩm trong danh sách sản phẩm
     * 
     * @return tổng số sản phẩm
     */
     
    public int getTotalNumberOfProducts() {
        return listProducts.size();
    }

    /**
     * Tính tổng số tiền của tất cả sản phẩm trong danh sách sản phẩm
     * 
     * @return tổng số tiền
     */
    public double getTotalAmount() {
        double totalAmount = 0.0;
        for (SanPhamDTO product : listProducts) {
            totalAmount += product.getSoLuong() * product.getGiaNhap();
        }
        return totalAmount;
    }
    
    public double getLai(){
        double lai = 0.0;
        for (SanPhamDTO product : listProducts) {
            lai += product.getSoLuong() * (product.getGiaDeXuat() - product.getGiaNhap());
        }
        return lai;
    }
    
    public List<SanPhamDTO> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<SanPhamDTO> listProducts) {
        this.listProducts = listProducts;
    }
}