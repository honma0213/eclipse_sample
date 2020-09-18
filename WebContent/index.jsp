<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ファイルアップロード</title>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="/Bulletin_Board/upload">
<input type="text" name="id">
<input type="file" name="file"/><br />
<input type="submit" value="アップロード" />
</form>
</body>
</html>