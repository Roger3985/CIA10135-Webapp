package com.roger_jdbc.articlecollection.dao;

import com.roger_jdbc.articlecollection.vo.ArticleCollectionVo;

import java.util.List;

public interface ArticleCollectionDao_interface {

    public void insert(ArticleCollectionVo articleCollectionVo);
    public void update(ArticleCollectionVo articleCollectionVo);
    public void delete(Integer memNo);
    public ArticleCollectionVo findByPrimaryKey(Integer memNo);
    public List<ArticleCollectionVo> getAll();

}
