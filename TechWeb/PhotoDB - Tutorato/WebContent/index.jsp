<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Photo</title>
</head>
<body>
<h3>Lecturers</h3>
1<img src="./getPicture?id=1" onerror="this.src='./imgs/nophoto.png'" style="width:100px">
2<img src="./getPicture?id=2" onerror="this.src='./imgs/nophoto.png'" style="width:100px">
3<img src="./getPicture?id=3" onerror="this.src='./imgs/nophoto.png'" style="width:100px">
<br>
<hr>
<form action="UploadPhoto" enctype="multipart/form-data" method="post">
	Id:
	<select name="id">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
	</select>
	<br>
	<input class="file" type="file" name="talkPhoto" value="" maxlength="255">	
	<br>		
	<input type="submit"><input type="reset">
</form>


</body>
</html>