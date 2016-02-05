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
        <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"/>
        <style>
            body {
                background-color: #ECECEA;
            }


        </style>

    </head>

    <body style="padding-top:70px ">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                    <ul class="nav navbar-nav navbar-right">
                        <li >
                            <a href="<c:url value="/login" />" > 
                                <span class="glyphicon glyphicon-log-in"></span> login</a>

                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active">
                            <a href="<c:url value="/add" />" > 
                                register</a>

                    </ul>

                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

        <!-- Page Content -->

        <div class="container" >


            <!-- /.row -->
            <div class="container">
             <div class="row">

                       <div class="col-md-12" style="color:#1a75ff;margin-left: 25%;margin-top: 10%; font-size: 24px;">
                            Share your ideas with others

                    </div>
                    
                    <a href="<c:url value="/add" />" class="btn btn-primary btn-lg " role="button" 
                       style ="margin-top: 10%; margin-left: 30%" >Start a blog here</a>
                  
                </div>


            </div>



            <!-- /.container -->

        </div>


    </body>

</html>
