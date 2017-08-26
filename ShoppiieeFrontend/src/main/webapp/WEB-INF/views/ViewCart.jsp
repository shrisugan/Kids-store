<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Page</title>
</head>
  
 <body>

<br/>
<div class="container">
<div class="row">
   
     
  <p></p>
   <h1>ViewCartDetails</h1>   
   <p> </p><p> </p>
   
       <div class="col-md-10 col-md-offset-1">

           <div class="panel panel-default panel-table">
             <div class="panel-heading">
               <div class="row">
                 <div class="col col-xs-6">
                  <!--  <h3 class="panel-title">ViewCartDetails</h3> -->
                 </div>
                 <div class="col col-xs-6 text-right">
                   
                 </div>
               </div>
             </div>
             <div class="panel-body">
               <table class="table table-striped table-bordered table-list">
                 <thead>
                   <tr>
                       
                       <th><em class="fa fa-cog"></em></th>
                       <th>Name</th>
                       <th>Price</th>
                       <th>Quantity</th>
                       <th>Total</th>
                                                                                                               
                   </tr> 
                 </thead>
                 <tbody>
                          <c:set var="tot" value="0"></c:set>
                         <c:forEach items="${cartlist}" var="p">
                         <c:set var="t" value="${p.prices*p.quantity}"></c:set>
                		<c:set var="tot" value="${tot+t }"/>
                         <tr>
                         <%-- <td>
                             <a class="btn btn-default" href="./product_edit?id=${p.productid}"><em class="fa fa-pencil"></em></a>--%>
                            <td> <a class="btn btn-danger" href="./cart_delete?id=${p.cartid}"><em class="fa fa-trash"></em></a></td>
                           
                           <%-- <td class="hidden-xs">${p.productid}</td> --%>
                           <td>
                             <a class="btn btn-danger" href="./cart_delete?id=${p.cartid}"><em class="fa fa-trash"></em></a>
                           </td>
                           <td>${p.productid.prodName}</td>
                          <td><i class="fa fa-inr" aria-hidden="true"></i>${p.prices}</td>     
                           <td>${p.quantity}</td>    
                         
                           <td><i class="fa fa-inr" aria-hidden="true"></i>${p.prices*p.quantity}</td>
                           <%-- <td><img src="./resources/product/${p.p_image}"  class="img-rounded" alt="" width="75px" height="50px"/></td>          --%>
                            
                           <tr>       
                         </c:forEach>
                       </tbody>
               </table>
           
             </div>
             <div class="panel-footer">
               <div class="row">
               <center>
                 <a href="./" >CONTINUE SHOPPING</a>
                 <a href="UserRegistration?tot=${tot}">CHECK OUT</a>
                 </center>
                  <h4 style="color:green;">Grand Total = <c:out value="${tot}"/></h4> 
                 </div>
                 <div class="col col-xs-8">
                   
                   
                 </div>
               </div>
             </div>
           </div>
    
</body>
</html>