package nhom07.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name ="Images")
@Table(name ="Images")
public class Image implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int imageID;
	
	@Column(name = "src")
	@NotNull(message = "* Đường dẫn không được để trống")
	private String src;
	
	@ManyToOne
	@JoinColumn(name="productID")
	private Product product;
	
	public Image(String src, Product product) {
		super();
		this.src = src;
		this.product = product;
	}
	public Image(int imageID, String src, Product product) {
		super();
		this.imageID = imageID;
		this.src = src;
		this.product = product;
	}
	public int getImageId() {
		return imageID;
	}
	public void setImageId(int imageID) {
		this.imageID = imageID;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Image() {
		super();
	}
	@Override
	public String toString() {
		return "Image [imageID=" + imageID + ", src=" + src + " ]";
	}
	
	
	
	
}
