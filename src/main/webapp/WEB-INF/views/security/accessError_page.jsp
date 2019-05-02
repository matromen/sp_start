<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Access Denied Page</title>

  <!-- Custom fonts for this template-->
  <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

  <style>
  	html, body{
  		height: 100%;
  	}
  </style>  
</head>
 
<body>
     <!-- Begin Page Content -->
     <div class="container-fluid"  style="display:flex; height:100%; align-items: center; justify-content: center;">
       <!-- 404 Error Text -->
       <div class="text-center" style="width:100%;"> 
			<h1  data-text="Access Denied Page"  style="width:100%; margin:0 auto;">Access Denied Page</h1>
			<h2><c:out value="${SPRING_SECURITY_403_EXCEPTION.getMessage() }"></c:out></h2>
			<h2><c:out value="${msg}"></c:out></h2>
       </div>

     </div>
     <!-- /.container-fluid -->
</body>

  <!-- Bootstrap core JavaScript-->
  <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="/resources/js/sb-admin-2.min.js"></script>

</body>        
</html>        