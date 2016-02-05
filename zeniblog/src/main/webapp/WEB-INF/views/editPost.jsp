<%-- 
    Document   : posts
    Created on : Feb 1, 2016, 10:46:18 PM
    Author     : nimaclara
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>New Post</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <style>
             .create-form {
                max-width: 700px;
                margin: 0 auto;
                
            }
            body{
                padding-top:70px;
                background-color :#f0f5f5;

            }
              .msg {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #31708f;
                background-color: #d9edf7;
                border-color: #bce8f1;
            }
        </style>
    </head>
    <body>
       <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                     <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="<c:url value="/newPost" />" > 
                               Create New  Post</a>
                               
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active">
                            <a href="<c:url value="j_spring_security_logout" />" > 
                                <span class="glyphicon glyphicon-log-out"></span> Logout</a>

                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

        <div >

          
            <div class="create-form msg">
                <form:form modelAttribute="postToEdit" class="form-horizontal" method="post">

                    <div class="form-group">
                        <label for="title" class="control-label col-lg-2 col-lg-2">title:</label>

                        <form:input  id="title" path="title" type="text" class="form:input-large form-control"/>
                   
                    </div>
                    <div class="form-group ">
                        <%--<c:set var="now" value="<%=new java.util.Date()%>"  />--%>
                        <fmt:formatDate value="<%=new java.util.Date()%>" var="now" type="date" pattern="yyyy-MM-dd" /><br/>
<!--                        <label for="username">Post date:</label>-->
                        <form:input id="postDate" path="postDate"   type="text" value="${now}" readonly="true" class="form:input-large form-control" 
                                    style="display:none"/>

                    </div><br/>
                    <div class="form-group">

                    </div>
                    <div class="form-group">
                        <label for="comment">Comment:</label>
                        <form:textarea path="content" class="form-control" rows="5" id="comment"></form:textarea>
                                             </div>

                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-10">
                                <input  type="submit" id="btnAdd" class="btn btn-primary" 
                                        value ="Update"/>
                            </div>
                        </div>

                </form:form>



            </div>


        </div>

    </body>
</html>
