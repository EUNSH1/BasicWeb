<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>My Page</h1>
    <sec:authentication property="Principal" var="user"></sec:authentication>
    <h3> ID : ${user.id}</h3>
    
    <h3> Name : <sec:authentication property="Principal.name"/> </h3>
    
</body>
</html>