package com.roger_hibernate.report.service;

import com.roger_hibernate.report.dao.ReportDao_interface;
import com.roger_hibernate.report.dao.impl.ReportJdbcDaoImpl;
import com.roger_hibernate.report.vo.ReportVO;

import java.sql.Timestamp;
import java.util.List;

public class ReportService {

    private ReportDao_interface dao;

    public ReportService() {
        dao = new ReportJdbcDaoImpl();

    }

    public ReportVO addReport(Integer artReplyNo, Integer memNo, Integer admNo, Timestamp reportTime, String reportReason, Byte reportType) {

        ReportVO reportVo = new ReportVO();

        reportVo.setArtReplyNo(artReplyNo);
        reportVo.setMemNo(memNo);
        reportVo.setAdmNo(admNo);
        reportVo.setReportTime(reportTime);
        reportVo.setReportReason(reportReason);
        reportVo.setReportType(reportType);

        dao.insert(reportVo);
        return reportVo;
    }

    public ReportVO updateReport(Integer reportNo, Integer artReplyNo, Integer memNo, Integer admNo, Timestamp reportTime, String reportReason, Byte reportType) {

        ReportVO reportVo = new ReportVO();

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

    public ReportVO getOneReport(Integer reportNo) {
        return dao.findByPrimaryKey(reportNo);
    }

    public List<ReportVO> getAll() {
        return dao.getAll();
    }
}
