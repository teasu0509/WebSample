<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<nav id="sidebarMenu"
	class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
		<security:authorize access="isAuthenticated()">
    authenticated as <security:authentication property="principal.username" /> 
</security:authorize>
<c:out value="${pageContext.request.remoteUser}"/>
	<div class="sidebar-sticky pt-3">
		<ul class="nav flex-column">
			<li class="nav-item"><a class="nav-link active" href="#">
			Dashboard<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Orders</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Products</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Customers</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Reports</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Integrations</a></li>
		</ul>
	</div>
</nav>