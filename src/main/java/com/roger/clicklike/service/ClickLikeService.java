package com.roger.clicklike.service;

import com.roger.clicklike.dao.ClickLikeDao_interface;
import com.roger.clicklike.dao.impl.ClickLikeJdbcDaoImpl;
import com.roger.clicklike.vo.ClickLikeVO;

import java.util.List;

public class ClickLikeService {

    private ClickLikeDao_interface dao;

    public ClickLikeService() {
        dao = new ClickLikeJdbcDaoImpl();
    }

    public ClickLikeVO addCL(Integer memNo, Integer artNo) {

        ClickLikeVO clickLikeVo = new ClickLikeVO();

        clickLikeVo.setMemNo(memNo);
        clickLikeVo.setMemNo(artNo);

        dao.insert(clickLikeVo);
        return clickLikeVo;
    }

    public ClickLikeVO updateCL(Integer memNo, Integer artNo) {

        ClickLikeVO clickLikeVo = new ClickLikeVO();

        clickLikeVo.setMemNo(memNo);
        clickLikeVo.setArtNo(artNo);

        dao.update(clickLikeVo);

        return dao.findByPrimaryKey(memNo);
    }

    public void deleteCL(Integer memNo) {
        dao.delete(memNo);
    }

    public ClickLikeVO getOneCL(Integer memNo) {
        return dao.findByPrimaryKey(memNo);
    }

    public List<ClickLikeVO> getAll() {
        return dao.getAll();
    }
}
