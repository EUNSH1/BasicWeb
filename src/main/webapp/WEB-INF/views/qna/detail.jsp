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


	<h1> qna detail page</h1>
	
	
	
	<table class="table table-bordered border-primary">
  <tbody>
  
    <tr >
    	<th>제목</th>
    	<td>${qnaVO.title }</td>
      
    </tr>
     <tr >
    	<th>제작자</th>
    	<td>${qnaVO.writer }</td>
    </tr>
     <tr>
    	<th>내용</th>
    	<td>${qnaVO.contents }</td>
    </tr>
    
    
   <c:forEach items="${qnaVO.qnaFileVOs }" var="file">
	    <tr class="table-primary">
	    <th>파일</th>
		     
				<td><img alt="" src="/file/qna/${file.fileName}"></td>
			    <td><a href="/fileDown/qna?fileName=${file.fileName}">down</a></td>	
			
	    </tr>
	</c:forEach>
    
  </tbody>
</table>

</section>
<section class="container-fluid col-lg-2 mt-5">

<div> <a href="/qna/update?num=${qnaVO.num}" class="btn btn-info" >글 수정</a></div>
<div> <a href="/qna/delete?num=${qnaVO.num}" class="btn btn-info" style="margin-top: 10px;">글 삭제</a></div>
</section>
	
	
</body>
</html>