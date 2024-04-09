package com.roger.clicklike.dao;

import com.roger.clicklike.vo.ClickLikeVo;

import java.util.List;

public interface ClickLikeDao_interface {

    // 新增會員點讚資料
    public void insert(ClickLikeVo clickLikeVo);

    // 更新會員點讚資料
    public void update(ClickLikeVo clickLikeVo);

    // 刪除會員點讚資料
    public void delete(Integer memNo);

    // 查詢一個會員點讚資料
    public ClickLikeVo findByPrimaryKey(Integer memNo);

    // 查詢全部會員的點讚資料
    public List<ClickLikeVo> getAll();
}
