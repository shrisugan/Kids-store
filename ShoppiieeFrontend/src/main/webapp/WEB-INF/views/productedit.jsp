<%@page import="com.niit.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@page isELIgnored="false"  %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List" %>
<%@page import="com.niit.model.Category" %>
<%@page import="com.niit.model.Supplier" %>
  

<title>Insert title here</title>
</head>
<body>
<div class="container">
<div class="row">
<h2>Edit Product Details</h2>
<hr/>
  <h2>Add Product</h2>
  <%
             	Product p=(Product)request.getAttribute("product");
             	%>
<form  action="product_update" method="post">
			
 <div class="container">
    <label><b>Product Id</b></label>
    <input type="text" name="pId" value="<%=p.getProdId() %>"  style="width:350px;display:block;">
    <label><b>Product Name</b></label>
    <input type="text" name="pn" value="<%=p.getProdName() %>"  style="width:350px;display:block;">
    
    <!-- DropDown input-->

     
     
     
     
    <label><b>Product Category</b></label>   
  <select class="form-control form-control-lg" id="selectedRecord" name="pc">
             <option>Select Category</option>
             <%
             	List<Category> clist=(List<Category>) request.getAttribute("clist");
    			for(Category c : clist){
    				out.println("<option value='"+ c.getCategoryId() +"'>"+ c.getCategoryName() + "</option>");
    			}
    			
             %>
             </select>
             
             
             
             
    
    
<%--      <label><b>Product Category</b></label>  
     <select class="form-control form-control-lg" name="procategory">
								<option>Select Category</option>
								<c:forEach var="cList" items="${clist}">

									<option value="${cList.c_id}">${cList.c_name}</option>

								</c:forEach>
							</select>  
							 --%><br>
							 
				 <label class="col-md-4 control-label" for="ln">Supplier Category</label>  
				 
				 
  <div class="col-md-4">
  <select class="form-control form-control-lg" id="selectedRecord" name="psc">
             <option>Select Supplier</option>
             <%
             	List<Supplier> slist=(List<Supplier>) request.getAttribute("slist");
    			for(Supplier s : slist){
    				out.println("<option value='"+s.getSupplierId() +"'>"+ s.getSupplierName() + "</option>");
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
							</select> --%> <br>	
	<label><b>Product Price</b></label>
    <input type="text" name="pp" value="<%=p.getProdPrice() %>"  style="width:350px;display:block;">
    
     File to upload:
    <label><b>Product Image</b></label>
    <input type="file" name="pimg" value="<%=p.getImage()%>" id="file" style="width:350px;display:block;">
   

    	
							
  <input type="submit" value="Add">
     
  <input type="submit" value="Cancel">
  </div>
					
</form>
          
           

</div></div>
	
</body>
</html>
</body>
</html>