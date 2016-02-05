<%-- 
    Document   : posts
    Created on : Feb 1, 2016, 10:58:26 PM
    Author     : nimaclara
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet"
              href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <style>
            .create-form {
                max-width: 900px;
                margin: 0 auto;
                height:auto;

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
        <title>posts</title>
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
                    <ul class="nav navbar-nav " >
                        <li class="active">
                            <a href="<c:url value="/home" />" > 
                                <span class="glyphicon glyphicon-home"></span> Home</a>

                    </ul>

                    <ul class="nav navbar-nav navbar-right" >
                        <li class="active">
                            <a href="<c:url value="j_spring_security_logout" />" > 
                                <span class="glyphicon glyphicon-log-out"></span> Logout</a>

                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>


        <section class="container">



            <div class="row">
                <div class="col-lg-2">
                    <a href="<c:url value="/posts" />" >your posts</a>

                </div>


                <div class="col-lg-6">
                    <c:forEach items="${allposts}" var="post">
                        <div>
                            <h3> ${post.title}</h3>
                            <hr/>
                            <div id="first">
                                <small>${post.postDate}</small><br/>
                            </div>
                            <div id="second" >
                                ${post.content}
                            </div>
                            <div id="first">
                                <small>${post.user.username}</small><br/>
                                
                            </div>
                            <span class="glyphicon glyphicon-comment"></span>
                            <a href=" <c:url value= "/comment/${post.id}" />">
                               Leave Comment
                        </a>
                    </c:forEach>
                </div>
            </div>


        </div>
    </section>
</body>
</html>

