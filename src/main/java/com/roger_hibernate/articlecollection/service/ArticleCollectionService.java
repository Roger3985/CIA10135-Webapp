package com.roger_hibernate.articlecollection.service;

import com.roger_hibernate.articlecollection.dao.ArticleCollectionDao_interface;
import com.roger_hibernate.articlecollection.dao.impl.ArticleCollectionJdbcDaoImpl;
import com.roger_hibernate.articlecollection.vo.ArticleCollectionVO;

import java.util.List;

public class ArticleCollectionService {

    private ArticleCollectionDao_interface dao;

    public ArticleCollectionService() {
        dao = new ArticleCollectionJdbcDaoImpl();
    }

    public ArticleCollectionVO addAC(Integer memNo, Integer artNo) {

        ArticleCollectionVO articleCollectionVo = new ArticleCollectionVO();

        articleCollectionVo.setMemNo(memNo);
        articleCollectionVo.setMemNo(artNo);

        dao.insert(articleCollectionVo);
        return articleCollectionVo;
    }

    public ArticleCollectionVO updateAC(Integer memNo, Integer artNo) {

        ArticleCollectionVO articleCollectionVo = new ArticleCollectionVO();

        articleCollectionVo.setMemNo(memNo);
        articleCollectionVo.setArtNo(artNo);

        dao.update(articleCollectionVo);

        return dao.findByPrimaryKey(memNo);
    }

    public void deleteAC(Integer memNo) {
        dao.delete(memNo);
    }

    public ArticleCollectionVO getOneAC(Integer memNo) {
        return dao.findByPrimaryKey(memNo);
    }

    public List<ArticleCollectionVO> getAll() {
        return dao.getAll();
    }
}
