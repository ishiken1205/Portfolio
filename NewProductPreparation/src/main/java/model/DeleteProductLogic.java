package model;

import dao.ProductDAO;

public class DeleteProductLogic {
	public String execute(String productName) {
		ProductDAO dao = new ProductDAO();
		boolean result = dao.deleteProduct(productName);
		String msg;
		if(result) {
			msg = "<h3>商品『" + productName + "』を削除しました</h3>";
		}else {
			msg = "<h3>商品を削除できませんでした</h3>";
		}
		return msg;
	}
}
