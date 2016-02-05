<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
    <head>
        <title>Zeni blog</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
        <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"/>
        <style>
            .login-form {
                max-width: 300px;
                margin: 0 auto;
            }
            body{
                padding-top:70px;        
                

            }


            .error {
                padding: 15px;
                margin-bottom: 20px;
                border: 1px solid transparent;
                border-radius: 4px;
                color: #a94442;
                background-color: #f2dede;
                border-color: #ebccd1;
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
   <body background="<c:url value='/resources/image/mumlogo.jpg' />">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                </div>

            </div>
        </nav>
        <div id="mainWrapper">


            <div id="login-box">



                <c:if test="${not empty error}">
                    <div class="error">${error}</div>
                </c:if>
                <c:if test="${not empty msg}">
                    <div class="msg">${msg}</div>
                </c:if>
                <c:if test="${not empty loginError}">
                    <div class="msg">${msg}</div>
                </c:if>
                    <div class="login-container">
                <form  name='loginForm'  class="login-form" action="<c:url value='j_spring_security_check' />" method='POST'>

                    <h2>Please Sign in</h2>

                    <div class="input-group input-sm">
                        <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                        <input type="text" name="username"  id="username" class="form-control" placeholder="username" required autofocus>
                    </div>

                    <div class="input-group input-sm">
                        <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
                        <input type="password" name ="password" id="password" class="form-control" placeholder="password" required>
                    </div>


                    <input type="checkbox" > Keep me logged In
                    <button type="submit"  class="btn  btn-block btn-primary btn-default"> Sign in</button>
                    <br/>
                    <a href="<c:url value="/add" />" > Register here?</a>
                </form>
                    </div>
            </div>
        </div>
    </body>
</html>
