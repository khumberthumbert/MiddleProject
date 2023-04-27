package com.yedam.prod.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.prod.domain.ProdVO;
import com.yedam.prod.service.ProdService;
import com.yedam.prod.service.ProdServiceImpl;


public class GetProdControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodCode = req.getParameter("prodCode");
		
		ProdService service = new ProdServiceImpl();
		ProdVO vo = service.getProd(Integer.parseInt(prodCode));
		req.setAttribute("prodInfo", vo);
		List<ProdVO> list = service.plusList();
		req.setAttribute("list", list);
				
		return "prod/prodMain.tiles";
	}
}
