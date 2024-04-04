package dao.Impl;

import VO.MemberVO;
import VO.NoticeVO;
import dao.NoticeDao_interface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NoticeJdbcDaoImpl implements NoticeDao_interface {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/fallelove?serverTimezone=Asia/Taipei";
    String userid = "root";
    String passwd = "11689dWS";

    private static final String INSERT_NO = "INSERT INTO notice (memNo, notContent, notTime, notStat) VALUES (?, ?, ?, ?)";
    private static final String GET_ALL_NO = "SELECT notNo , memNo, notContent, notTime, notStat FROM notice";
    private static final String GET_ONE_NO = "SELECT notNo , memNo, notContent, notTime, notStat FROM notice = ?";
    private static final String GET_NO_ByMemNo_MEM = "SELECT notNo , memNo, notContent, notTime, notStat FROM notice where notice = ? order by memNo";

    private static final String DELETE_NO = "DELETE FROM notice where notNo = ?";
    private static final String DELETE_MEM = "DELETE FROM member where memNo = ?";

    private static final String UPDATE = "UPDATE notice set memNo = ?, notContent = ?, notTime = ?, notStat = ? where notNo = ?";


    @Override
    public void insert(NoticeVO noticeVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(INSERT_NO);

            pstmt.setInt(1, noticeVO.getMemNo());
            pstmt.setString(2, noticeVO.getNotContent());
            pstmt.setTimestamp(3, noticeVO.getNotTime());
            pstmt.setByte(4, noticeVO.getNotStat());

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
    public void update(NoticeVO noticeVO) {

    }

    @Override
    public void delete(Integer notNo) {

    }

    @Override
    public NoticeVO findByPrimaryKey(Integer notNo) {
        return null;
    }

    @Override
    public List<NoticeVO> getAll() {

        List<NoticeVO> list = new ArrayList<NoticeVO>();
        NoticeVO noticeVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ALL_NO);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // NoticeVO 也可以稱為 Domain objects
                noticeVO = new NoticeVO();
                noticeVO.setNotNo(rs.getInt("notNo"));
                noticeVO.setMemNo(rs.getInt("memNo"));
                noticeVO.setNotContent(rs.getString("notContent"));
                noticeVO.setNotTime(rs.getTimestamp("notTime"));
                noticeVO.setNotStat(rs.getByte("notStat"));
                list.add(noticeVO);  // Store the row in the list
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

    @Override
    public Set<MemberVO> getEmpsByDeptno(Integer notNo) {
        return null;
    }
}
