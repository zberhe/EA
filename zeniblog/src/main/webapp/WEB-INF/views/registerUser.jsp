<%-- 
    Document   : addUser
    Created on : Jan 31, 2016, 3:09:41 AM
    Author     : Zehafta M
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"
           %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Zeni blog</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <style>
            body{
                padding-top:80px;
                background-color :#f0f5f5;

            }
            .error {
                color: red;
                font-weight: bold;
               
            }
            .register-container {
                margin-top: 100px;
                background-color: floralwhite;
                width: 100%;
                left: 10%;
               
            }

        </style>

    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="<c:url value="/" />" > 
                            <span class="glyphicon glyphicon-arrow-left"></span> Back</a>

                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="active">
                        <a href="<c:url value="/login" />" > 
                            <span class="glyphicon glyphicon-log-in"></span>  Login</a>

                </ul> 

            </div>
        </nav>
        <div  class=" col-md-4 col-md-offset-4 col-sm-8 col-sm-offset-2">


            <div class="panel panel-default register-container">
                <div class="panel-heading">Register</div>
                <div class="panel-body ">
                    <form:form modelAttribute="newUser" class="form-horizontal">

                        <div class="form-group">
                            <label for="email" class="control-label col-lg-2 col-lg-2">Email:</label>

                            <form:input id="email" path="email" type="text" class="form:input-large form-control"/>
                            <span class="error">
                                <form:errors path="email" >Email must be valid</form:errors>
                                </span>
                            </div>
                            <div class="form-group ">
                                <label for="username">username:</label>
                            <form:input id="username" path="username" type="text" class="form:input-large form-control"/>
                            <span class="error">
                                <form:errors path="username" >username must have at least 4 characters</form:errors>
                                </span>
                            </div>
                            <div class="form-group">
                                <label for="password" class="control-label col-lg-2 col-lg-2">Password:</label>

                            <form:input id="password" path="password" type="password" class="form:input-large form-control"/>
                            <span class="error">
                                <form:errors path="password" > Password length should be at least 4 characters</form:errors>
                                </span>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-offset-2 col-lg-10">
                                    <input  type="submit" id="btnAdd" class="btn btn-primary" 
                                            value ="Register"/>
                                </div>
                            </div>

                    </form:form>



                </div>
            </div>    

        </div>
    </body>
</html>
