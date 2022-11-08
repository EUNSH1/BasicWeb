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

	<section class="container-fluid col-lg-4 mt-5">
	<div class="row"> 
		<div><h1>회원가입</h1></div>
		<div class="row justify-content-center mt-5">
    		<div class="col-lg-6">
        	<form:form modelAttribute="memberVO"  method="post">
        	
			  <div class="row mb-3">
			    <label for="inputUserName" class="col-sm-2 col-form-label">ID</label>
			    <div class="col-sm-10">
			      <form:input path="id" cssClass="form-control" id="inputId"/>	
			      <form:errors path="id"></form:errors>
			      <div id="inputIdResult"></div>
			    </div>
			  </div>
			  <div class="row mb-3">
			    <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
			    <div class="col-sm-10">
			      <form:password path="pw" cssClass="form-control" id="inputPw"/>
			      <form:errors path="pw"></form:errors>
				  <div id="inputPwResult"></div>
			    </div>
			  </div>

			  <div class="row mb-3">
			    <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
			    <div class="col-sm-10">
			      <form:password path="pwCheck" cssClass="form-control" id="inputPwCheck"/>
			      <form:errors path="pwCheck"></form:errors>
				  <div id="inputPwCheckResult"></div>
			    </div>
			  </div>

			  <div class="row mb-3">
			    <label for="inputName" class="col-sm-2 col-form-label">Name</label>
			    <div class="col-sm-10">
			      <form:input path="name" cssClass="form-control" id="inputName"/>
			      <form:errors path="name"></form:errors>	
				  <div id="inputNameResult"></div>
			    </div>
			  </div>
			  
			  <div class="row mb-3">
			    <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
			    <div class="col-sm-10">
			      <form:input path="email" cssClass="form-control" id="inputEmail" />
			      <form:errors path="email"></form:errors>
				  <div id="inputEmailResult"></div>
			    </div>
			  </div>
			  
			  <div class="row mb-3">
			    <label for="inputEmail" class="col-sm-2 col-form-label">Age</label>
			    <div class="col-sm-10">
			      <form:input path="age" cssClass="form-control" id="inputAge" />
			      <form:errors path="age"></form:errors>
				  <div id="inputAgeResult"></div>
			    </div>
			  </div>
			  
			  <div class="row mb-3">
			    <label for="inputEmail" class="col-sm-2 col-form-label">Birth</label>
			    <div class="col-sm-10">
			      <form:input path="birth" cssClass="form-control" id="inputBirth" />
			      <form:errors path="birth"></form:errors>
				  <div id="inputAgeResult"></div>
			    </div>
			  </div>

			  
			  
			  <div class="row justify-content-end">
			  	<div>
			  		<button type="submit" id="joinButton" class="btn btn-primary mb-3">Sign in</button>
			  	</div>
			  </div>
			</form:form>
        	</div>
        
        </div>
        
		<!-- 약관 test-->
        <div class="row justify-content-center mt-5">
			<div>
				ALL <input type="checkbox" id="all">
			</div>	

			<div>
				동의1 <input type="checkbox" class="check" name="" id="">	
				<div>
					약관1
				</div>	
			</div>

			<div>
				동의2 <input type="checkbox" class="check" name="" id="">	
				<div>
					약관2
				</div>	
			</div>

			<div>
				동의3 <input type="checkbox" class="check" name="" id="">	
				<div>
					약관3
				</div>	
			</div>
		</div>
	
	</div>
	</section>
    
<script src="/js/join.js"></script>
<script src="/js/util.js"></script>
</body>
</html>