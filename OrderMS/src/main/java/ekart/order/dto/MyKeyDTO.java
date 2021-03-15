package ekart.order.dto;

import ekart.order.entity.MyKey;


public class MyKeyDTO {

	int ORDERID;

	int PRODID;



	public MyKeyDTO() {
		super();
	}

	public MyKeyDTO(int ORDERID,int PRODID) {
		this();
		this.ORDERID = ORDERID;
		this.PRODID = PRODID;
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

	// Converts Entity into DTO
	public static MyKeyDTO valueOf(MyKey myKey) {
		MyKeyDTO myKeyDTO = new MyKeyDTO();
		myKeyDTO.setORDERID(myKey.getORDERID());
		myKeyDTO.setPRODID(myKey.getPRODID());
		return myKeyDTO;
	}
	
	public MyKey createMyKey() {
		MyKey myKey = new MyKey();
		myKey.setORDERID(this.getORDERID());
		myKey.setPRODID(this.getPRODID());
		return myKey;
	}

	@Override
	public String toString() {
		return "MyKeyDTO [ORDERID=" + ORDERID + ", PRODID=" + PRODID + "]";
	}

}
