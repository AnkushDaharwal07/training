package ekart.order.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "productsordered")
public class ProductsOrdered {
	
	@EmbeddedId
	MyKey myKey;
	
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


	public MyKey getMyKey() {
		return myKey;
	}


	public void setMyKey(MyKey myKey) {
		this.myKey = myKey;
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
