package com.roger.columnreply.dao;

import com.roger.columnreply.vo.ColumnReplyVO;

import java.util.List;

public interface ColumnReplyDao_interface {

    public void insert(ColumnReplyVO columnReplyVo);
    public void update(ColumnReplyVO columnReplyVo);
    public void delete(Integer columnReplyNo);
    public ColumnReplyVO findByPrimaryKey(Integer columnReplyNo);
    public List<ColumnReplyVO> getAll();

}
