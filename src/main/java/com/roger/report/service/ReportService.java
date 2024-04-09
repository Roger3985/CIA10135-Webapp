package com.roger.report.service;

import com.roger.report.dao.ReportDao_interface;
import com.roger.report.dao.impl.ReportJdbcDaoImpl;
import com.roger.report.vo.ReportVo;

import java.sql.Timestamp;
import java.util.List;

public class ReportService {

    private ReportDao_interface dao;

    public ReportService() {
        dao = new ReportJdbcDaoImpl();

    }

    public ReportVo addReport(Integer artReplyNo, Integer memNo, Integer admNo, Timestamp reportTime, String reportReason, Byte reportType) {

        ReportVo reportVo = new ReportVo();

        reportVo.setArtReplyNo(artReplyNo);
        reportVo.setMemNo(memNo);
        reportVo.setAdmNo(admNo);
        reportVo.setReportTime(reportTime);
        reportVo.setReportReason(reportReason);
        reportVo.setReportType(reportType);

        dao.insert(reportVo);
        return reportVo;
    }

    public void deleteReport(Integer reportNo) {
        dao.delete(reportNo);
    }

    public ReportVo getOneReport(Integer reportNo) {
        return dao.findByPrimaryKey(reportNo);
    }

    public List<ReportVo> getAll() {
        return dao.getAll();
    }
}
