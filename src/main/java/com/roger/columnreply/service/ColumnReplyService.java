package com.roger.columnreply.service;

import com.roger.columnreply.dao.ColumnReplyDao_interface;
import com.roger.columnreply.dao.impl.ColumnReplyJdbcDaoImpl;
import com.roger.columnreply.vo.ColumnReplyVo;

import java.util.List;

public class ColumnReplyService {

    private ColumnReplyDao_interface dao;

    public ColumnReplyService() {
        dao = new ColumnReplyJdbcDaoImpl();
    }

    public ColumnReplyVo getOneCR(Integer columnReplyNo) {
        return dao.findByPrimaryKey(columnReplyNo);
    }

    public List<ColumnReplyVo> getAll() {
        return dao.getAll();
    }
}
