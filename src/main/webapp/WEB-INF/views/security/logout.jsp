<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<body class="bg-gradient-primary">

  <form role="form" method="post" action="/security/logout">
   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form>
    
</body>
</html>

  <!-- Bootstrap core JavaScript-->
  <script src="/resources/vendor/jquery/jquery.min.js"></script>
  <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <script>
	$("document").ready(function(e){
	  $("form").submit();
	});
        
  </script>
  

