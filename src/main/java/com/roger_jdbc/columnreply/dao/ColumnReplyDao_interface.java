package com.roger_jdbc.columnreply.dao;

import com.roger_jdbc.columnreply.vo.ColumnReplyVo;

import java.util.List;

public interface ColumnReplyDao_interface {

    public void insert(ColumnReplyVo columnReplyVo);
    public void update(ColumnReplyVo columnReplyVo);
    public void delete(Integer columnReplyNo);
    public ColumnReplyVo findByPrimaryKey(Integer columnReplyNo);
    public List<ColumnReplyVo> getAll();

}
