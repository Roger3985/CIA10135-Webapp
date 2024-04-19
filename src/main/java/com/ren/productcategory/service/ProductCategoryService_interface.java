package com.ren.productcategory.service;

import com.ren.product.model.ProductVO;
import com.ren.productcategory.model.ProductCategoryVO;

import java.util.List;
import java.util.Set;

public interface ProductCategoryService_interface {

	public ProductCategoryVO addProductCategory(String pCatNo);

	public List<ProductCategoryVO> getAll();

	public ProductCategoryVO getOneProductCatagory(Integer pCatNo);

	public Set<ProductVO> getProductsBypCatNo(Integer pCatNo);

	public ProductCategoryVO updateProductCategory(Integer pCatNo, String pCatName);
	
	public void deleteProductCategory(Integer pCatNo);
	
}
