package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public String findByProductList() {
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT NAME, WIDTH, LOT, INCASE, OUTRATE FROM PRODUCT";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			String productList = "<table border=\"1\"><tr><th>商品名</th><th>横幅(cm)</th><th>入数(ロット)</th><th>入荷ケース数(ケース)</th><th>予測出荷割合(%)</th><th></th></tr>";
			while(rs.next()) {
				productList += "<tr><td>" + rs.getString("NAME") + "</td><td>" + rs.getInt("WIDTH") + "</td><td>" + rs.getInt("LOT") + "</td><td>" + rs.getInt("INCASE") + "</td><td>" + rs.getInt("OUTRATE") + "</td><th><form action=\"MainServlet\" method=\"post\"><input type=\"hidden\" name=\"link\" value=\"deleteProduct\"><input type=\"hidden\" name=\"name\" value=\"" + rs.getString("NAME") + "\"><input type=\"submit\" value=\"この商品を削除\"></form></th></tr>";
			}
			productList += "</table><br>";
			if(productList.equals("<table border=\"1\"><tr><th>商品名</th><th>横幅(cm)</th><th>入数(ロット)</th><th>入荷ケース数(ケース)</th><th>予測出荷割合(%)</th><th></th></tr></table><br>")) {
				productList = "<h3>商品が登録されていません</h3>";
			}
			return productList;
		}
		catch(SQLException e) {
			e.printStackTrace();
			String msg = "<h3>データベースに接続されていません</h3>";
			return msg;
		}
	}
	
	public List<Product> findByProductList2() {
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT NAME, WIDTH, LOT, INCASE, OUTRATE FROM PRODUCT ORDER BY LOT * INCASE * OUTRATE DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			List<Product> productList = new ArrayList<>();
			while(rs.next()) {
				Product product = new Product();
				product.setName(rs.getString("NAME"));
				product.setWidth(rs.getInt("WIDTH"));
				product.setLot(rs.getInt("LOT"));
				product.setInCase(rs.getInt("INCASE"));
				product.setOutRate(rs.getInt("OUTRATE"));
				productList.add(product);
			}
			return productList;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean registerProduct(Product product) {
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO PRODUCT VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, product.getName());
			pStmt.setInt(2, product.getWidth());
			pStmt.setInt(3, product.getLot());
			pStmt.setInt(4, product.getInCase());
			pStmt.setInt(5, product.getOutRate());
			int result = pStmt.executeUpdate();
		      if (result != 1) {
		          return false;
		      }
		} catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		}
		return true;
	}
	
	public boolean deleteProduct(String productName) {
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "DELETE FROM PRODUCT WHERE NAME = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, productName);
			int result = pStmt.executeUpdate();
			if(result == 1) {
				return true;
			}else {
				return false;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}