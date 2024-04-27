package com.roger_hibernate.columnarticle.dao;



import com.roger_hibernate.columnarticle.vo.ColumnArticleVO;

import java.util.List;

public interface ColumnArticleDao_interface {

    public void insert(ColumnArticleVO columnArticleVo);
    public void update(ColumnArticleVO columnArticleVo);
    public void delete(Integer artNo);
    public ColumnArticleVO findByPrimaryKey(Integer artNo);
    public List<ColumnArticleVO> getAll();
}
