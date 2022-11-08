<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
      <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
        <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
      </a>

      <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
        <li><a href="/" class="nav-link px-2 link-secondary" id = "home">Home</a></li>
        <li><a href="/qna/list" class="nav-link px-2 link-dark">Q & A</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">test1</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">test2</a></li>
        <li><a href="#" class="nav-link px-2 link-dark">test3</a></li>
      </ul>

 	<sec:authorize access="isAuthenticated()">
      <div class="col-md-3 text-end">
          <button type="button" class="btn btn-outline-primary me-2" onclick="location.href='/member/logout'">Logout</button>
          <button type="button" class="btn btn-primary" onclick="location.href='/member/mypage'">마이페이지</button>
        </div>
      </sec:authorize >

      <sec:authorize access="!isAuthenticated()">
      <div class="col-md-3 text-end">
          <button type="button" class="btn btn-outline-primary me-2" onclick="location.href='/member/login'">Login</button>
          <button type="button" class="btn btn-primary" onclick="location.href='/member/join'">Sign-up</button>
     </div>
      </sec:authorize>
      
      <%-- <sec:authorize access="hasRole('ADMIN')">
	      	<a href="/admin">Go Admin</a>
	  </sec:authorize> --%>
	  <sec:authorize url="/admin"> <!-- securityConfig 설정  -->
	      	<a href="/admin">Go Admin</a>
	  </sec:authorize>
	  
	  <sec:authorize access="hasAnyRole('ADMIN','MENAGER')">
	      	<a href="/member">Go Manager</a>
	      </sec:authorize>
	      
	<%-- <c:choose>
	   <c:when test="${not empty check}">
      <div class="col-md-3 text-end">
        <button type="button" class="btn btn-outline-primary me-2" onclick="location.href='/member/logout'">Logout</button>
        <button type="button" class="btn btn-primary" onclick="location.href='#'">로그아웃</button>
      </div>
      </c:when>
      <c:otherwise>
	<div class="col-md-3 text-end">
        <button type="button" class="btn btn-outline-primary me-2" onclick="location.href='/member/login'">Login</button>
        <button type="button" class="btn btn-primary" onclick="location.href='/member/join'">Sign-up</button>
      </div>						
	</c:otherwise>
    </c:choose> --%>
    </header>
 </div>