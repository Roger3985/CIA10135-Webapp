package com.roger_hibernate.articlecollection.dao;

import com.roger_hibernate.articlecollection.vo.ArticleCollectionVO;

import java.util.List;

public interface ArticleCollectionDao_interface {

    public void insert(ArticleCollectionVO articleCollectionVo);
    public void update(ArticleCollectionVO articleCollectionVo);
    public void delete(Integer memNo);
    public ArticleCollectionVO findByPrimaryKey(Integer memNo);
    public List<ArticleCollectionVO> getAll();

}
