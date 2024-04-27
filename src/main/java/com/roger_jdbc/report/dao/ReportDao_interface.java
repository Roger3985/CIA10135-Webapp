package com.roger_jdbc.report.dao;

import com.roger_jdbc.report.vo.ReportVo;

import java.util.List;

public interface ReportDao_interface {

    public void insert(ReportVo reportVo);
    public void update(ReportVo reportVo);
    public void delete(Integer reportNo);
    public ReportVo findByPrimaryKey(Integer reportNo);
    public List<ReportVo> getAll();
}
