<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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

			  	<!-- list 시작-->
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>번호</th>
                      <th>제목</th>
                      <th>작성자</th>
                      <th>작성일</th>
                      <th>수정일</th>
                    </tr>
                  </thead>

                  <tbody>
					
					<c:forEach items="${list}" var="vo">
                    <tr>
                      <td><c:out value="${vo.bno}"/></td>
                      <td><c:out value="${vo.title}"/></td>
                      <td><c:out value="${vo.register}"/></td>
                      <td><fmt:formatDate pattern="yyyy-MM-dd" value="${vo.regdate}"/></td>
                      <td><fmt:formatDate pattern="yyyy-MM-dd" value="${vo.updatedate}"/></td>
                    </tr>
					</c:forEach>
				   	
                  </tbody>
                </table>
				<!-- list 끝 -->
				
				<!-- search and form 시작 -->
				<div class="row">
					<div class="col-lg-12">
						<form role="form" id="searchForm" action="/business/businessList" method="get">
							<select name="searchType">
								<option value="" ${listPageConfig.param.searchType==null ? 'selected' : ''}>................</option>
								<option value="0" ${listPageConfig.param.searchType=='0' ? 'selected' : ''}>제목</option>
								<option value="1" ${listPageConfig.param.searchType=='1' ? 'selected' : ''}>내용</option>
								<option value="2" ${listPageConfig.param.searchType=='2' ? 'selected' : ''}>작성자</option>
								<option value="01" ${listPageConfig.param.searchType=='01' ? 'selected' : ''}>제목 or 내용</option>
								<option value="02" ${listPageConfig.param.searchType=='02' ? 'selected' : ''}>제목 or 작성자</option>
								<option value="012" ${listPageConfig.param.searchType=='012' ? 'selected' : ''}>제목 or 내용 or 작성자</option>
							</select>				
							
							<input type="text" name="searchValue" value="${listPageConfig.param.searchValue}">

							<button type="submit"> 찾기 </button>

							<input type="hidden" name="pageNum" value="${listPageConfig.param.pageNum}">
							<input type="hidden" name="pageAmount" value="${listPageConfig.param.pageAmount}">
						</form>
					</div>
				</div>
				<!-- search and form 끝 -->

				<!-- page 시작 -->
				<div class="pull-right">
					<ul class="pagination">
						<c:if test="${listPageConfig.prev}">
							<li class="paginate_button  previous"><a href="${listPageConfig.startPage-1}">이전</a></li>
						</c:if>
						
						<c:forEach var="num" begin="${listPageConfig.startPage}" end="${listPageConfig.endPage}">
							<li class="paginate_button"><a href="${num}">${num}</a></li>
						</c:forEach>

						<c:if test="${listPageConfig.next}">
							<li class="paginate_button  next"><a href="${listPageConfig.endPage+1}">다음</a></li>
						</c:if>
					</ul>
				</div>
				<!-- page 끝 -->
				
				
				<div class="row">
					<div class="col-lg-12" style="text-align:center;"">
						<button id="writeButton"  type="button" class="btn btn-primary btn-lg">등록하기</button>
					</div>
				</div>
				
				<!-- page and form 시작 -->
				<form role="form" id="listForm" method="get" action="/business/businessList">
					<input type="hidden" name="searchType" value="${listPageConfig.param.searchType}">
					<input type="hidden" name="searchValue" value="${listPageConfig.param.searchValue}">
					<input type="hidden" name="pageNum" value="${listPageConfig.param.pageNum}">
					<input type="hidden" name="pageAmount" value="${listPageConfig.param.pageAmount}">					
				</form>
				<!-- page and form 끝 -->
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

		$("#listForm").find("input[name='pageNum']").val($(this).attr('href'));
		$("#listForm").submit();
	});
	
	$("#writeButton").on("click", function(){
		$("#listForm").attr('action', '/business/businessWriteForm')
		$("#listForm").submit();

	});
</script>
