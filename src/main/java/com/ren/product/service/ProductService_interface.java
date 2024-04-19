package com.ren.product.service;

import com.ren.product.model.ProductVO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService_interface {

	// 新增商品(將前端request值放入VO由DAO執行SQL語法，並返回VO由Controller轉給View)
	public ProductVO addProduct(Integer pCatNo, String pName, String pInfo, Integer pSize, String pColor, BigDecimal pPrice,
								Byte pStat, Integer pSalQty, Integer pComPeople, Integer pComScore);
	// 查詢單筆商品資料
	public ProductVO getOneProduct(Integer pNo);
	// 查詢所有商品資料
	public List<ProductVO> getAll();
	// 修改商品(返回值由Controller轉給View)
	public ProductVO updateProduct(Integer pNo, String pName, String pInfo, Integer pSize, String pColor, BigDecimal pPrice,
			Byte pStat, Integer pSalQty, Integer pComPeople, Integer pComScore);
	// 刪除商品
	public void deleteProduct(Integer pNo);

}
