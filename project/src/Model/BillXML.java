/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bills")
@XmlAccessorType(XmlAccessType.FIELD)
public class BillXML {
    private List<BillDTO> bill;

    public List<BillDTO> getProduct() {
        return bill;
    }

    public void setProduct(List<BillDTO> bill) {
        this.bill = bill;
    }
}
