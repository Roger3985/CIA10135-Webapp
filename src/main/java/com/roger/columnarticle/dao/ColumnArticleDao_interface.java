package com.roger.columnarticle.dao;



import com.roger.columnarticle.vo.ColumnArticleVo;

import java.util.List;

public interface ColumnArticleDao_interface {

    public void insert(ColumnArticleVo columnArticleVo);
    public void update(ColumnArticleVo columnArticleVo);
    public void delete(Integer artNo);
    public ColumnArticleVo findByPrimaryKey(Integer artNo);
    public List<ColumnArticleVo> getAll();
}
