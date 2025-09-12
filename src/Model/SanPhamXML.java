
package Model;

/**
 *
 * @author Admin
 */
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class SanPhamXML {
    
    private List<SanPhamDTO> product;

    public List<SanPhamDTO> getProduct() {
        return product;
    }

    public void setProduct(List<SanPhamDTO> product) {
        this.product = product;
    }
}
