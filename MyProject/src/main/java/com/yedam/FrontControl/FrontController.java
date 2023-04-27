package com.yedam.FrontControl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.prod.control.Control;
import com.yedam.prod.control.GetProdControl;
import com.yedam.prod.control.MainControl;
import com.yedam.prod.control.ProdListControl;

public class FrontController extends HttpServlet {

	private Map<String, Control> map;
	String encoding;

	public FrontController() {
		map = new HashMap<>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		encoding = config.getInitParameter("enc");
		// 첫페이지.
		map.put("/main.do", new MainControl());
		map.put("/prodList.do", new ProdListControl());
		map.put("/getProd.do", new GetProdControl());
		
	}	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println(path);

		Control control = map.get(path);
		String viewPage = control.execute(req, resp);
		System.out.println(viewPage);

		if (viewPage.endsWith(".do")) {
			resp.sendRedirect(viewPage);
			return;
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
	}
}
