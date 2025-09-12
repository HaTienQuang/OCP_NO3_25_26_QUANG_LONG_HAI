
package Controller;
import Model.BillDTO;
import Model.BillXML;
import java.io.File;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import qlst.utils.FileUtils;

/**
 *
 * @author Admin
 */

public class BillDAO {
   private static final String PRODUCT_FILE_NAME = "bill.xml";
    private List<BillDTO> BillXML;

    public BillDAO() {
        this.BillXML = readListBills();

        if (BillXML == null) {
            BillXML = new ArrayList<BillDTO>();
        }
    }

    /**
     * Lưu các đối tượng product vào file product.xml
     * 
     * @param products
     */
    public void writeBillXML(List<BillDTO> products) {
        BillXML productXML = new BillXML();
        productXML.setProduct(products);
        FileUtils.writeXMLtoFile(PRODUCT_FILE_NAME, productXML);
    }

    /**
     * Đọc các đối tượng product từ file product.xml
     * 
     * @return list product
     */
    public List<BillDTO> readListBills() {
        List<BillDTO> list = new ArrayList<BillDTO>();
        BillXML productXML = (BillXML) FileUtils.readXMLFile( PRODUCT_FILE_NAME, BillXML.class);
        if (productXML != null) {
            list = productXML.getProduct();
        }
        return list;
    }
    

    /**
     * thêm product vào BillXML và lưu BillXML vào file
     * 
     * @param product
     */
    public boolean isIdUnique(String newId) {
        for (BillDTO product : BillXML) {
            if (product.getID().equals(newId)) {
                return false; // ID đã tồn tại trong danh sách
            }
        }
        return true; // ID không trùng lặp
    }
    public void add(BillDTO product) {
        if(isIdUnique(product.getID())){
            BillXML.add(product);
            JOptionPane.showMessageDialog(null, "Đã thêm!");
        } else {
            JOptionPane.showMessageDialog(null, "Đã có mặt hàng này!");
        }
        writeBillXML(BillXML);
    }

    /**
     * cập nhật product vào BillXML và lưu BillXML vào file
     * 
     * @param product
     */
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


    /**
     * xóa product từ BillXML và lưu BillXML vào file
     * 
     * @param product
     */
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
    
    public void keepRoot() {
        for (int i = BillXML.size() - 1; i >= 0; i--) {
        BillDTO bill = BillXML.get(i);
        BillXML.remove(i);
        }
    }
    
    public void sortProductByName() {
        Collections.sort(BillXML, new Comparator<BillDTO>() {
            public int compare(BillDTO product1, BillDTO product2) {
                return product1.getTenHang().compareTo(product2.getTenHang());
            }
        });
    }
    
    public void sortProductById() {
        Collections.sort(BillXML, new Comparator<BillDTO>() {
            public int compare(BillDTO product1, BillDTO product2) {
                return product1.getID().compareTo(product2.getID()); // So sánh ngược lại để sắp xếp giảm dần
            }
        });
    }

 
    public void sortProductByQuantity() {
        Collections.sort(BillXML, new Comparator<BillDTO>() {
            public int compare(BillDTO product1, BillDTO product2) {
                if (product1.getSoLuong()> product2.getSoLuong()) {
                    return 1;
                }
                return -1;
            }
        });
    }
    
     public void sortProductByPrice() {
        Collections.sort(BillXML, new Comparator<BillDTO>() {
            public int compare(BillDTO product1, BillDTO product2) {
                if (product1.getGiaBan()> product2.getGiaBan()) {
                    return 1;
                }
                return -1;
            }
        });
    }
    
     /**
     * Đọc tổng số sản phẩm từ danh sách Bill
     * 
     * @return tổng số sản phẩm
     */
    public int getTotalNumberOfProducts() {
        return BillXML.size();
    }
    
    /**
     * Tính tổng số tiền của các sản phẩm trong danh sách Bill
     * 
     * @return tổng số tiền
     */
    public double getTotalAmount() {
        double totalAmount = 0.0;
        for (BillDTO product : BillXML) {
            totalAmount += product.getSoLuong() * product.getGiaBan();
        }
        return totalAmount;
    }
    
    public List<BillDTO> getBillXML() {
        return BillXML;
    }

    public void setBillXML(List<BillDTO> BillXML) {
        this.BillXML = BillXML;
    }
}
