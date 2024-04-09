package com.roger.clicklike.service;

import com.roger.clicklike.dao.ClickLikeDao_interface;
import com.roger.clicklike.dao.impl.ClickLikeJdbcDaoImpl;
import com.roger.clicklike.vo.ClickLikeVo;

import java.util.List;

public class ClickLikeService {

    private ClickLikeDao_interface dao;

    public ClickLikeService() {
        dao = new ClickLikeJdbcDaoImpl();
    }

    public ClickLikeVo getOneCL(Integer memNo) {
        return dao.findByPrimaryKey(memNo);
    }

    public List<ClickLikeVo> getAll() {
        return dao.getAll();
    }
}
