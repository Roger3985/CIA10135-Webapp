package com.roger.report.dao.impl;

import com.roger.report.dao.ReportDao_interface;
import com.roger.report.vo.ReportVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportJdbcDaoImpl implements ReportDao_interface {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/fallelove?serverTimezone=Asia/Taipei";
    String userid = "root";
    String passwd = "11689dWS";

    private static final String INSERT_REPORT = "INSERT INTO report (artReplyNo, memNo, admNo, reportTime, reportTime, reportType) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String GET_ALL_REPORT = "SELECT reportNo, artReplyNo, memNo, admNo, reportTime, reportTime, reportReason, reportType FROM report";
    private static final String GET_ONE_REPORT = "SELECT reportNo, artReplyNo, memNo, admNo, reportTime, reportReason, reportType FROM report where reportNo = ?";

    private static final String DELETE = "DELETE FROM report where reportNo = ?";

    private static final String UPDATE = "UPDATE report SET reportNo = ?, artReplyNo = ?, memNo = ?, admNo = ?, reportTime = ?, reportReason = ?, reportType = ? WHERE reportNo = ?";

    @Override
    public void insert(ReportVo reportVo) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(INSERT_REPORT);

            pstmt.setInt(1, reportVo.getArtReplyNo());
            pstmt.setInt(2, reportVo.getMemNo());
            pstmt.setInt(3, reportVo.getAdmNo());
            pstmt.setTimestamp(4, reportVo.getReportTime());
            pstmt.setString(5, reportVo.getReportReason());
            pstmt.setByte(6, reportVo.getReportType());

            pstmt.executeUpdate();

            // Handle any driver errors
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. "
                    + e.getMessage());
            // Handle any SQL errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
            // Clean up JDBC resources
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }

    }

    @Override
    public void update(ReportVo reportVo) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(UPDATE);

            pstmt.setInt(1, reportVo.getArtReplyNo());
            pstmt.setInt(2, reportVo.getMemNo());
            pstmt.setInt(3, reportVo.getAdmNo());
            pstmt.setTimestamp(4, reportVo.getReportTime());
            pstmt.setString(5, reportVo.getReportReason());
            pstmt.setByte(6, reportVo.getReportType());
            pstmt.setInt(7, reportVo.getReportNo());

            pstmt.executeUpdate();

            // Handle any driver errors
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. "
                    + e.getMessage());
            // Handle any SQL errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
            // Clean up JDBC resources
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    @Override
    public void delete(Integer reportNo) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(DELETE);

            pstmt.setInt(1, reportNo);

            pstmt.executeUpdate();

            // Handle any driver errors
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. "
                    + e.getMessage());
            // Handle any SQL errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
            // Clean up JDBC resources
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }

    @Override
    public ReportVo findByPrimaryKey(Integer reportNo) {
        ReportVo reportVo = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ONE_REPORT);

            pstmt.setInt(1, reportNo);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                // reportVo 也稱為 Domain objects
                reportVo = new ReportVo();
                reportVo.setReportNo(rs.getInt("reportNo"));
                reportVo.setArtReplyNo(rs.getInt("artReplyNo"));
                reportVo.setMemNo(rs.getInt("memNo"));
                reportVo.setAdmNo(rs.getInt("admNo"));
                reportVo.setReportTime(rs.getTimestamp("reportTime"));
                reportVo.setReportReason(rs.getString("reportReason"));
                reportVo.setReportType(rs.getByte("reportType"));

            }

            // Handle any driver errors
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. "
                    + e.getMessage());
            // Handle any SQL errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
            // Clean up JDBC resources
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
        return reportVo;
    }

    @Override
    public List<ReportVo> getAll() {

        List<ReportVo> list = new ArrayList<ReportVo>();
        ReportVo reportVo = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ALL_REPORT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // ReportVo 也可以稱為 Domain objects
                reportVo = new ReportVo();
                reportVo.setReportNo(rs.getInt("reportNo"));
                reportVo.setArtReplyNo(rs.getInt("artReplyNo"));
                reportVo.setMemNo(rs.getInt("memNo"));
                reportVo.setAdmNo(rs.getInt("admNo"));
                reportVo.setReportTime(rs.getTimestamp("reportTime"));
                reportVo.setReportReason(rs.getString("reportReason"));
                reportVo.setReportType(rs.getByte("reportType"));

                list.add(reportVo);  // Store the row in the list
            }
            // Handle any driver errors
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. "
                    + e.getMessage());
            // Handle any SQL errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
            // Clean up JDBC resources
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    se.printStackTrace(System.err);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        }
        return list;
    }
}
