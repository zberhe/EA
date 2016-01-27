<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books currently in the store</title>
    </head>
    <body>
        <h1>Books currently in the store</h1>
        <table>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.title}</td>
                    <td>${book.ISBN}</td>
                    <td>${book.author}</td>
                    <td>${book.price}</td>
                    <td>
                        <sec:authorize access="hasRole('ROLE_ADMIN')"><a href="books/${book.id}">edit</a>
                        </sec:authorize>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <sec:authorize access="hasRole('ROLE_ADMIN')"> <a href="addBook.html"> Add a Book</a>
        </sec:authorize>


        <a href="<c:url value='/j_spring_security_logout'/>" >logout </a>
    </body>
</html>