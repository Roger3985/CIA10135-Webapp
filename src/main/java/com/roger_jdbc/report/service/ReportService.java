package com.roger_jdbc.report.service;

import com.roger_jdbc.report.dao.ReportDao_interface;
import com.roger_jdbc.report.dao.impl.ReportJdbcDaoImpl;
import com.roger_jdbc.report.vo.ReportVo;

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

    public ReportVo updateReport(Integer reportNo, Integer artReplyNo, Integer memNo, Integer admNo, Timestamp reportTime, String reportReason, Byte reportType) {

        ReportVo reportVo = new ReportVo();

        reportVo.setReportNo(reportNo);
        reportVo.setArtReplyNo(artReplyNo);
        reportVo.setMemNo(memNo);
        reportVo.setAdmNo(admNo);
        reportVo.setReportTime(reportTime);
        reportVo.setReportReason(reportReason);
        reportVo.setReportType(reportType);

        dao.update(reportVo);
        return dao.findByPrimaryKey(reportNo);
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
