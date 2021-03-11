package ekart.order.dto;

import java.sql.Date;

import javax.persistence.Column;

import ekart.order.entity.MyKey;
import ekart.order.entity.Order;
import ekart.order.entity.ProductsOrdered;

public class ProductsOrderedDTO {
	
	MyKey myKey;

	int SELLERID;

	int QUANTITY;

	double price;

	String STATUS;
	
	public ProductsOrderedDTO() {
		super();
	}
	
	public ProductsOrderedDTO(MyKey myKey,int SELLERID,int QUANTITY,double price,String STATUS) {
		this();
		this.myKey=myKey;
		this.price = price;
		this.SELLERID = SELLERID;
		this.QUANTITY=QUANTITY;
		this.STATUS=STATUS;
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
	
	// Converts Entity into DTO
		public static ProductsOrderedDTO valueOf(ProductsOrdered productsOrdered) {
			ProductsOrderedDTO productsOrderedDTO = new ProductsOrderedDTO();
			productsOrderedDTO.setMyKey(productsOrdered.getMyKey());
			productsOrderedDTO.setSELLERID(productsOrdered.getSELLERID());
			productsOrderedDTO.setQUANTITY(productsOrdered.getQUANTITY());
			productsOrderedDTO.setPrice(productsOrdered.getPrice());
			productsOrderedDTO.setSTATUS(productsOrdered.getSTATUS());
			return productsOrderedDTO;
		}

	@Override
	public String toString() {
		return "ProductsOrderedDTO [myKey=" + myKey + ", SELLERID=" + SELLERID + ", QUANTITY=" + QUANTITY + ", price="
				+ price + ", STATUS=" + STATUS + "]";
	}
	
	

}
