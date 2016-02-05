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
                max-width: 700px;
                margin: 0 auto;


            }
            body{
                padding-top:70px;
                background-color :#f0f5f5;

            }
            .error {
                color: red;
                font-weight: bold;

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
            #commentArea {
                margin:0px 0px;
                padding:5px;
                height:16px;
                line-height:16px;
                width:96%;
                display:block;
                margin:0px auto;    
            }
        </style>

        <title>Zeni blog</title>
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
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active">
                            <a href="<c:url value="j_spring_security_logout" />" > 
                                <span class="glyphicon glyphicon-log-out"></span> Logout</a>

                    </ul>
                </div>
            </div>

        </nav>

        <section class="container">



            <div class="row">
                <div class="col-lg-2">

                </div>


                <div class="col-lg-6">

                    <div>
                        <h3> ${post.title}</h3>
                        <hr/>
                        <div id="first">
                            <small>${post.postDate}</small><br/>
                        </div>
                        <div id="second" >
                            ${post.content}
                        </div>
                        <hr/>
                        <c:forEach items="${comments}" var="comment">
                            <div>

                                <hr/>
                                <div>
                                    <c:choose>
                                        <c:when test="${comment.commenter eq username}">
                                            <span class="glyphicon glyphicon-user">
                                                <sub class="text-primary" style="font-size:20px">${comment.commenter}</sub>
                                            </span> &nbsp;&nbsp;  <strong> <small>${comment.content}</small><br/></strong> 

                                            <form:form modelAttribute="comment"  action="" class="form-horizontal">
                                                <a href=" <c:url value= "/deleteComment?id=${comment.id}&postId=${post.id}" />">
                                                    Delete
                                                </a>
                                            </form:form>


                                        </c:when>
                                        <c:otherwise>

                                            <span class="glyphicon glyphicon-user">
                                                <sub class="text-primary" style="font-size:20px">${comment.commenter}</sub></span> 
                                            &nbsp;&nbsp;  <strong> <small>${comment.content}</small><br/></strong>

                                        </c:otherwise>
                                    </c:choose>


                                </div>

                            </c:forEach>
                            <hr/>
                            <form:form modelAttribute="comment"  action="" class="form-horizontal">
                                <div class="form-group ">
                                    <form:textarea id = "txtarea" cols="10" rows="5" path="content" class="form:input-large form-control commentArea"/>
                                    <span class="error">
                                        <form:errors path="content" >Content cannot be empty</form:errors>
                                        </span> 
                                    </div>
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <input  type="submit" id="btnAdd" class="btn btn-primary" 
                                                value ="Post Comment"/>
                                    </div>


                            </form:form>


                        </div>
                    </div>


                </div>
        </section>
    </body>
</html>







