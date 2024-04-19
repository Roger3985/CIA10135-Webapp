package com.ren.product.dao;

import com.ren.product.model.ProductVO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductJDBCDAOImpl implements ProductDAO_interface {

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/fallelove?serverTimezone=Asia/Taipei";
    String userid = "root";
    String passwd = "SaiKou97607";

    // 新增商品
    private static final String INSERT_STMT =
            "INSERT INTO product (pCatNo,pName,pInfo,pSize,pColor,pPrice,pStat,pSalQty,pComPeople,pComScore) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    // 查詢單一品項
    private static final String GET_ONE_STMT =
            "SELECT pNo,pCatNo,pName,pInfo,pSize,pColor,pPrice,pStat,pSalQty,pComPeople,pComScore FROM product WHERE pNo = ?";
    // 查詢全部
    private static final String GET_ALL_STMT =
            "SELECT pNo,pCatNo,pName,pInfo,pSize,pColor,pPrice,pStat,pSalQty,pComPeople,pComScore FROM product ORDER BY pNo";
    // 修改商品資料
    private static final String UPDATE_STMT =
            "UPDATE product SET pCatNo=?, pName=?, pInfo=?, pSize=?, pColor=?, pPrice=?, pStat=?, pSalQty=?, pComPeople=?, pComScore=? WHERE pNo = ?";
    // 刪除所有參照商品的表格
    // 刪除商品訂單明細
    private static final String DELETE_PRODUCTORDERDETAILS_STMT=
            "DELETE FROM ProductOrderDetail WHERE pNo = ?";
    // 刪除商品我的最愛
    private static final String DELETE_PRODUCTMYFAVORITE_STMT=
            "DELETE FROM ProductMyFavorite WHERE pNo = ?";
    // 刪除商品購物車清單
    private static final String DELETE_CART_STMT =
            "DELETE FROM cart WHERE pNo = ?";
    // 刪除商品照片
    private static final String DELETE_PRODUCTPICTURE_STMT =
            "DELETE FROM ProductPicture WHERE pNo = ?";
    // 刪除商品
    private static final String DELETE_PRODUCT_STMT =
            "DELETE FROM product WHERE pNo = ?";

    @Override
    public void insert(ProductVO productVO) {

        try (Connection con = DriverManager.getConnection(url, userid, passwd);
             PreparedStatement ps = con.prepareStatement(INSERT_STMT)) {
            // 載入Driver介面的實作類別.class檔來註冊JDBC
            Class.forName(driver);
            // 從request的VO取值放入PreparedStatement
            ps.setInt(1, productVO.getpCatNo());
            ps.setString(2, productVO.getpName());
            ps.setString(3, productVO.getpInfo());
            ps.setInt(4, productVO.getpSize());
            ps.setString(5, productVO.getpColor());
            ps.setBigDecimal(6, productVO.getpPrice());
            ps.setByte(7, productVO.getpStat());
            ps.setInt(8, productVO.getpSalQty());
            ps.setInt(9, productVO.getpComPeople());
            ps.setInt(10, productVO.getpComScore());
            // 執行SQL指令將VO資料新增進資料庫
            ps.executeUpdate();
            // Handle any driver errors
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
            // Handle any SQL errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. " + se.getMessage());
        }
    }

    @Override
    public ProductVO findByPrimaryKey(Integer pNo) {
        // 宣告VO並指定空值，若查詢無結果會出現空值，後續於Controller作錯誤處理
        ProductVO productVO = null;
        // ResultSet在相關的Statement關閉時會自動關閉，因此不用另外寫在Auto-closable
        try (Connection con = DriverManager.getConnection(url, userid, passwd);
             PreparedStatement ps = con.prepareStatement(GET_ONE_STMT)) {
            // 載入Driver介面的實作類別.class檔來註冊JDBC
            Class.forName(driver);
            // 將request的商品編號放入SQL
            ps.setInt(1, pNo);
            // 執行SQL查詢並得到ResultSet物件
            ResultSet rs = ps.executeQuery();
            // 取出ResultSet內資料放入VO
            while (rs.next()) {
                productVO = new ProductVO();
                productVO.setpNo(rs.getInt("pNo"));
                productVO.setpCatNo(rs.getInt("pCatNo"));
                productVO.setpName(rs.getString("pName"));
                productVO.setpInfo(rs.getString("pInfo"));
                productVO.setpSize(rs.getInt("pSize"));
                productVO.setpColor(rs.getString("pColor"));
                productVO.setpPrice(rs.getBigDecimal("pPrice"));
                productVO.setpStat(rs.getByte("pStat"));
                productVO.setpSalQty(rs.getInt("pSalQty"));
                productVO.setpComPeople(rs.getInt("pComPeople"));
                productVO.setpComScore(rs.getInt("pComScore"));
            }
            // Handle any driver errors
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
            // Handle any SQL errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. " + se.getMessage());
        }
        // 回傳VO，待後續Controller導至View呈現
        return productVO;
    }

    @Override
    public List<ProductVO> getAll() {
        // 宣告ArrayList作為放入搜尋結果的列表
        List<ProductVO> list = new ArrayList<>();
        // 宣告VO並指定空值，若查詢無結果會出現空值，後續於Controller作錯誤處理
        ProductVO productVO = null;
        try (Connection con = DriverManager.getConnection(url, userid, passwd);
             PreparedStatement ps = con.prepareStatement(GET_ALL_STMT)) {
            // 載入Driver介面的實作類別.class檔來註冊JDBC
            Class.forName(driver);
            // 執行SQL查詢並得到ResultSet物件
            ResultSet rs = ps.executeQuery();
            // 新增VO物件，取出ResultSet內資料放入VO
            while (rs.next()) {
                productVO = new ProductVO();
                productVO.setpNo(rs.getInt("pNo"));
                productVO.setpCatNo(rs.getInt("pCatNo"));
                productVO.setpName(rs.getString("pName"));
                productVO.setpInfo(rs.getString("pInfo"));
                productVO.setpSize(rs.getInt("pSize"));
                productVO.setpColor(rs.getString("pColor"));
                productVO.setpPrice(rs.getBigDecimal("pPrice"));
                productVO.setpStat(rs.getByte("pStat"));
                productVO.setpSalQty(rs.getInt("pSalQty"));
                productVO.setpComPeople(rs.getInt("pComPeople"));
                productVO.setpComScore(rs.getInt("pComScore"));
                list.add(productVO); // 將資料新增至列表內之後作為搜尋結果返回給View
            }
            // Handle any driver errors
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
            // Handle any SQL errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. " + se.getMessage());
        }
        return list;
    }

    @Override
    public void update(ProductVO productVO) {

        try (Connection con = DriverManager.getConnection(url, userid, passwd);
             PreparedStatement ps = con.prepareStatement(UPDATE_STMT)) {
            // 載入Driver介面的實作類別.class檔來註冊JDBC
            Class.forName(driver);
            // 從request的VO取值放入PreparedStatement
            ps.setInt(1, productVO.getpCatNo());
            ps.setString(2, productVO.getpName());
            ps.setString(3, productVO.getpInfo());
            ps.setInt(4, productVO.getpSize());
            ps.setString(5, productVO.getpColor());
            ps.setBigDecimal(6, productVO.getpPrice());
            ps.setByte(7, productVO.getpStat());
            ps.setInt(8, productVO.getpSalQty());
            ps.setInt(9, productVO.getpComPeople());
            ps.setInt(10, productVO.getpComScore());
            ps.setInt(11, productVO.getpNo());
            // 執行SQL指令將資料庫內對應的資料修改成VO的值
            ps.executeUpdate();
            // Handle any driver errors
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
            // Handle any SQL errors
        } catch (SQLException se) {
            throw new RuntimeException("A database error occured. " + se.getMessage());
        }
    }

    @Override
    public void delete(Integer pNo) {

        Connection con = null;
        PreparedStatement ps = null;

        try {
            // 載入Driver介面的實作類別.class檔來註冊JDBC
            Class.forName(driver);
            con = DriverManager.getConnection(url, userid, passwd);
            // 設定於 pstmt.executeUpdate()之前
            con.setAutoCommit(false);
            // 刪除商品訂單明細
            ps = con.prepareStatement(DELETE_PRODUCTORDERDETAILS_STMT);
            ps.setInt(1, pNo);
            ps.executeUpdate();
            // 刪除商品我的最愛
            ps = con.prepareStatement(DELETE_PRODUCTMYFAVORITE_STMT);
            ps.setInt(1, pNo);
            ps.executeUpdate();
            // 刪除商品購物車清單
            ps = con.prepareStatement(DELETE_CART_STMT);
            ps.setInt(1, pNo);
            ps.executeUpdate();
            // 刪除商品照片
            ps = con.prepareStatement(DELETE_PRODUCTPICTURE_STMT);
            ps.setInt(1, pNo);
            ps.executeUpdate();
            // 終於可以刪商品了
            ps = con.prepareStatement(DELETE_PRODUCT_STMT);
            ps.setInt(1, pNo);
            ps.executeUpdate();
            // 設定於 pstmt.executeUpdate()之後
            con.commit();
            con.setAutoCommit(true);
            // Handle any driver errors
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't load database driver. "
                    + e.getMessage());
            // Handle any SQL errors
        } catch (SQLException se) {
            if (con != null) {
                try {
                    // .rollback()設定於當有exception發生時之catch區塊內
                    con.rollback();
                } catch (SQLException excep) {
                    throw new RuntimeException("rollback error occured. "
                            + excep.getMessage());
                }
            }
            throw new RuntimeException("A database error occured. "
                    + se.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
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

    public static void main(String[] args) {

        ProductJDBCDAOImpl dao = new ProductJDBCDAOImpl();

        // 新增
        ProductVO productVO1 = new ProductVO();
        productVO1.setpCatNo(Integer.valueOf(1644));
        productVO1.setpName("男士襯衫");
        productVO1.setpInfo("舒適且時尚的男士襯衫");
        productVO1.setpSize(Integer.valueOf(2));
        productVO1.setpColor("藍色");
        productVO1.setpPrice(new BigDecimal("30"));
        productVO1.setpStat(Byte.valueOf("1"));
        productVO1.setpSalQty(Integer.valueOf(1000));
        productVO1.setpComPeople(Integer.valueOf(500));
        productVO1.setpComScore(Integer.valueOf(2));
        dao.insert(productVO1);

        // 修改
        ProductVO productVO2 = new ProductVO();
        productVO2.setpCatNo(Integer.valueOf(1644));
        productVO2.setpName("男士襯衫");
        productVO2.setpInfo("舒適且時尚的男士襯衫");
        productVO2.setpSize(Integer.valueOf(2));
        productVO2.setpColor("藍色");
        productVO2.setpPrice(new BigDecimal("30"));
        productVO2.setpStat(Byte.valueOf("1"));
        productVO2.setpSalQty(Integer.valueOf(1000));
        productVO2.setpComPeople(Integer.valueOf(500));
        productVO2.setpComScore(Integer.valueOf(2));
        productVO2.setpNo(Integer.valueOf(1600000));
        dao.update(productVO2);

        // 刪除
        dao.delete(1645958);

        // 查詢
        ProductVO productVO3 = dao.findByPrimaryKey(1645958);
        System.out.print(productVO3.getpNo() + ",");
        System.out.print(productVO3.getpCatNo() + ",");
        System.out.print(productVO3.getpName() + ",");
        System.out.print(productVO3.getpInfo() + ",");
        System.out.print(productVO3.getpSize() + ",");
        System.out.print(productVO3.getpColor() + ",");
        System.out.println(productVO3.getpPrice() + ",");
        System.out.print(productVO3.getpStat() + ",");
        System.out.print(productVO3.getpSalQty() + ",");
        System.out.print(productVO3.getpComPeople() + ",");
        System.out.println(productVO3.getpComScore());
        System.out.println("---------------------");

        // 查詢
        List<ProductVO> list = dao.getAll();
        for (ProductVO aProduct : list) {
            System.out.print(aProduct.getpNo() + ",");
            System.out.print(aProduct.getpCatNo() + ",");
            System.out.print(aProduct.getpName() + ",");
            System.out.print(aProduct.getpInfo() + ",");
            System.out.print(aProduct.getpSize() + ",");
            System.out.print(aProduct.getpColor() + ",");
            System.out.print(aProduct.getpPrice() + ",");
            System.out.print(aProduct.getpStat() + ",");
            System.out.print(aProduct.getpSalQty() + ",");
            System.out.print(aProduct.getpComPeople() + ",");
            System.out.print(aProduct.getpComScore());
            System.out.println();
        }
    }
}
