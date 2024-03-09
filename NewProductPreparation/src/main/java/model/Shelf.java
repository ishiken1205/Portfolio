package model;

import java.io.Serializable;

public class Shelf implements Serializable {
	private String name;
	private int width;
	private Product product1, product2, product3, product4, product5;
	public Shelf() {
		width = 200;
	}
	public String getName() {return this.name;}
	public int getWidth() {return this.width;}
	public Product getProduct1() {return this.product1;}
	public Product getProduct2() {return this.product2;}
	public Product getProduct3() {return this.product3;}
	public Product getProduct4() {return this.product4;}
	public Product getProduct5() {return this.product5;}
	public void setName(String name) {this.name = name;}
	public void setWidth(int width) {this.width = width;}
	public int setProduct1(Product product) {
		this.product1 = product;
		product.setShelfNumber(this.name + "-1");
		this.width = this.width - product.getWidth();
		return this.width;
	}
	public int setProduct2(Product product) {
		this.product2 = product;
		product.setShelfNumber(this.name + "-2");
		this.width = this.width - product.getWidth();
		return this.width;
	}
	public int setProduct3(Product product) {
		this.product3 = product;
		product.setShelfNumber(this.name + "-3");
		this.width = this.width - product.getWidth();
		return this.width;
	}
	public int setProduct4(Product product) {
		this.product4 = product;
		product.setShelfNumber(this.name + "-4");
		this.width = this.width - product.getWidth();
		return this.width;
	}
	public int setProduct5(Product product) {
		this.product5 = product;
		product.setShelfNumber(this.name + "-5");
		this.width = this.width - product.getWidth();
		return this.width;
	}
	
	public boolean setProduct(Product product) {		
		if(this.width >= product.getWidth()) {
			if(this.product1 == null) {
				this.setProduct1(product);
				return true;
			}else {
				if(this.product2 == null) {
					this.setProduct2(product);
					return true;
				}else {
					if(this.product3 == null) {
						this.setProduct3(product);
						return true;
					}else {
						if(this.product4 == null) {
							this.setProduct4(product);
							return true;
						}else {
							if(this.product5 == null) {
								this.setProduct5(product);
								return true;
							}else {
								return false;
							}
						}
					}
				}
			}
		}else {
			return false;
		}
	}
}
