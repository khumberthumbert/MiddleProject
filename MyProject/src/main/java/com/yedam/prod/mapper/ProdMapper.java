package com.yedam.prod.mapper;

import java.util.List;

import com.yedam.prod.domain.ProdVO;

public interface ProdMapper {
	public List<ProdVO> prodList();
	public ProdVO searchProd(int prodCode);
	public List<ProdVO> plusList();
}
