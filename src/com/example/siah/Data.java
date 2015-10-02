package com.example.siah;

public class Data {
	@Override
	public String toString() {
		return "Data [product=" + product + ", productType=" + productType
				+ ", brandName=" + brandName + ", colour=" + colour
				+ ", price=" + price + ", distance=" + distance + ", x=" + x
				+ ", y=" + y + "]";
	}

	String product;
	String productType;
	String brandName;
	String colour;
	String price;
	int distance;
	double x;
	double y;

	public Data(String product, String productType, String brandName,
			String colour, String price, int distance, double x, double y) {
		this.product = product;
		this.productType = productType;
		this.brandName = brandName;
		this.colour = colour;
		this.price = price;
		this.distance = distance;
		this.x = x;
		this.y = y;
	}

	public String getProduct() {
		return product;
	}

	public String getProductType() {
		return productType;
	}

	public String getBrandName() {
		return brandName;
	}

	public String getColour() {
		return colour;
	}

	public String getPrice() {
		return price;
	}

	public int getDistance() {
		return distance;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

}
