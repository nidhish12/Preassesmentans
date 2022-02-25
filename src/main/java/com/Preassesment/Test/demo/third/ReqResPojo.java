package com.Preassesment.Test.demo.third;

public class ReqResPojo {

	private String productId;
	private int availability;

	public ReqResPojo() {
		super();
	}

	public ReqResPojo(String productId, int availability) {
		super();
		this.productId = productId;
		this.availability = availability;
	}

	public String getProductId() {
		return productId;
	}

	public int getAvailability() {
		return availability;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

}
