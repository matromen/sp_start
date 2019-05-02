<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    


<%@ include file="../../include/top.jsp" %>

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Tables</h1>
          <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the <a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
            </div>



			<h1>member sample page</h1>
			
			<p>principal : <sec:authentication property="principal"/></p>
			<p>MemberVO : <sec:authentication property="principal.member"/></p>
			<p>사용자이름 : <sec:authentication property="principal.member.userName"/> </p>
			<p>사용자id : <sec:authentication property="principal.username"/> </p>
			<p>사용자권한리스트 : <sec:authentication property="principal.member.authList"/> </p>
			
			
			
			
			</div>
        </div>
        <!-- /.container-fluid -->
        
<%@ include file="../../include/buttom.jsp" %>        
