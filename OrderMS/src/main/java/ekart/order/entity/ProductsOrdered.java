package ekart.order.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "productsordered")
@IdClass(MyKey.class)
public class ProductsOrdered {
	
	@Id
	int oRDERID;
	@Id
	int PRODID;
	
	@Column(nullable = false)
	int SELLERID;
	@Column(nullable = false)
	int QUANTITY;
	@Column(nullable = false)
	double price;
	@Column(nullable = false, length = 60)
	String STATUS;
	
	public ProductsOrdered() {
		super();
	}




	public int getORDERID() {
		return oRDERID;
	}




	public void setORDERID(int oRDERID) {
		oRDERID = oRDERID;
	}




	public int getPRODID() {
		return PRODID;
	}




	public void setPRODID(int pRODID) {
		this.PRODID = pRODID;
	}




	public int getSELLERID() {
		return SELLERID;
	}

	public void setSELLERID(int sELLERID) {
		SELLERID = sELLERID;
	}

	public int getQUANTITY() {
		return QUANTITY;
	}

	public void setQUANTITY(int qUANTITY) {
		QUANTITY = qUANTITY;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	
	

}
