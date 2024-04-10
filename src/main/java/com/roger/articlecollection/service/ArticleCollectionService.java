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

    public ArticleCollectionVo addAC(Integer memNo, Integer artNo) {

        ArticleCollectionVo articleCollectionVo = new ArticleCollectionVo();

        articleCollectionVo.setMemNo(memNo);
        articleCollectionVo.setMemNo(artNo);

        dao.insert(articleCollectionVo);
        return articleCollectionVo;
    }

    public ArticleCollectionVo updateAC(Integer memNo, Integer artNo) {

        ArticleCollectionVo articleCollectionVo = new ArticleCollectionVo();

        articleCollectionVo.setMemNo(memNo);
        articleCollectionVo.setArtNo(artNo);

        dao.update(articleCollectionVo);

        return dao.findByPrimaryKey(memNo);
    }

    public void deleteAC(Integer memNo) {
        dao.delete(memNo);
    }

    public ArticleCollectionVo getOneAC(Integer memNo) {
        return dao.findByPrimaryKey(memNo);
    }

    public List<ArticleCollectionVo> getAll() {
        return dao.getAll();
    }
}
