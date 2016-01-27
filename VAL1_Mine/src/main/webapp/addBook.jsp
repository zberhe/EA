<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Car</title>
<link href = "style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <form:form  commandName="book" action="addBook.jsp" method="post">
        <form:errors path="*" element="div"/>
	<table>
		<tr>
			<td>Title:</td>
			<td><input type="text" name="title" /> </td>
		</tr>
		<tr>
			<td>ISBN:</td>
			<td><input type="text" name="ISBN" /> </td>
		</tr>
		<tr>
			<td>Author:</td>
			<td><input type="text" name="author" /> </td>
                        
		</tr>
		<tr>
			<td>Price:</td>
			<td><input type="text" name="price" /> </td>
                        <td>  <form:errors path="price" cssClass="error"element="div"/> </td>
	</table>
	<input type="submit"/>
	
	</form:form>
</body>
</html>