package com.roger_hibernate.columnarticle.service;

import com.roger_hibernate.columnarticle.dao.ColumnArticleDao_interface;
import com.roger_hibernate.columnarticle.dao.impl.ColumnArticleJdbcDaoImpl;
import com.roger_hibernate.columnarticle.vo.ColumnArticleVO;

import java.sql.Timestamp;
import java.util.List;

public class ColumnArticleService {

    private ColumnArticleDao_interface dao;

    public ColumnArticleService() {
        dao = new ColumnArticleJdbcDaoImpl();
    }

    public ColumnArticleVO addCa(Integer admNo, String artTitle, String artContent, Timestamp artTime, Integer artCatNo, Byte artStat) {

        ColumnArticleVO columnArticleVo = new ColumnArticleVO();

        columnArticleVo.setAdmNo(admNo);
        columnArticleVo.setArtTitle(artTitle);
        columnArticleVo.setArtContent(artContent);
        columnArticleVo.setArtTime(artTime);
        columnArticleVo.setArtCatNo(artCatNo);
        columnArticleVo.setArtStat(artStat);

        dao.insert(columnArticleVo);
        return columnArticleVo;
    }

    public ColumnArticleVO updateCa(Integer artNo, Integer admNo, String artTitle, String artContent, Timestamp artTime, Integer artCatNo, Byte artStat) {

        ColumnArticleVO columnArticleVo = new ColumnArticleVO();

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

    public ColumnArticleVO getOneCa(Integer artNo) {
        return dao.findByPrimaryKey(artNo);
    }

    public List<ColumnArticleVO> getAll() {
        return dao.getAll();
    }
}
