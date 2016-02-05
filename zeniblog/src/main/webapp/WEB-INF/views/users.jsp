<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Users</h1>
				<p>All the available users in our store</p>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<c:forEach items="${users}" var="user">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${user.email}</h3>
							<p>${user.username}</p>
                                                        <p>${user.password}</p>
						
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>