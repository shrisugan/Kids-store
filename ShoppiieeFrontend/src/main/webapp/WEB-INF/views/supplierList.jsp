<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
	<%@page import="java.util.List"  %>
	<%@page import="com.niit.model.Supplier"  %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<head>
	<meta charset="utf-8" />
	<title>Supplier List</title>
	<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
	<script src="./resources/js/jquery.min.js"></script>
	<script src="./resources/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="./resources/css/jquery.dataTables.min.css">
	<link href="./resources/font-awesome.min.css" rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
     
</head>
<body>
<div class="container">
<div class="row">

   
   <p></p>
   <h1>SupplierList</h1>   
   <p> </p><p> </p>
   
       <div class="col-md-10 col-md-offset-1">

           <div class="panel panel-default panel-table">
             <div class="panel-heading">
               <div class="row">
                 <div class="col col-xs-6">
                   <h3 class="panel-title">Supplier Data Table</h3>
                 </div>
                 <div class="col col-xs-6 text-right">
                   <a href="add"><button type="button" class="btn btn-sm btn-primary btn-create">Create New</button></a>
                 </div>
               </div>
             </div>
             <div class="panel-body">
               <table class="table table-striped table-bordered table-list">
                 <thead>
                   <tr>
                       <th><em class="fa fa-cog"></em></th>
                       <th class="hidden-xs">ID</th>
                       <th>Name</th>
                       
                                                                                           
                   </tr> 
                 </thead>
                 <tbody>
                 <%
             	List<Supplier> clist=(List<Supplier>) request.getAttribute("list");
    			for(Supplier c : clist){
    			
    			out.println("<tr> <td><a class=\"btn btn-default\"><em class=\"fa fa-pencil\"></em></a><a class=\"btn btn-danger\"><em class=\"fa fa-trash\"></em></a></td><td>"+c.getSupplierId()+"</td><td>"+c.getSupplierName()+ "</td></tr>");
    			}
    			
             %>
             
                         
                      
                       <%--   <tr>
                         <td>
                             <a class="btn btn-default"><em class="fa fa-pencil"></em></a>
                             <a class="btn btn-danger"><em class="fa fa-trash"></em></a>
                           </td>
                           <td>${p.categoryId}</td>
                           <td>${p.categoryName}</td>
                             
                         
                           
                           <tr>       
                         </c:forEach> --%>
                       </tbody>
               </table>
           
             </div>
             <div class="panel-footer">
               <div class="row">
                 <div class="col col-xs-4">Page 1 of 5
                 </div>
                 <div class="col col-xs-8">
                   <ul class="pagination hidden-xs pull-right">
                     <li><a href="#">1</a></li>
                     <li><a href="#">2</a></li>
                     <li><a href="#">3</a></li>
                     <li><a href="#">4</a></li>
                     <li><a href="#">5</a></li>
                   </ul>
                   <ul class="pagination visible-xs pull-right">
                       <li><a href="#">«</a></li>
                       <li><a href="#">»</a></li>
                   </ul>
                 </div>
               </div>
             </div>
           </div>

</div></div>
	</div>
     
</body>
</html>