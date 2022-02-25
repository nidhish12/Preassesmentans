package com.Preassesment.Test.demo.third;

public class Demand {
	String productId;
	Double quantity;

	public Demand() {
		super();
	}

	public Demand(String productId, Double quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}


}
