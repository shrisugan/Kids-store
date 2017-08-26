<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import=" com.niit.model.Category" %>
<%@page import="com.niit.model.Supplier" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <!-- dialog -->
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
<link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css"
    rel="stylesheet" type="text/css" />
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.2.0/jquery-confirm.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.2.0/jquery-confirm.min.js"></script>
    
  <!-- dialog -->
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
   /*  .navbar {
      margin-bottom: 0;
      border-radius: 0;
    } */
    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
    
  .carousel-inner img {
      width: 100%; /* Set width to 100% */
      margin: auto;
      height:200px;
  }
  
 

  /* Hide the carousel text when the screen is less than 600 pixels wide */
  @media (max-width: 600px) {
    .carousel-caption {
      display: none; 
    }
  }
  
/*  form {
    border: 3px solid #f1f1f1;
} */

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline;
    border: 1px solid #ccc;
    
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

/* .imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
} */


.container {
    width:500px;
	height:350px;
    }

/* span.psw {
    float: right;
    padding-top: 16px;
} */

/* Change styles for span and cancel button on extra small screens */
/* @media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
} */

#addcat
{
 position: relative;
        left:500px;
        display:none;
width:500px;
height:700px;
/* display:none; */
}

#addsup
{

 position: relative;
        left:500px;
        display:none;
width:500px;
height:700px;
/* display:none; */
}
#addpro
{

 position: relative;
        left:500px;
        display:none;
width:500px;
height:700px;

/* display:none; */
}

#pan
{
position:absolute;
top:52px;
left:0px;
display:inline; 
width:300px;
heigth:400px;
padding: 200px 150px;
background:#A8A8A8;
}
#chead
{
color:black;
position:absolute;
top:20px;
left:0px;
text-decoration:underline;
}
#shead
{
color:black;
position:absolute;
top:130px;
left:0px;
text-decoration:underline;
}
#phead
{
color:black;
position:absolute;
top:220px;
left:0px;
text-decoration:underline;
}

#cbuttonadd
{
position:absolute;
top:80px;
left:0px;
}

#sbuttonadd
{
position:absolute;
top:185px;
left:0px;
}

#pbuttonadd
{
position:absolute;
top:280px;
left:0px;
}

#dialog
{

width:400px;
heigth:400px;
}

/* #cbuttonclose
{
position:absolute;
top:140px;
left:0px;
} */
</style>
<script type="text/javascript">
$(document).ready(function() {
   /*  $("#addcat").hide();
    $("#addsup").hide();
    $("#addpro").hide(); */

    $("#cbuttonadd").click(function() {
    	  $("#addcat").show();
    	    $("#addsup").hide();
    	    $("#addpro").hide();
    	    
    });
    
    $("#sbuttonadd").click(function() {
  	  $("#addcat").hide();
  	    $("#addsup").show();
  	    $("#addpro").hide();
  });
    
    $("#pbuttonadd").click(function() {
  	  $("#addcat").hide();
  	    $("#addsup").hide();
  	    $("#addpro").show();
  });
    

});

</script>

<!--script for alert  -->
<script>
$(function () {
    'use strict';

    function confirmDialog(title, message, success) {
        var confirmdialog = $('<div></div>').appendTo('body')
            .html('<div><h3>'+message+'</h3></div>')
            .dialog({
                modal: true,
                title: title,
                zIndex: 10000,
                autoOpen: false,
               
                width: '300px',
                resizable: true,
                buttons: {
                    Yes: function () {
                        success();
                        $(this).dialog("close");
                    },
                    No: function () {
                        $(this).dialog("close");
                    }
                },
                close: function() {
                    $(this).remove();
                }
            });

        return confirmdialog.dialog("open");
    }

    $('form').on('submit', function (e) {
        e.preventDefault();
        var form = this;

        confirmDialog('Confirm', 'Conform Saving ?', function () {
        	
        	
            form.submit();
        });
    });
});

</script>
 </head>
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
         <li><a href="productfilter?id=${p.categoryId}"> ${p.categoryName }</a></li>
         
          <br>
       </c:forEach>
        </ul>
      </li>
      
      <li><a href="<c:url value="admin/add"/>" role="button" aria-haspopup="true"
					aria-expanded="false">Add</a></li>
      
      <c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
                                <li><a href="<c:url value="/admin" />">Admin</a></li>
                 </c:if>
        
        <%-- <li><a href="<c:url value="CategoryList" />">CategoryList</a></li>
         <li><a href="<c:url value="SupplierList" />">SupplierList</a></li>
         <li><a href="<c:url value="ProductList" />">ProductList</a></li> --%>
         
         <li><a href="categoryList">CategoryList</a></li>
          <li><a href="supplierList">SupplierList</a></li>
           <li><a href="productlist">ProductList</a></li>
         
         
      </ul>
      <ul class="nav navbar-nav navbar-right">
         <ul class="nav navbar-nav navbar-right">
			  <c:if test="${pageContext.request.userPrincipal.name == null }">
					<li>
					<a href=' <c:url value="admin/login" />'><span class="glyphicon glyphicon-log-in"></span>Signin</a>
					</li>
				<li><a href="registration"><span class="glyphicon glyphicon-log-in"></span>SignUp</a></li>
				
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

 
<div id="dialog">
  <p>data stored.</p>
</div>

<div id="pan">
<h1 id="chead">Category</h1>
<button id="cbuttonadd"> Add</button>
<br>
<br>

<h1 id="shead">Supplier</h1>
<button id="sbuttonadd"> Add</button>

<br>
<br>

<h1 id="phead">Product</h1>
<button id="pbuttonadd"> Add</button>

</div>



<div id="addcat">
<form action="category">
<h2>Add Category</h2>
<div class="container">
    <label><b>Category Id</b></label>
    <input type="text" name="cId" id="catid"  style="width:350px;display:block;" required>
    <label><b>Category Name</b></label>
    <input type="text" name="cn" id="catname"  style="width:350px;display:block;" required>
 <!--  <input type="submit" value="Add" onclick="stay()"> -->
 <input type="submit" value="Add">
  </div>
</form>
</div>


<div id="addsup">
<h2>Add Supplier</h2>
<form action="supplier">
 

  <div class="container">
    <label><b>Supplier Id</b></label>
    <input type="text" name="sId" value=""  style="width:350px;display:block;" required>
    <label><b>Supplier Name</b></label>
    <input type="text" name="sn" value=""  style="width:350px;display:block;" required>
        
     <input type="submit" value="Add">
  <input type="submit" value="Cancel">
  </div>

 
</form>
</div>


<div id="addpro">
<h2>Add Product</h2>
<form  action="product" method="post" enctype="multipart/form-data">
			
 <div class="container">
    <label><b>Product Id</b></label>
    <input type="text" name="pid" value=""  style="width:350px;display:block;" required>
    <label><b>Product Name</b></label>
    <input type="text" name="pn" value=""  style="width:350px;display:block;" required>
    
    <label><b>Product Description</b></label>
    <input type="text" name="pd" value=""  style="width:350px;display:block;" required>
    
     <%-- <label><b>Product Category</b></label>  
     <select class="form-control form-control-lg" name="procategory">
								<option>Select Category</option>
								<c:forEach var="cList" items="${clist}">

									<option value="${cList.c_id}">${cList.c_name}</option>

								</c:forEach>
							</select>   --%>
							
							<!-- DropDown input-->

     
    <label><b>Product Category</b></label>  
  <select class="form-control form-control-lg" name="pc" id="selectedRecord" required>
             <option>Select Category</option>
             <%
             	List<Category> clist=(List<Category>) request.getAttribute("clist");
    			for(Category c : clist){
    				out.println("<option value='"+ c.getCategoryId() +"'>"+ c.getCategoryName() + "</option>");
    			}
    			
             %>
						</select>	
						
						
						<label><b>Supplier Category</b></label>  
  <select class="form-control form-control-lg" name="psc" id="selectedRecord" required>
             <option>Select Supplier</option>
             <%
             	List<Supplier> slist=(List<Supplier>) request.getAttribute("slist");
    			for(Supplier s : slist){
    				out.println("<option value='"+ s.getSupplierId() +"'>"+ s.getSupplierName() + "</option>");
    			}
    			
             %>
						</select>
							
							
							
	<%-- <label><b>Product Supplier</b></label> 		
	<select class="form-control form-control-lg"
								name="productsupplier">
								<option>Select Supplier</option>
								<c:forEach var="slist" items="${slist}">

									<option value="${slist.s_id}">${slist.s_name}</option>

								</c:forEach>
							</select>	 --%>
							
							
							
							
	<label><b>Product Price</b></label>
    <input type="text" name="pp" value=""  style="width:350px;display:block;" required>
    
     	
    	
    
    <label><b>Product image</b></label>
    <input type="file" id="img" name="file" style="width:350px;display:block;" required>
    	
							
  <input type="submit" value="Add">
  </div>			
</form>
</div>


<!-- <footer class="container-fluid text-center">
  <i class="fa fa-facebook" style="font-size:36px"></i>
  
  <i class="fa fa-twitter" style="font-size:36px"></i>
</footer> -->


</body>
</html>
