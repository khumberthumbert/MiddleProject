<%@page import="com.yedam.domain.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.persistence.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="menu.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>
	<%
	/*     EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList(); */
	List<Employee> list = (List<Employee>) request.getAttribute("listInfo"); // 반환유형 : Object
	
	String fname = (String) request.getAttribute("reqInfo");
	String lname = (String) session.getAttribute("sesInfo");
	%>
	
	<p>Request: <%=fname %></p>
	<p>Session: <%=lname %></p>
	<table class="table">
		<thead>
			<tr>
				<th>사원번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>직업</th>
				<th>입사일</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Employee emp : list) {
			%>
			<tr>
				<td><a href="getMember.do?emp_Id=<%=emp.getEmployeeId()%>"><%=emp.getEmployeeId()%></a></td>
				<td><a href="modifyMember.do?emp_Id=<%=emp.getEmployeeId()%>"><%=emp.getFirstName()%></a></td>
				<td><%=emp.getEmail()%></td>
				<td><%=emp.getJobId()%></td>
				<td><%=emp.getHireDate()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<table border="1">
		<tr>
			<td>><a href="addMemberForm.do">데이터추가</a></td>
		</tr>
	</table>
	
<jsp:include page="footer.jsp"></jsp:include>