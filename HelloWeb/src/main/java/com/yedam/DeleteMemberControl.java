package com.yedam;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.persistence.EmpDAO;

public class DeleteMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// DB 삭제처리.
		String empId = req.getParameter("emp_Id");

		EmpDAO dao = new EmpDAO();
		try {
			if (dao.deleteEmployee(Integer.parseInt(empId))) {
				resp.sendRedirect("/HelloWeb");
			} else {
				resp.sendRedirect("modifyMember.do");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
