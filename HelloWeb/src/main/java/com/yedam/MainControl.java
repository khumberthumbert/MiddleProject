package com.yedam;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class MainControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// 페이지 재지정.
			// resp.sendRedirect();
			EmpDAO dao = new EmpDAO();
			List<Employee> list = dao.getEmpList();
			
			req.setAttribute("listInfo", list);
			
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/empList.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
