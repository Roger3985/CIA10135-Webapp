package com.roger_hibernate.report.dao;

import com.roger_hibernate.report.vo.ReportVO;

import java.util.List;

public interface ReportDao_interface {

    public void insert(ReportVO reportVo);
    public void update(ReportVO reportVo);
    public void delete(Integer reportNo);
    public ReportVO findByPrimaryKey(Integer reportNo);
    public List<ReportVO> getAll();
}
