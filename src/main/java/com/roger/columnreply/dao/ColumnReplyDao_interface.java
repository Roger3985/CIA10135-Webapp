package com.roger.columnreply.dao;

import com.roger.columnreply.vo.ColumnReplyVo;

import java.util.List;

public interface ColumnReplyDao_interface {

    public void insert(ColumnReplyVo columnReplyVo);
    public void update(ColumnReplyVo columnReplyVo);
    public void delete(Integer columnReplyNo);
    public ColumnReplyVo findByPrimaryKey(Integer columnReplyNo);
    public List<ColumnReplyVo> getAll();

}
