package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.persistence.EmpDAO;

@WebServlet("/delMemberServlet")
public class DelMemberServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
		String emp_Id = req.getParameter("emp_Id");  // input name="emp_id"
		EmpDAO dao = new EmpDAO();
		boolean result = dao.deleteEmployee(Integer.parseInt(emp_Id));

		if (result) {
			resp.sendRedirect("empList");
		} else {
			resp.sendRedirect("employee/delForm.html");
		}
	}
}
