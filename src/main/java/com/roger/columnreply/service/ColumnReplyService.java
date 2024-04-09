package com.roger.columnreply.service;

import com.roger.columnreply.dao.ColumnReplyDao_interface;
import com.roger.columnreply.dao.impl.ColumnReplyJdbcDaoImpl;
import com.roger.columnreply.vo.ColumnReplyVo;

import java.sql.Timestamp;
import java.util.List;

public class ColumnReplyService {

    private ColumnReplyDao_interface dao;

    public ColumnReplyService() {
        dao = new ColumnReplyJdbcDaoImpl();
    }

    public ColumnReplyVo addCR(Integer artNo, Integer memNo, String comContent, Timestamp comTime, Byte comStat) {

        ColumnReplyVo columnReplyVo = new ColumnReplyVo();

        columnReplyVo.setArtNo(artNo);
        columnReplyVo.setMemNo(memNo);
        columnReplyVo.setComContent(comContent);
        columnReplyVo.setComTime(comTime);
        columnReplyVo.setComStat(comStat);

        dao.insert(columnReplyVo);
        return columnReplyVo;
    }

    public ColumnReplyVo updateCR(Integer columnReplyNo, Integer artNo, Integer memNo, String comContent, Timestamp comTime, Byte comStat) {

        ColumnReplyVo columnReplyVo = new ColumnReplyVo();

        columnReplyVo.setColumnReplyNo(columnReplyNo);
        columnReplyVo.setArtNo(artNo);
        columnReplyVo.setMemNo(memNo);
        columnReplyVo.setComContent(comContent);
        columnReplyVo.setComTime(comTime);
        columnReplyVo.setComStat(comStat);

        return dao.findByPrimaryKey(columnReplyNo);
    }

    public void deleteCR(Integer columnReplyNo) {
        dao.delete(columnReplyNo);
    }

    public ColumnReplyVo getOneCR(Integer columnReplyNo) {
        return dao.findByPrimaryKey(columnReplyNo);
    }

    public List<ColumnReplyVo> getAll() {
        return dao.getAll();
    }
}
