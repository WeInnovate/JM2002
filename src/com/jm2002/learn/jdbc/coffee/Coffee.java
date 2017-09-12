package com.jm2002.learn.jdbc.coffee;

public class Coffee {
	
	private String coffeeName;
	private double price;
	private int quantity;
	
	public String getCoffeeName() {
		return coffeeName;
	}
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Coffee [coffeeName=" + coffeeName + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	public Coffee(String coffeeName, double price, int quantity) {
		super();
		this.coffeeName = coffeeName;
		this.price = price;
		this.quantity = quantity;
	}

}
