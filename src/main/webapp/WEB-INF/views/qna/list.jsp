<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>

	<c:import url="../temp/header.jsp"></c:import>
	<section class="container-fluid col-lg-8 mt-5">
	<h1>QNA List</h1>
	<div class="row mb-3">
		<form action="./list"
			class="row row-cols-lg-auto g-3 align-items-center">

			<div class="col-12">
				<label class="visually-hidden" for="Kind">Kind</label> 
				<select
					name="kind" class="form-select" id="Kind">
					<option class="kinds" value="num">글번호</option>
					<!-- <option class="kinds" value="contents">글내용</option> -->
					<option class="kinds" value="title">글제목</option>
					<option class="kinds" value="writer">작성자</option>
				</select>
			</div>

			<div class="col-12">
				<label class="visually-hidden" for="search">Search</label>
				<div class="input-group">
					<input type="text" name="search" value="${param.search}"
						class="form-control" id="search" placeholder="Search">
				</div>
			</div>
			<div class="col-12">
				<button type="submit" class="btn btn-primary">검색어찾기</button>
			</div>
		</form>

	</div>

	<table class="table table-bordered border-primary">
		 <thead style="text-align: c;">
		    <tr class="table-primary">
		      <th scope="col">번호</th>
		      <th scope="col">작성자</th>
		      <th scope="col">제목</th>
		      <th scope="col">내용</th>
		      <th scope="col">조회수</th>
		      <th scope="col">작성날짜</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach items="${list}" var="dto">
		    <tr>
		      
			      <td><a href="./detail?num=${dto.num}">${dto.num}</a></td>
			      <td>${dto.writer}</td>
			      <td>${dto.title}</td>
			      <td>${dto.contents}</td>
			      <td>${dto.hit}</td>
			      <td>${dto.regDate}</td>      
			     
		    </tr>
		     </c:forEach> 
		   </tbody>
	</table>
	
	<nav aria-label="Page navigation example">
				<ul class="pagination">
					<c:if test="${pager.pre}">
						<li class="page-item"><a class="page-link"
							href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">Previous</a>
						</li>
					</c:if>
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
						<li class="page-item"><a class="page-link"
							href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
					</c:forEach>

					<li class="page-item ${pager.next?'':'disabled'}"><a
						class="page-link"
						href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">Next</a>
					</li>
				</ul>
		</nav>
		<div>
			<h1>${result}</h1>
			<a href="./add" type="button" class="btn btn-info">글쓰기</a>
		</div>
		</section>
			<script type="text/javascript">
				let result = '${param.result}';
				if(result != ""){
					if(result == '1'){
						swal("등록성공","","success")
					} else{
						swal("등록실패","","error")
					}
				}
			</script>
</body>
</html>