package com.roger_jdbc.member.dao.impl;

import com.roger_jdbc.member.dao.MemberDao_interface;
import com.roger_jdbc.member.vo.MemberVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberJdbcDaoImpl implements MemberDao_interface {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/fallelove?serverTimezone=Asia/Taipei";
    String userid = "root";
    String passwd = "11689dWS";


    private static final String INSERT_MEB = "INSERT INTO member(mName, memAcc, memPwd, memMob, mGender, memMail, memAdd, memBd, memCard, provider, clientID, displayName, accessToken, refreshToken, tknExpireTime, creationTime, memberJoinTime, memStat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_ALL_MEB = "SELECT memNo, mName, memAcc, memPwd, memMob, mGender, memMail, memAdd, memBd, memCard, provider, clientID, displayName, accessToken, refreshToken, tknExpireTime, creationTime, memberJoinTime, memStat FROM member";
    private static final String GET_ONE_MEB = "SELECT memNo, mName, memAcc, memPwd, memMob, mGender, memMail, memAdd, memBd, memCard, provider, clientID, displayName, accessToken, refreshToken, tknExpireTime, creationTime, memberJoinTime, memStat FROM member where memNo = ?";
    private static final String GET_ONE_MEB_ON_NAME = "SELECT memNo, mName, memAcc, memPwd, memMob, mGender, memMail, memAdd, memBd, memCard, provider, clientID, displayName, accessToken, refreshToken, tknExpireTime, creationTime, memberJoinTime, memStat FROM member where mName = ?";
    private static final String GET_ONE_MEB_ON_ACCOUNT = "SELECT memNo, mName, memAcc, memPwd, memMob, mGender, memMail, memAdd, memBd, memCard, provider, clientID, displayName, accessToken, refreshToken, tknExpireTime, creationTime, memberJoinTime, memStat FROM member where memAcc = ?";

    private static final String DELETE_MEB = "DELETE FROM member where memNo = ?";

    private static final String UPDATE = "UPDATE member set mName = ?, memAcc = ?, memPwd = ?, memMob = ?, mGender = ?, memMail = ?, memAdd = ?, memBd = ?, memCard = ?, provider = ?, clientID = ?, displayName = ?, accessToken = ?, refreshToken = ?, tknExpireTime = ?, creationTime = ?, memberJoinTime = ?, memStat = ? where memNo = ?";

    private static final String CHECK_EXIST_ACCOUNT = "SELECT COUNT(*) AS count FROM member WHERE memAcc = ?;";
    private static final String CHECK_EXIST_MOBILE = "SELECT COUNT(*) AS count FROM member WHERE memMob = ?;";
    private static final String CHECK_EXIST_MAIL = "SELECT COUNT(*) AS count FROM member WHERE memMail = ?;";

    @Override
    public void insert(MemberVO memberVO) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(INSERT_MEB);

            pstmt.setString(1, memberVO.getmName());
            pstmt.setString(2, memberVO.getMemAcc());
            pstmt.setString(3, memberVO.getMemPwd());
            pstmt.setString(4, memberVO.getMemMob());
            pstmt.setByte(5, memberVO.getmGender());
            pstmt.setString(6, memberVO.getMemMail());
            pstmt.setString(7, memberVO.getMemAdd());
            pstmt.setDate(8, memberVO.getMemBd());
            pstmt.setString(9, memberVO.getMemCard());
            pstmt.setByte(10, memberVO.getProvider());
            pstmt.setString(11, memberVO.getClientID());
            pstmt.setString(12, memberVO.getDisplayName());
            pstmt.setString(13, memberVO.getAccessToken());
            pstmt.setString(14, memberVO.getRefreshToken());
            pstmt.setTimestamp(15, memberVO.getTknExpireTime());
            pstmt.setTimestamp(16, memberVO.getCreationTime());
            pstmt.setTimestamp(17, memberVO.getMemberJoinTime());
            pstmt.setByte(18, memberVO.getMemStat());

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
    public void update(MemberVO memberVO) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(UPDATE);

            pstmt.setString(1, memberVO.getmName());
            pstmt.setString(2, memberVO.getMemAcc());
            pstmt.setString(3, memberVO.getMemPwd());
            pstmt.setString(4, memberVO.getMemMob());
            pstmt.setByte(5, memberVO.getmGender());
            pstmt.setString(6, memberVO.getMemMail());
            pstmt.setString(7, memberVO.getMemAdd());
            pstmt.setDate(8, memberVO.getMemBd());
            pstmt.setString(9, memberVO.getMemCard());
            pstmt.setByte(10, memberVO.getProvider());
            pstmt.setString(11, memberVO.getClientID());
            pstmt.setString(12, memberVO.getDisplayName());
            pstmt.setString(13, memberVO.getAccessToken());
            pstmt.setString(14, memberVO.getRefreshToken());
            pstmt.setTimestamp(15, memberVO.getTknExpireTime());
            pstmt.setTimestamp(16, memberVO.getCreationTime());
            pstmt.setTimestamp(17, memberVO.getMemberJoinTime());
            pstmt.setByte(18, memberVO.getMemStat());
            pstmt.setInt(19, memberVO.getMemNo());

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
    public void delete(Integer memNo) {
        int updateCount_EMPs = 0;

        Connection con = null;
        PreparedStatement pstmt = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);

            // 刪除員工
            pstmt = con.prepareStatement(DELETE_MEB);
            pstmt.setInt(1, memNo);

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
    public MemberVO findByPrimaryKey(Integer memNo) {

        MemberVO memberVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ONE_MEB);

            pstmt.setInt(1, memNo);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                // MemberVO 也稱為 Domain objects
                memberVO = new MemberVO();
                memberVO.setMemNo(rs.getInt("memNo"));
                memberVO.setmName(rs.getString("mName"));
                memberVO.setMemAcc(rs.getString("memAcc"));
                memberVO.setMemPwd(rs.getString("memPwd"));
                memberVO.setMemMob(rs.getString("memMob"));
                memberVO.setmGender(rs.getByte("mGender"));
                memberVO.setMemMail(rs.getString("memMail"));
                memberVO.setMemAdd(rs.getString("memAdd"));
                memberVO.setMemBd(rs.getDate("memBd"));
                memberVO.setMemCard(rs.getString("memCard"));
                memberVO.setProvider(rs.getByte("provider"));
                memberVO.setClientID(rs.getString("clientID"));
                memberVO.setDisplayName(rs.getString("displayName"));
                memberVO.setAccessToken(rs.getString("accessToken"));
                memberVO.setRefreshToken(rs.getString("refreshToken"));
                memberVO.setTknExpireTime(rs.getTimestamp("tknExpireTime"));
                memberVO.setCreationTime(rs.getTimestamp("creationTime"));
                memberVO.setMemberJoinTime(rs.getTimestamp("memberJoinTime"));
                memberVO.setMemStat(rs.getByte("memStat"));

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
        return memberVO;
    }

    @Override
    public MemberVO findByName(String mName) {

        MemberVO memberVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ONE_MEB_ON_NAME);

            pstmt.setString(1, mName);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                // MemberVO 也稱為 Domain objects
                memberVO = new MemberVO();
                memberVO.setMemNo(rs.getInt("memNo"));
                memberVO.setmName(rs.getString("mName"));
                memberVO.setMemAcc(rs.getString("memAcc"));
                memberVO.setMemPwd(rs.getString("memPwd"));
                memberVO.setMemMob(rs.getString("memMob"));
                memberVO.setmGender(rs.getByte("mGender"));
                memberVO.setMemMail(rs.getString("memMail"));
                memberVO.setMemAdd(rs.getString("memAdd"));
                memberVO.setMemBd(rs.getDate("memBd"));
                memberVO.setMemCard(rs.getString("memCard"));
                memberVO.setProvider(rs.getByte("provider"));
                memberVO.setClientID(rs.getString("clientID"));
                memberVO.setDisplayName(rs.getString("displayName"));
                memberVO.setAccessToken(rs.getString("accessToken"));
                memberVO.setRefreshToken(rs.getString("refreshToken"));
                memberVO.setTknExpireTime(rs.getTimestamp("tknExpireTime"));
                memberVO.setCreationTime(rs.getTimestamp("creationTime"));
                memberVO.setMemberJoinTime(rs.getTimestamp("memberJoinTime"));
                memberVO.setMemStat(rs.getByte("memStat"));

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
        return memberVO;
    }

    @Override
    public MemberVO findByAccount(String memAcc) {

        MemberVO memberVO = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ONE_MEB_ON_ACCOUNT);

            pstmt.setString(1, memAcc);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                // MemberVO 也稱為 Domain objects
                memberVO = new MemberVO();
                memberVO.setMemNo(rs.getInt("memNo"));
                memberVO.setmName(rs.getString("mName"));
                memberVO.setMemAcc(rs.getString("memAcc"));
                memberVO.setMemPwd(rs.getString("memPwd"));
                memberVO.setMemMob(rs.getString("memMob"));
                memberVO.setmGender(rs.getByte("mGender"));
                memberVO.setMemMail(rs.getString("memMail"));
                memberVO.setMemAdd(rs.getString("memAdd"));
                memberVO.setMemBd(rs.getDate("memBd"));
                memberVO.setMemCard(rs.getString("memCard"));
                memberVO.setProvider(rs.getByte("provider"));
                memberVO.setClientID(rs.getString("clientID"));
                memberVO.setDisplayName(rs.getString("displayName"));
                memberVO.setAccessToken(rs.getString("accessToken"));
                memberVO.setRefreshToken(rs.getString("refreshToken"));
                memberVO.setTknExpireTime(rs.getTimestamp("tknExpireTime"));
                memberVO.setCreationTime(rs.getTimestamp("creationTime"));
                memberVO.setMemberJoinTime(rs.getTimestamp("memberJoinTime"));
                memberVO.setMemStat(rs.getByte("memStat"));

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
        return memberVO;
    }

    @Override
    public List<MemberVO> getAll() {

        List<MemberVO> list = new ArrayList<MemberVO>();
        MemberVO memberVO = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(GET_ALL_MEB);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // MemberVO 也可以稱為 Domain objects
                memberVO = new MemberVO();
                memberVO.setMemNo(rs.getInt("memNo"));
                memberVO.setmName(rs.getString("mName"));
                memberVO.setMemAcc(rs.getString("memAcc"));
                memberVO.setMemPwd(rs.getString("memPwd"));
                memberVO.setMemMob(rs.getString("memMob"));
                memberVO.setmGender(rs.getByte("mGender"));
                memberVO.setMemMail(rs.getString("memMail"));
                memberVO.setMemAdd(rs.getString("memAdd"));
                memberVO.setMemBd(rs.getDate("memBd"));
                memberVO.setMemCard(rs.getString("memCard"));
                memberVO.setProvider(rs.getByte("provider"));
                memberVO.setClientID(rs.getString("clientID"));
                memberVO.setDisplayName(rs.getString("displayName"));
                memberVO.setAccessToken(rs.getString("accessToken"));
                memberVO.setRefreshToken(rs.getString("refreshToken"));
                memberVO.setTknExpireTime(rs.getTimestamp("tknExpireTime"));
                memberVO.setCreationTime(rs.getTimestamp("creationTime"));
                memberVO.setMemberJoinTime(rs.getTimestamp("memberJoinTime"));
                memberVO.setMemStat(rs.getByte("memStat"));

                list.add(memberVO);  // Store the row in the list
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
    public boolean isExistingMemberAccount(String memAcc) {

        boolean isExistingMemberAccount = false;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(CHECK_EXIST_ACCOUNT);

            pstmt.setString(1, memAcc);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");

                // false -> true
                isExistingMemberAccount = count > 0;
            }

        }catch (ClassNotFoundException e) {
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
        return isExistingMemberAccount;
    }

    @Override
    public boolean isExistingMemberMobile(String memMob) {

        boolean isExistingMemberMobile = false;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(CHECK_EXIST_MOBILE);

            pstmt.setString(1, memMob);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");

                // false -> true
                isExistingMemberMobile = count > 0;
            }

        }catch (ClassNotFoundException e) {
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
        return isExistingMemberMobile;
    }

    @Override
    public boolean isExistingMemberMail(String memMail) {

        boolean isExistingMemberMail = false;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            pstmt = con.prepareStatement(CHECK_EXIST_MAIL);

            pstmt.setString(1, memMail);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");

                // false -> true
                isExistingMemberMail = count > 0;
            }

        }catch (ClassNotFoundException e) {
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
        return isExistingMemberMail;
    }
}
