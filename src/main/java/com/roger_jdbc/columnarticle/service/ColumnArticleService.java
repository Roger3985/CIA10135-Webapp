package com.roger_jdbc.columnarticle.service;

import com.roger_jdbc.columnarticle.dao.ColumnArticleDao_interface;
import com.roger_jdbc.columnarticle.dao.impl.ColumnArticleJdbcDaoImpl;
import com.roger_jdbc.columnarticle.vo.ColumnArticleVo;

import java.sql.Timestamp;
import java.util.List;

public class ColumnArticleService {

    private ColumnArticleDao_interface dao;

    public ColumnArticleService() {
        dao = new ColumnArticleJdbcDaoImpl();
    }

    public ColumnArticleVo addCa(Integer admNo, String artTitle, String artContent,Timestamp artTime, Integer artCatNo,Byte artStat) {

        ColumnArticleVo columnArticleVo = new ColumnArticleVo();

        columnArticleVo.setAdmNo(admNo);
        columnArticleVo.setArtTitle(artTitle);
        columnArticleVo.setArtContent(artContent);
        columnArticleVo.setArtTime(artTime);
        columnArticleVo.setArtCatNo(artCatNo);
        columnArticleVo.setArtStat(artStat);

        dao.insert(columnArticleVo);
        return columnArticleVo;
    }

    public ColumnArticleVo updateCa(Integer artNo, Integer admNo, String artTitle, String artContent,Timestamp artTime, Integer artCatNo,Byte artStat) {

        ColumnArticleVo columnArticleVo = new ColumnArticleVo();

        columnArticleVo.setArtNo(artNo);
        columnArticleVo.setAdmNo(admNo);
        columnArticleVo.setArtTitle(artTitle);
        columnArticleVo.setArtContent(artContent);
        columnArticleVo.setArtTime(artTime);
        columnArticleVo.setArtCatNo(artCatNo);
        columnArticleVo.setArtStat(artStat);

        dao.update(columnArticleVo);
        return dao.findByPrimaryKey(artNo);
    }

    public void deleteCa(Integer artNo) {
        dao.delete(artNo);
    }

    public ColumnArticleVo getOneCa(Integer artNo) {
        return dao.findByPrimaryKey(artNo);
    }

    public List<ColumnArticleVo> getAll() {
        return dao.getAll();
    }
}
