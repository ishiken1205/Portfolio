package model;

import java.io.Serializable;

public class Product implements Serializable {
	private String name, shelfNumber;
	private int width, lot, inCase, outRate;
	public Product() {}
	public String getShelfNumber() {return this.shelfNumber;}
	public String getName() {return this.name;}
	public int getWidth() {return this.width;}
	public int getLot() {return this.lot;}
	public int getInCase() {return this.inCase;}
	public int getOutRate() {return this.outRate;}
	public void setShelfNumber(String shelfNumber) {this.shelfNumber = shelfNumber;}
	public void setName(String name) {this.name = name;}
	public void setWidth(int width) {this.width = width;}
	public void setLot(int lot) {this.lot = lot;}
	public void setInCase(int inCase) {this.inCase = inCase;}
	public void setOutRate(int outRate) {this.outRate = outRate;}
}