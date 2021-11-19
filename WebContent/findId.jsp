<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="border: 1px solid black; margin: 20px; padding: 10px;">아이디찾기
	<form action="login.do">
	<input type="hidden" name="command" value="findId">
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" ></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email"></td>
		</tr> 
		<tr>
			<td><input type="submit" value="확인"></td>
		</tr>	
		
	</table>
	</form>
</div>

<div style="border: 1px solid black;  margin: 20px; padding: 10px;">비밀번호 찾기
	<form action="login.do">
		<input type="hidden" name="command" value="findPw">
		<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td><input type="submit" value="확인"></td>
		</tr>
		</table>
	</form>
</div>
</body>
</html>