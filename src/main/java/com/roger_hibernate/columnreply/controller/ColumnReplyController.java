package com.roger_hibernate.columnreply.controller;

import com.roger_hibernate.columnreply.service.ColumnReplyService;
import com.roger_hibernate.columnreply.vo.ColumnReplyVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/columnreply/ColumnReplyController")
public class ColumnReplyController extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if ("insert".equals(action)) { // 來自addCR.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
            Integer artNo = null;
            try {
                artNo = Integer.valueOf(req.getParameter("artNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("artNo", "文章編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("artNo", "文章編號請不要留白");
            }

            Integer memNo = null;
            try {
                memNo = Integer.valueOf(req.getParameter("memNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("memNo", "會員編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("memNo", "會員編號請不要留白");
            }

            String comContent = req.getParameter("comContent");
            String comContentReg = "^[\u4e00-\u9fa5，。、；：！？（）【】「」『』《》……,.：；！？（）]{1,255}$";
            if (comContent == null || comContent.trim().length() == 0) {
                errorMsgs.put("notContent", "通知內容: 請勿空白");
            } else if (!comContent.trim().matches(comContentReg)) {
                errorMsgs.put("notContent", "通知內容: 請勿填寫中文以外的內容，且在255字內");
            }

            Instant currentTime = Instant.now();
            Timestamp comTime = Timestamp.from(currentTime);
            try {
                comTime = Timestamp.valueOf(req.getParameter("comTime").trim());
            } catch (IllegalArgumentException e) {
                errorMsgs.put("comTime", "留言時間請輸入日期以及時間");
            }

            Byte comStat = 0;
            try {
                comStat = Byte.valueOf(req.getParameter("comStat").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("comStat", "留言狀態請填數字");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/columnreply/addCR.jsp");
                failureView.forward(req, res);
                return;
            }

            /***************************2.開始新增資料***************************************/
            ColumnReplyService columnReplyService = new ColumnReplyService();
            columnReplyService.addCR(artNo, memNo, comContent, comTime, comStat);

            /***************************3.新增完成,準備轉交(Send the Success view)***********/
            String url = "/columnreply/listAllCR.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllCR.jsp
            successView.forward(req, res);
        }

        if ("delete".equals(action)) { // 來自listAllCR.jsp

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數***************************************/
            Integer columnReplyNo = Integer.valueOf(req.getParameter("columnReplyNo"));

            /***************************2.開始刪除資料***************************************/
            ColumnReplyService columnReplyService = new ColumnReplyService();
            columnReplyService.deleteCR(columnReplyNo);

            /***************************3.刪除完成,準備轉交(Send the Success view)***********/
            String url = "/columnreply/listAllCR.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 刪除成功，轉交回送出刪除的來源網站
            successView.forward(req, res);
        }

        if ("update".equals(action)) { // 來自update_notice_input.jsp的請求

            Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
            Integer columnReplyNo = null;
            try {
                columnReplyNo = Integer.valueOf(req.getParameter("columnReplyNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("columnReplyNo", "文章回覆編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("columnReplyNo", "文章回覆編號請不要留白");
            }

            Integer artNo = null;
            try {
                artNo = Integer.valueOf(req.getParameter("artNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("artNo", "文章編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("artNo", "文章編號請不要留白");
            }

            Integer memNo = null;
            try {
                memNo = Integer.valueOf(req.getParameter("memNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("memNo", "會員編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("memNo", "會員編號請不要留白");
            }

            String comContent = req.getParameter("comContent");
            String comContentReg = "^[\u4e00-\u9fa5，。、；：！？（）【】「」『』《》……,.：；！？（）]{1,255}$";
            if (comContent == null || comContent.trim().length() == 0) {
                errorMsgs.put("notContent", "通知內容: 請勿空白");
            } else if (!comContent.trim().matches(comContentReg)) {
                errorMsgs.put("notContent", "通知內容: 請勿填寫中文以外的內容，且在255字內");
            }

            Instant currentTime = Instant.now();
            Timestamp comTime = Timestamp.from(currentTime);
            try {
                comTime = Timestamp.valueOf(req.getParameter("comTime").trim());
            } catch (IllegalArgumentException e) {
                errorMsgs.put("comTime", "留言時間請輸入日期以及時間");
            }

            Byte comStat = 0;
            try {
                comStat = Byte.valueOf(req.getParameter("comStat").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("comStat", "留言狀態請填數字");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/columnreply/addCR.jsp");
                failureView.forward(req, res);
                return;
            }

            /***************************2.開始修改資料*****************************************/
            ColumnReplyService columnReplyService = new ColumnReplyService();
            ColumnReplyVO columnReplyVo = columnReplyService.updateCR(columnReplyNo, artNo, memNo, comContent, comTime, comStat);

            /***************************3.修改完成,準備轉交(Send the Success view)*************/
            req.setAttribute("columnReplyVo", columnReplyVo); // 資料庫update成功後，正確的columnReplyVo物件，存入req
            String url = "/columnreply/listOneCR.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url);
            successView.forward(req, res);

        }

        if ("getOne_For_Display".equals(action)) { // 來自listAllNO.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
            Integer columnReplyNo = null;
            try {
                columnReplyNo = Integer.valueOf(req.getParameter("columnReplyNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("columnReplyNo", "文章回覆編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("columnReplyNo", "文章回覆編號請不要留白");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/columnreply/select_page.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************2.開始查詢資料*****************************************/
            ColumnReplyService columnReplyService = new ColumnReplyService();
            ColumnReplyVO columnReplyVo = columnReplyService.getOneCR(columnReplyNo);
            if (columnReplyVo == null) {
                errorMsgs.put("columnReplyNo", "查無資料");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/columnreply/select_page.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }
            /***************************3.查詢完成,準備轉交(Send the Success view)*************/
            req.setAttribute("columnReplyVo", columnReplyVo); // 資料庫取出的columnReplyVo物件,存入req
            String url = "/columnreply/listOneCR.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneCR.jsp
            successView.forward(req, res);
        }

        if ("getAll".equals(action)) { // 修改为查询全部的请求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************2.開始查詢資料*****************************************/
            ColumnReplyService columnReplyService = new ColumnReplyService();
            List<ColumnReplyVO> columnReplyList = columnReplyService.getAll(); // 調用服務類的方法查詢全部資料

            if (columnReplyList.isEmpty()) {
                errorMsgs.put("result", "查無資料"); // 如果結果為空，設置錯誤消息
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req.getRequestDispatcher("/columnreply/select_page.jsp");
                failureView.forward(req, res);
                return; // 程序中斷
            }

            /***************************3.查詢完成,準備轉交(Send the Success view)*************/
            req.setAttribute("columnReplyList", columnReplyList); // 將查詢到的通知消息列表存入請求屬性中
            String url = "/columnreply/listAllCR.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉發到 listAllCR.jsp 頁面
            successView.forward(req, res);
        }
    }
}
