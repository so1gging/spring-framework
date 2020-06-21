<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <table border="1">
      <tr>
         <th>WRITER</th>
         <td>${dto.myname }</td>
      </tr>
      <tr>
         <th>TITLE</th>
         <td>${dto.mytitle }</td>
      </tr>
      <tr>
      	<th>DATE</th>
      	<td>${dto.mydate }</td>
      </tr>
      <tr>
         <th>CONTENT</th>
         <td><textarea rows="10" cols="50" readonly="readonly">${dto.mycontent }</textarea></td>
      </tr>
      <tr>
         <td colspan="2" align="right">
            <input type="button" value="list" onclick="location.href='list.do'">
            <input type="button" value="update" onclick="location.href='updateform.do?myno=${dto.myno}'">
            <input type="button" value="delete" onclick="location.href='delete.do?myno=${dto.myno }'">
         </td>
      </tr>
   </table>
</body>
</html>