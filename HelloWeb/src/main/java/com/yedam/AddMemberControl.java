package com.yedam;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class AddMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		String fname = req.getParameter("first_name");
		String lname = req.getParameter("last_name");
		String email = req.getParameter("email");
		String job = req.getParameter("job_id");
		String hdate = req.getParameter("hire_date");
		
		Employee emp = new Employee();
		emp.setFirstName(fname);
		emp.setLastName(lname);
		emp.setEmail(email);
		emp.setJobId(job);
		emp.setHireDate(hdate);
		
		EmpDAO dao = new EmpDAO();
		try {
			if (dao.insertEmployee(emp)) {
				resp.sendRedirect("/HelloWeb");
			} else {
				resp.sendRedirect("addMemberForm.do");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
