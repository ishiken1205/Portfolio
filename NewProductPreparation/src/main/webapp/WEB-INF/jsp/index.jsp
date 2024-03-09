
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規商品準備アプリケーション</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
<h1>新規商品準備アプリケーション</h1>
<hr>
<h2>商品の登録</h2>
${msgOnRegister}
<form action="MainServlet" method="post">
<input type="hidden" name="link" value="registerProduct">
<label>商品名</label><input type="text" name="name"><br>
<label>横幅(cm)</label><input type="number" name="width"><br>
<label>入数(ロット)</label><input type="number" name="lot"><br>
<label>入荷ケース数(ケース)</label><input type="number" name="inCase"><br>
<label>予測出荷割合(%)</label><input type="number" name="outRate">
<input type="submit" value="登録">
</form>
<br>
<hr>
<h2>新規商品リスト</h2>
${msgOnList}
${productList}
<hr>
<br>
<form action="MainServlet" method="post">
<input type="hidden" name="link" value="output">
<input type="submit" value="出荷表・棚配置表を出力">
</form>
</body>
</html>