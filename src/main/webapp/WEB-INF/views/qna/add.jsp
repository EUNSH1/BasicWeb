<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jquery -->
<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<c:import url="../temp/boot.jsp"></c:import>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<!-- include summernote css/js-->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
   <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
	
	<c:import url="../temp/header.jsp"></c:import>
	<section class="container-fluid col-lg-8 mt-5">
		<h1>Board Write Page</h1>
		<div class="row">
	 <form class="align-center" action="./add" method="post" id="frm" enctype="multipart/form-data">
        
        <div>
        글 제목<br>
        <input type="text" id="title" name="title" placeholder="글 제목을 입력하세요"><br>
        </div>
         <div>
        작성자<br>
        <input type="text" id="writer" name="writer"  ><br>
        </div>
        <div>
        글 내용<br>
        <textarea id="contents" name="contents" rows="30" cols="100"></textarea>
        </div>
				
        <div class="mb-3" id="fileAddResult">
				
			</div>
			<div class="mb-3">
				<button type="button" id="fileAdd" class="btn btn-success">FileAdd</button>
			</div>
			
		
        
        <input type="button" name="add" id="uploadButton" value="작성 완료"  class ="btn btn-info">
        </form>
    </div>
	
</section>




<script type="text/javascript">
	$("#contents").summernote({
        height: 300,                 // 에디터 높이
        minHeight: null,             // 최소 높이
        maxHeight: null,             // 최대 높이
        focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
        lang: "ko-KR",               // 한글 설정
        placeholder: '최대 2048자까지 쓸 수 있습니다'   //placeholder 설정
          
   });
</script>
<script defer src="/js/fileManager.js">

</script>
<script src="/js/qnaUpload.js">

</script>
</body>
</html>