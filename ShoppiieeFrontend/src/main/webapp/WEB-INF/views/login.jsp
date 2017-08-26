<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="image" value="/resources/image" />
<spring:url var="image" value="/resources/product" />>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>

 /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
      bottom: 80px;
    }

</style>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="./"><img src='<c:url value="resources/images/logo1.png" />' style="width:75px;height:50px;position:relative;top:-15px;left:0px;"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="./">Home</a></li>
        
       
       
        
         <li class="active"><a  data-toggle="dropdown" href=" ">Categorys<span class="caret"></span></a>
        <ul class="dropdown-menu">
        <br>
         <c:forEach items="${clist}" var="p">
         <li><a href="productview?id=${p.categoryId}"> ${p.categoryName }</a></li>
         
          <br>
       </c:forEach>
        </ul>
      </li>
      
      <li><a href="<c:url value="admin/add"/>" role="button" aria-haspopup="true"
					aria-expanded="false">Add</a></li>
      
      <c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
                                <li><a href="<c:url value="/admin" />">Admin</a></li>
                 </c:if>
        
       <%--  <li><a href="<c:url value="admin/CategoryList" />">CategoryList</a></li>
         <li><a href="<c:url value="admin/SupplierList" />">SupplierList</a></li>
         <li><a href="<c:url value="admin/ProductList" />">ProductList</a></li> --%>
      </ul>
     
         <ul class="nav navbar-nav navbar-right">
			 <c:if test="${pageContext.request.userPrincipal.name == null }">
					<li>
					<a href=' <c:url value="/login" />'><span class="glyphicon glyphicon-log-in"></span>Signin</a>
					</li>
					
					<li>
					<a href=' <c:url value="/reg" />'><span class="glyphicon glyphicon-log-in"></span>Register</a>
					
					</li>
				
				
				</c:if>
				<c:if test="${pageContext.request.userPrincipal.name  != null}">
                               <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
	             				<li><a href='<c:url value="/logout" />'>Signout</a></li>
                 </c:if>
				
				</ul>
         
      </ul>
    </div>
  </div>
</nav>





<div class="panel panel-default">
        		<div class="panel-heading">
			   		<br><br><h3 class="panel-title">Login</h3>
						</div>
				<div class="l">
				<c:url var="loginUrl" value="/j_spring_security_check" />
				<form id="login-form" name="formLogin" action="${loginUrl}" method="post" class="text-left">
					<div class="login-form-main-message"></div>
					<div class="main-login-form">
						<div class="login-group">
							<div class="form-group">
								<label for="lg_username" class="sr-only">Username</label> 
								<input required	type="text" class="form-control" id="lg_username" name="j_username" placeholder="username">
							</div>
							<div class="form-group">
								<label for="lg_password" class="sr-only">Password</label> 
								<input required type="password" class="form-control" id="lg_password" name="j_password" placeholder="password">
							</div>
						</div>
						<input type="submit" class="btn btn-primary btn-md" name="submit" value="Login" />
						<input type="reset" class="btn btn-primary btn-md"/>
						<a href="#">New User</a>
					</div>
					<input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />
				</form>
			</div>
		</form>
		</div>
		
		<footer class="container-fluid text-center">
  <i class="fa fa-facebook" style="font-size:36px"></i>
  
  <i class="fa fa-twitter" style="font-size:36px"></i>
</footer>
</body>
</html>