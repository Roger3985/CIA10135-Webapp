package com.ren.product.dao;

import com.ren.product.model.ProductVO;

import java.util.List;

public interface ProductDAO_interface {

    // 新增商品
    public void insert(ProductVO productVO);
    // 修改商品資料
    public void update(ProductVO productVO);
    // 刪除商品資料
    public void delete(Integer pNo);
    // 透過商品編號查詢商品
    public ProductVO findByPrimaryKey(Integer pNo);
    // 查詢所有商品
    public List<ProductVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<ProductVO> getAll(Map<String, String[]> map);
    // 商品照片新增

}

