package com.yedam.prod.domain;

import lombok.Data;

@Data
public class ProdVO {
	private int prodCode;
	private String prodName;
	private String prodInfo;
	private String price;
	private String dcPrice;
	private int grade;
}
