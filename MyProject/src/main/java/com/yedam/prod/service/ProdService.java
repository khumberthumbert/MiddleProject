package com.yedam.prod.service;

import java.util.List;

import com.yedam.prod.domain.ProdVO;

public interface ProdService {
	public List<ProdVO> prodList();
	public ProdVO getProd(int prodCode);
	public List<ProdVO> plusList();
}
