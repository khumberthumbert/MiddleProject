<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="menu.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>
<%
String lname = (String) session.getAttribute("sesInfo");
%>
<p>Session: <%=lname %></p>

<form action="addMember.do">
	firstName: <input name="first_name"><br>
	<!-- parameter의 이름: -->
	lastName: <input name="last_name"><br> email: <input
		name="email"><br> job: <input name="job_id"><br>
	hire: <input name="hire_date"><br> <input type="submit"
		value="저장">
</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>