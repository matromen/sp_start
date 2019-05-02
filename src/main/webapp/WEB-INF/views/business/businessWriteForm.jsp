<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<%@ include file="../include/top.jsp" %>

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Business List</h1>
          <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below. For more information about DataTables, please visit the <a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p>

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
            </div>
            
            
            
            
            <div class="card-body">
              <div class="table-responsive">

			  	<!-- writeForm 시작-->
				<form role="form" id="writeForm" method="post" action="/business/businessWritePro">
					<div class="form-group">
						<label>제목</label>
						<input  class="form-control" name="title">
					</div>
					
					<div class="form-group">
						<label>내용</label>
						<input  class="form-control" name="content">
					</div>
					
					<div class="form-group">
						<label>작성자</label>
						<input  class="form-control" name="register" value='<sec:authentication property="principal.member.userName"/>' readonly>
					</div>
					
					<button type="submit" class="btn btn-default">등록하기</button>
					<button type="reset" class="btn btn-default">초기화</button>										
					
					
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					
					<input type="hidden" name="pageAmount" value="${param.pageAmount}">
					<input type="hidden" name="pageNum" value="${param.pageNum}">
					<input type="hidden" name="searchType" value="${param.searchType}">
					<input type="hidden" name="searchValue" value="${param.searchValue}">
				</form>             
				<!-- writeForm 끝 -->
              </div>
            </div>
             
            
            
          </div>
        </div>
        <!-- /.container-fluid -->
        
<%@ include file="../include/buttom.jsp" %>    

<script>
	$("#searchForm button").on("click", function(e){
		if(!$("#searchForm").find("option:selected")){
			alert("검색 종류를 선택 해주세요");
			return false;
		}

		if($("#searchForm").find("input[name='searchValue']").val() == ""){
			alert("검색어를 넣어 주세요");
			return false;
		}

		$("#searchForm").find("input[name='pageNum']").val('1');
		$("#searchForm").submit();
	});

	$(".paginate_button a").on("click", function(e){
		e.preventDefault();

		$("#paramForm").find("input[name='pageNum']").val($(this).attr('href'));
		$("#paramForm").submit();
	});
</script>
