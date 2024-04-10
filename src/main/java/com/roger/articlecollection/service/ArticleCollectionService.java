package com.roger.articlecollection.service;

import com.roger.articlecollection.dao.ArticleCollectionDao_interface;
import com.roger.articlecollection.dao.impl.ArticleCollectionJdbcDaoImpl;
import com.roger.articlecollection.vo.ArticleCollectionVo;

import java.util.List;

public class ArticleCollectionService {

    private ArticleCollectionDao_interface dao;

    public ArticleCollectionService() {
        dao = new ArticleCollectionJdbcDaoImpl();
    }

    public ArticleCollectionVo getOneAC(Integer memNo) {
        return dao.findByPrimaryKey(memNo);
    }

    public List<ArticleCollectionVo> getAll() {
        return dao.getAll();
    }
}
