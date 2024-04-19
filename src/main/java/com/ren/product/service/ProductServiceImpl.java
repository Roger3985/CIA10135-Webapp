package com.ren.product.service;

import com.ren.product.dao.ProductDAO_interface;
import com.ren.product.dao.ProductJNDIDAOImpl;
import com.ren.product.model.ProductVO;

import java.math.BigDecimal;
import java.util.List;

public class ProductServiceImpl implements ProductService_interface {

    private ProductDAO_interface dao;

    // DI
    public ProductServiceImpl() {
        dao = new ProductJNDIDAOImpl();
    }

    // 新增成功後，返回VO至呼叫Service的Controller，並由Controller轉給View呈現在網頁上
    @Override
    public ProductVO addProduct(Integer pCatNo, String pName, String pInfo, Integer pSize, String pColor, BigDecimal pPrice,
                                Byte pStat, Integer pSalQty, Integer pComPeople, Integer pComScore) {
        // TODO Auto-generated method stub
        ProductVO productVO = new ProductVO();
        // 將傳入參數放入VO
        productVO.setpCatNo(pCatNo);
        productVO.setpName(pName);
        productVO.setpInfo(pInfo);
        productVO.setpSize(pSize);
        productVO.setpColor(pColor);
        productVO.setpPrice(pPrice);
        productVO.setpStat(pStat);
        productVO.setpSalQty(pSalQty);
        productVO.setpComPeople(pComPeople);
        productVO.setpComScore(pComScore);
        // 將VO放入dao定義的方法內，使其執行資料庫操作
        dao.insert(productVO);
        // 返回值作為呈現在View上使用
        return productVO;
    }

    // 返回VO至呼叫Service的Controller，並由Controller轉給View呈現在網頁上
    @Override
    public ProductVO getOneProduct(Integer pNo) {
        // TODO Auto-generated method stub
        return dao.findByPrimaryKey(pNo);
    }

    // 返回VO List至呼叫Service的Controller，並由Controller轉給View呈現在網頁上
    @Override
    public List<ProductVO> getAll() {
        // TODO Auto-generated method stub
        return dao.getAll();
    }

    // 修改成功後，返回VO至呼叫Service的Controller，並由Controller轉給View呈現在網頁上
    @Override
    public ProductVO updateProduct(Integer pNo, String pName, String pInfo, Integer pSize, String pColor,
                                   BigDecimal pPrice, Byte pStat, Integer pSalQty, Integer pComPeople, Integer pComScore) {
        // TODO Auto-generated method stub
        ProductVO productVO = new ProductVO();
        // 將傳入參數放入VO
        productVO.setpNo(pNo);
        productVO.setpName(pName);
        productVO.setpInfo(pInfo);
        productVO.setpSize(pSize);
        productVO.setpColor(pColor);
        productVO.setpPrice(pPrice);
        productVO.setpStat(pStat);
        productVO.setpSalQty(pSalQty);
        productVO.setpComPeople(pComPeople);
        productVO.setpComScore(pComScore);
        // 將VO放入dao定義的方法內，使其執行資料庫操作
        dao.update(productVO);
        // 返回值作為呈現在View上使用
        return productVO;
    }

    @Override
    public void deleteProduct(Integer pNo) {
        // TODO Auto-generated method stub
        dao.delete(pNo);
    }

}
