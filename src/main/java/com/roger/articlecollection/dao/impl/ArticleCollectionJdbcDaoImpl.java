package com.roger.articlecollection.dao.impl;

import com.roger.articlecollection.dao.ArticleCollectionDao_interface;
import com.roger.articlecollection.vo.ArticleCollectionVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleCollectionJdbcDaoImpl implements ArticleCollectionDao_interface {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/fallelove?serverTimezone=Asia/Taipei";
    String userid = "root";
    String passwd = "11689dWS";

    private static final String GET_ALL_AC = "SELECT memNo, artNo FROM articlecollection";
    private static final String GET_ONE_AC = "SELECT memNo, artNo FROM articlecollection where memNo = ?;";

    @Override
    public void insert(ArticleCollectionVo articleCollectionVo) {

    }

    @Override
    public void update(ArticleCollectionVo articleCollectionVo) {

    }

    @Override
    public void delete(Integer memNo) {

    }

    @Override
    public ArticleCollectionVo findByPrimaryKey(Integer memNo) {

        ArticleCollectionVo articleCollectionVo = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ONE_AC);

            pstmt.setInt(1, memNo);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                // ArticleCollectionVo 也稱為 Domain objects
                articleCollectionVo = new ArticleCollectionVo();

                articleCollectionVo.setMemNo(rs.getInt("memNo"));
                articleCollectionVo.setArtNo(rs.getInt("artNo"));
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
        return articleCollectionVo;
    }

    @Override
    public List<ArticleCollectionVo> getAll() {

        List<ArticleCollectionVo> list = new ArrayList<ArticleCollectionVo>();
        ArticleCollectionVo articleCollectionVo = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ALL_AC);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // ArticleCollectionVo 也可以稱為 Domain objects
                articleCollectionVo = new ArticleCollectionVo();
                articleCollectionVo.setMemNo(rs.getInt("memNo"));
                articleCollectionVo.setArtNo(rs.getInt("artNo"));

                list.add(articleCollectionVo);  // Store the row in the list
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
