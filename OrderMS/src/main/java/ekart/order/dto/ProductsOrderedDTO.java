package ekart.order.dto;

import java.sql.Date;

import javax.persistence.Column;

import ekart.order.entity.MyKey;
import ekart.order.entity.Order;
import ekart.order.entity.ProductsOrdered;

public class ProductsOrderedDTO {
	
	int ORDERID;

	int PRODID;

	int SELLERID;

	int QUANTITY;

	double price;

	String STATUS;
	
	public ProductsOrderedDTO() {
		super();
	}
	
	public ProductsOrderedDTO(int ORDERID,int PRODID,int SELLERID,int QUANTITY,double price,String STATUS) {
		this();
		this.ORDERID = ORDERID;
		this.PRODID = PRODID;
		this.price = price;
		this.SELLERID = SELLERID;
		this.QUANTITY=QUANTITY;
		this.STATUS=STATUS;
	}



	public int getORDERID() {
		return ORDERID;
	}

	public void setORDERID(int oRDERID) {
		ORDERID = oRDERID;
	}

	public int getPRODID() {
		return PRODID;
	}

	public void setPRODID(int pRODID) {
		PRODID = pRODID;
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
			productsOrderedDTO.setPRODID(productsOrdered.getPRODID());
			productsOrderedDTO.setORDERID(productsOrdered.getORDERID());
			productsOrderedDTO.setSELLERID(productsOrdered.getSELLERID());
			productsOrderedDTO.setQUANTITY(productsOrdered.getQUANTITY());
			productsOrderedDTO.setPrice(productsOrdered.getPrice());
			productsOrderedDTO.setSTATUS(productsOrdered.getSTATUS());
			return productsOrderedDTO;
		}

	@Override
	public String toString() {
		return "ProductsOrderedDTO [ORDERID=" + ORDERID + ", PRODID=" + PRODID + ", SELLERID=" + SELLERID
				+ ", QUANTITY=" + QUANTITY + ", price=" + price + ", STATUS=" + STATUS + "]";
	}
	
}
