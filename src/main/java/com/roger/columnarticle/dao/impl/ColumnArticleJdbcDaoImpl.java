package com.roger.columnarticle.dao.impl;

import com.roger.columnarticle.dao.ColumnArticleDao_interface;
import com.roger.columnarticle.vo.ColumnArticleVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ColumnArticleJdbcDaoImpl implements ColumnArticleDao_interface {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/fallelove?serverTimezone=Asia/Taipei";
    String userid = "root";
    String passwd = "11689dWS";

    private static final String INSERT_CA = "INSERT INTO columnarticle (admNo, artTitle, artContent, artTime, artCatNo, artStat) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String GET_ALL_CA = "SELECT artNo, admNo, artTitle, artContent, artTime, artCatNo, artStat FROM columnarticle";
    private static final String GET_ONE_CA = "SELECT artNo, admNo, artTitle, artContent, artTime, artCatNo, artStat FROM columnarticle where artNo = ?";

    private static final String DELETE = "DELETE FROM columnarticle where artNo = ?";

    private static final String UPDATE = "UPDATE columnarticle SET artNo = ?, admNo = ?, artTitle = ?, artContent = ?, artTime = ?, artCatNo = ?, artStat = ? WHERE artNo = ?";


    @Override
    public void insert(ColumnArticleVo columnArticleVo) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(INSERT_CA);

            pstmt.setInt(1, columnArticleVo.getAdmNo());
            pstmt.setString(2, columnArticleVo.getArtTitle());
            pstmt.setString(3, columnArticleVo.getArtContent());
            pstmt.setTimestamp(4, columnArticleVo.getArtTime());
            pstmt.setInt(5, columnArticleVo.getArtCatNo());
            pstmt.setByte(6, columnArticleVo.getArtStat());

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
    public void update(ColumnArticleVo columnArticleVo) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(UPDATE);

            pstmt.setInt(1, columnArticleVo.getAdmNo());
            pstmt.setString(2, columnArticleVo.getArtTitle());
            pstmt.setString(3, columnArticleVo.getArtContent());
            pstmt.setTimestamp(4, columnArticleVo.getArtTime());
            pstmt.setInt(5, columnArticleVo.getArtCatNo());
            pstmt.setByte(6, columnArticleVo.getArtStat());
            pstmt.setInt(7, columnArticleVo.getArtNo());

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
    public void delete(Integer artNo) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(DELETE);

            pstmt.setInt(1, artNo);

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
    public ColumnArticleVo findByPrimaryKey(Integer artNo) {

        ColumnArticleVo columnArticleVo = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ONE_CA);

            pstmt.setInt(1, artNo);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                // ColumnArticleVo 也可以稱為 Domain objects
                columnArticleVo = new ColumnArticleVo();
                columnArticleVo.setArtNo(rs.getInt("artNo"));
                columnArticleVo.setAdmNo(rs.getInt("admNo"));
                columnArticleVo.setArtTitle(rs.getString("artTitle"));
                columnArticleVo.setArtContent(rs.getString("artContent"));
                columnArticleVo.setArtTime(rs.getTimestamp("artTime"));
                columnArticleVo.setArtCatNo(rs.getInt("artCatNo"));
                columnArticleVo.setArtStat(rs.getByte("artStat"));

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
        return columnArticleVo;
    }

    @Override
    public List<ColumnArticleVo> getAll() {

        List<ColumnArticleVo> list = new ArrayList<ColumnArticleVo>();
        ColumnArticleVo columnArticleVo = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ALL_CA);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // ColumnArticleVo 也可以稱為 Domain objects
                columnArticleVo = new ColumnArticleVo();
                columnArticleVo.setArtNo(rs.getInt("artNo"));
                columnArticleVo.setAdmNo(rs.getInt("admNo"));
                columnArticleVo.setArtTitle(rs.getString("artTitle"));
                columnArticleVo.setArtContent(rs.getString("artContent"));
                columnArticleVo.setArtTime(rs.getTimestamp("artTime"));
                columnArticleVo.setArtCatNo(rs.getInt("artCatNo"));
                columnArticleVo.setArtStat(rs.getByte("artStat"));
                list.add(columnArticleVo);  // Store the row in the list
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
