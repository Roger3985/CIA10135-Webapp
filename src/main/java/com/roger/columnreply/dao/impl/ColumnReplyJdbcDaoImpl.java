package com.roger.columnreply.dao.impl;

import com.roger.columnreply.dao.ColumnReplyDao_interface;
import com.roger.columnreply.vo.ColumnReplyVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColumnReplyJdbcDaoImpl implements ColumnReplyDao_interface {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/fallelove?serverTimezone=Asia/Taipei";
    String userid = "root";
    String passwd = "11689dWS";

    private static final String INSERT_CR = "INSERT INTO columnreply (artNo, memNo, comContent, comTime, comStat) VALUES (?, ?, ?, ?, ?)";

    private static final String GET_ALL_CR = "SELECT columnReplyNo, artNo, memNo, comContent, comTime, comStat FROM columnreply";
    private static final String GET_ONE_CR = "SELECT columnReplyNo, artNo, memNo, comContent, comTime, comStat FROM columnreply where columnReplyNo = ?";

    private static final String DELETE = "DELETE FROM columnreply where columnReplyNo = ?";


    @Override
    public void insert(ColumnReplyVo columnReplyVo) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(INSERT_CR);

            pstmt.setInt(1, columnReplyVo.getArtNo());
            pstmt.setInt(2, columnReplyVo.getMemNo());
            pstmt.setString(3, columnReplyVo.getComContent());
            pstmt.setTimestamp(4, columnReplyVo.getComTime());
            pstmt.setByte(5, columnReplyVo.getComStat());

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
    public void update(ColumnReplyVo columnReplyVo) {

    }

    @Override
    public void delete(Integer columnReplyNo) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(DELETE);

            pstmt.setInt(1, columnReplyNo);

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
    public ColumnReplyVo findByPrimaryKey(Integer columnReplyNo) {

        ColumnReplyVo columnReplyVo = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ONE_CR);

            pstmt.setInt(1, columnReplyNo);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                // ColumnReplyVo 也可以稱為 Domain objects
                columnReplyVo = new ColumnReplyVo();
                columnReplyVo.setColumnReplyNo(rs.getInt("columnReplyNo"));
                columnReplyVo.setArtNo(rs.getInt("artNo"));
                columnReplyVo.setMemNo(rs.getInt("memNo"));
                columnReplyVo.setComContent(rs.getString("comContent"));
                columnReplyVo.setComTime(rs.getTimestamp("comTime"));
                columnReplyVo.setComStat(rs.getByte("comStat"));

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
        return columnReplyVo;
    }

    @Override
    public List<ColumnReplyVo> getAll() {

        List<ColumnReplyVo> list = new ArrayList<ColumnReplyVo>();
        ColumnReplyVo columnReplyVo = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ALL_CR);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // ColumnReplyVo 也可以稱為 Domain objects
                columnReplyVo = new ColumnReplyVo();
                columnReplyVo.setColumnReplyNo(rs.getInt("columnReplyNo"));
                columnReplyVo.setArtNo(rs.getInt("artNo"));
                columnReplyVo.setMemNo(rs.getInt("memNo"));
                columnReplyVo.setComContent(rs.getString("comContent"));
                columnReplyVo.setComTime(rs.getTimestamp("comTime"));
                columnReplyVo.setComStat(rs.getByte("comStat"));
                list.add(columnReplyVo);  // Store the row in the list
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
