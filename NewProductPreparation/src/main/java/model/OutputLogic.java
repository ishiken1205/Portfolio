package model;

import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;

public class OutputLogic {
	public String execute() {
		ProductDAO dao = new ProductDAO();
		List<Product> productList = dao.findByProductList2();	
		if(productList == null) {
			return "<h3>データベースに接続されていません</h3>";
		}
		Shelf frontRight = new Shelf();
		frontRight.setName("右1");
		Shelf frontLeft = new Shelf();
		frontLeft.setName("左1");
		Shelf backRight = new Shelf();
		backRight.setName("右2");
		Shelf backLeft = new Shelf();
		backLeft.setName("左2");
		for(Product product : productList) {
			boolean result1 = frontRight.setProduct(product);
			if(result1) {
			}else {
				boolean result2 = frontLeft.setProduct(product);
				if(result2) {
				}else {
					boolean result3 = backRight.setProduct(product);
					if(result3) {
					}else {
						backLeft.setProduct(product);
					}
				}
			}
		}

		String frontRightShelf = "<table border=\"1\"><tr><th>棚番号</th><th width=\"200\">商品名</th></tr><tr><td>右-1</td><td>" + (frontRight.getProduct1() != null ? frontRight.getProduct1().getName() : "　") + "</td></tr><tr><td>右-2</td><td>" + (frontRight.getProduct2() != null ? frontRight.getProduct2().getName() : "　") + "</td></tr><tr><td>右-3</td><td>" + (frontRight.getProduct3() != null ? frontRight.getProduct3().getName() : "　") + "</td></tr><tr><td>右-4</td><td>" + (frontRight.getProduct4() != null ? frontRight.getProduct4().getName() : "　") + "</td></tr><tr><td>右-5</td><td>" + (frontRight.getProduct5() != null ? frontRight.getProduct5().getName() : "　") + "</td></tr></table>";
		String frontLeftShelf = "<table border=\"1\"><tr><th>棚番号</th><th width=\"200\">商品名</th></tr><tr><td>左-1</td><td>" + (frontLeft.getProduct1() != null ? frontLeft.getProduct1().getName() : "　") + "</td></tr><tr><td>左-2</td><td>" + (frontLeft.getProduct2() != null ? frontLeft.getProduct2().getName() : "　") + "</td></tr><tr><td>左-3</td><td>" + (frontLeft.getProduct3() != null ? frontLeft.getProduct3().getName() : "　") + "</td></tr><tr><td>左-4</td><td>" + (frontLeft.getProduct4() != null ? frontLeft.getProduct4().getName() : "　") + "</td></tr><tr><td>左-5</td><td>" + (frontLeft.getProduct5() != null ? frontLeft.getProduct5().getName() : "　") + "</td></tr></table>";
		String backRightShelf = "<table border=\"1\"><tr><th>棚番号</th><th width=\"200\">商品名</th></tr><tr><td>右-6</td><td>" + (backRight.getProduct1() != null ? backRight.getProduct1().getName() : "　") + "</td></tr><tr><td>右-7</td><td>" + (backRight.getProduct2() != null ? backRight.getProduct2().getName() : "　") + "</td></tr><tr><td>右-8</td><td>" + (backRight.getProduct3() != null ? backRight.getProduct3().getName() : "　") + "</td></tr><tr><td>右-9</td><td>" + (backRight.getProduct4() != null ? backRight.getProduct4().getName() : "　") + "</td></tr><tr><td>右-10</td><td>" + (backRight.getProduct5() != null ? backRight.getProduct5().getName() : "　") + "</td></tr></table>";
		String backLeftShelf = "<table border=\"1\"><tr><th>棚番号</th><th width=\"200\">商品名</th></tr><tr><td>左-6</td><td>" + (backLeft.getProduct1() != null ? backLeft.getProduct1().getName() : "　") + "</td></tr><tr><td>左-7</td><td>" + (backLeft.getProduct2() != null ? backLeft.getProduct2().getName() : "　") + "</td></tr><tr><td>左-8</td><td>" + (backLeft.getProduct3() != null ? backLeft.getProduct3().getName() : "　") + "</td></tr><tr><td>左-9</td><td>" + (backLeft.getProduct4() != null ? backLeft.getProduct4().getName() : "　") + "</td></tr><tr><td>左-10</td><td>" + (backLeft.getProduct5() != null ? backLeft.getProduct5().getName() : "　") + "</td></tr></table>";

		
		String table = "<table border=\"1\"><tr><th>棚番号</th><th>商品名</th><th>出荷ロット数(ロット)</th><th>出荷ケース数(ケース)</th></tr>";
		
		List<Product> productList2 = new ArrayList<>();
		productList2.add(frontRight.getProduct1());
		productList2.add(frontRight.getProduct2());
		productList2.add(frontRight.getProduct3());
		productList2.add(frontRight.getProduct4());
		productList2.add(frontRight.getProduct5());
		productList2.add(frontLeft.getProduct1());
		productList2.add(frontLeft.getProduct2());
		productList2.add(frontLeft.getProduct3());
		productList2.add(frontLeft.getProduct4());
		productList2.add(frontLeft.getProduct5());
		productList2.add(backRight.getProduct1());
		productList2.add(backRight.getProduct2());
		productList2.add(backRight.getProduct3());
		productList2.add(backRight.getProduct4());
		productList2.add(backRight.getProduct5());
		productList2.add(backLeft.getProduct1());
		productList2.add(backLeft.getProduct2());
		productList2.add(backLeft.getProduct3());
		productList2.add(backLeft.getProduct4());
		productList2.add(backLeft.getProduct5());
		
		for(Product product : productList2) {
			if(product != null) {
				int outLot = (int)Math.ceil(((double)product.getLot() * product.getInCase() * product.getOutRate())/ 100);
				int outCase = (int)Math.ceil((double)outLot / product.getLot());
				table += "<tr><td>" + product.getShelfNumber() + "</td><td>" + product.getName() + "</td><td>" + outLot + "</td><td>" + outCase + "</td></tr>";
			}
		}
		
		table += "</table>";
		String output = "<h2>出荷表</h2>" + table + "<br><hr><h2>棚配置表</h2><div class=\"flex\"><div class=\"block\">" + frontRightShelf + "<br>" + backRightShelf + "</div>" + "<img src=\"images/arrow.png\" alt=\"下矢印\" width=\"100\" height=\"265\" vspace=\"45\">" + "<div class=\"block\">" + frontLeftShelf + "<br>" + backLeftShelf + "</div></div>";
		return output;
	}
}
