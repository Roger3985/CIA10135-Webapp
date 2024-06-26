package com.roger_jdbc.clicklike.service;

import com.roger_jdbc.clicklike.dao.ClickLikeDao_interface;
import com.roger_jdbc.clicklike.dao.impl.ClickLikeJdbcDaoImpl;
import com.roger_jdbc.clicklike.vo.ClickLikeVo;

import java.util.List;

public class ClickLikeService {

    private ClickLikeDao_interface dao;

    public ClickLikeService() {
        dao = new ClickLikeJdbcDaoImpl();
    }

    public ClickLikeVo addCL(Integer memNo, Integer artNo) {

        ClickLikeVo clickLikeVo = new ClickLikeVo();

        clickLikeVo.setMemNo(memNo);
        clickLikeVo.setMemNo(artNo);

        dao.insert(clickLikeVo);
        return clickLikeVo;
    }

    public ClickLikeVo updateCL(Integer memNo, Integer artNo) {

        ClickLikeVo clickLikeVo = new ClickLikeVo();

        clickLikeVo.setMemNo(memNo);
        clickLikeVo.setArtNo(artNo);

        dao.update(clickLikeVo);

        return dao.findByPrimaryKey(memNo);
    }

    public void deleteCL(Integer memNo) {
        dao.delete(memNo);
    }

    public ClickLikeVo getOneCL(Integer memNo) {
        return dao.findByPrimaryKey(memNo);
    }

    public List<ClickLikeVo> getAll() {
        return dao.getAll();
    }
}
