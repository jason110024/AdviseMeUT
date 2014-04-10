<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="webapp.addServlets.*" %>
<%@ page import="webapp.datastoreObjects.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.googlecode.objectify.*" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
   <head>
      	<link href="stylesheets/bootstrap.css" rel="stylesheet" media="screen">
        <script src="http://code.jquery.com/jquery.js"></script>
    	<script src="stylesheets/bootstrap.js"></script>
      <title>AdviseMe- Add Colleges</title>
      <h1>Add a College</h1>
   </head>
   <body> 
 <%
	ObjectifyService.register(School.class);
	List<School> schools=ObjectifyService.ofy().load().type(School.class).list();
	Collections.sort(schools);  
	if(schools.isEmpty()){
		%><h1>There are no schools to add a college to.:(</h1><%
	}else{
 %>   
 		<form action="/addcollege" method="post">
 	 	<h3>School:</h3><div>
		<select name="schoolname" size="1">
		<%			
		for(School school: schools){
			pageContext.setAttribute("school_name",school.getName());
		%>
			<option>${fn:escapeXml(school_name)}</option>
		<%
		} %>
			</select>
			</div>
		<h3>College Name:</h3>
      	<div><textarea name="collegename" rows="1" cols="30"></textarea></div>
      	<div><input type="submit" value="Add College" /></div>
      	<input type="button" value="Cancel" onclick="window.location.href='/home.jsp'"> 
    </form> 
    <%
    } %>
   </body>
</html>
		--%>