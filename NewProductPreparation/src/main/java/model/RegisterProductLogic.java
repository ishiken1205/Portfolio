package model;

import dao.ProductDAO;

public class RegisterProductLogic {
	public String execute(String name, String width, String lot, String inCase, String outRate) {
		ProductDAO dao = new ProductDAO();
		if(name.strip().length() == 0 || width.length() == 0 || lot.length() == 0 || inCase.length() == 0 || outRate.length() == 0) {
			String msg = "<h3>商品の登録に失敗しました</h3>";
			return msg;
		}else {
			Product product = new Product();
			product.setName(name);
			product.setWidth(Integer.parseInt(width));
			product.setLot(Integer.parseInt(lot));
			product.setInCase(Integer.parseInt(inCase));
			product.setOutRate(Integer.parseInt(outRate));
			boolean result = dao.registerProduct(product);
			String msg;
			if(result) {
				msg = "<h3>商品『" + name + "』を登録しました</h3>";
			}else {
				msg = "<h3>商品の登録に失敗しました</h3>";
			}
			return msg;
		}
	}
}
