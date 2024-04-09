package com.roger.report.controller;

import com.roger.report.service.ReportService;
import com.roger.report.vo.ReportVo;

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

@WebServlet("/report/ReportController")
public class ReportController extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if ("insert".equals(action)) { // 來自addNO.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
            Integer artReplyNo = null;
            try {
                artReplyNo = Integer.valueOf(req.getParameter("artReplyNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("artReplyNo", "文章回覆編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("artReplyNo", "文章回覆編號請不要留白");
            }

            Integer memNo = null;
            try {
                memNo = Integer.valueOf(req.getParameter("memNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("memNo", "會員編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("memNo", "會員編號請不要留白");
            }

            Integer admNo = null;
            try {
                admNo = Integer.valueOf(req.getParameter("admNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("admNo", "管理員編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("admNo", "管理員編號請不要留白");
            }

            Instant currentTime = Instant.now();
            Timestamp reportTime = Timestamp.from(currentTime);
            try {
                reportTime = Timestamp.valueOf(req.getParameter("reportTime").trim());
            } catch (IllegalArgumentException e) {
                errorMsgs.put("reportTime", "檢舉時間請輸入日期以及時間");
            }

            String reportReason = req.getParameter("reportReason");
            String reportReasonReg = "^[\u4e00-\u9fa5，。、；：！？（）【】「」『』《》……,.：；！？（）]{1,300}$";
            if (reportReason == null || reportReason.trim().length() == 0) {
                errorMsgs.put("reportReason", "通知內容: 請勿空白");
            } else if (!reportReason.trim().matches(reportReasonReg)) {
                errorMsgs.put("reportReason", "通知內容: 請勿填寫中文以外的內容，且在300字內");
            }

            Byte reportType = 0;
            try {
                reportType = Byte.valueOf(req.getParameter("reportType").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("reportType", "讀取狀態請填數字");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/report/addReport.jsp");
                failureView.forward(req, res);
                return;
            }

            /***************************2.開始新增資料***************************************/
            ReportService reportService = new ReportService();
            reportService.addReport(artReplyNo, memNo, admNo, reportTime, reportReason, reportType);

            /***************************3.新增完成,準備轉交(Send the Success view)***********/
            String url = "/report/listAllReport.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllReport.jsp
            successView.forward(req, res);
        }

        if ("delete".equals(action)) { // 來自listAllReport.jsp

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數***************************************/
            Integer reportNo = Integer.valueOf(req.getParameter("reportNo"));

            /***************************2.開始刪除資料***************************************/
            ReportService reportService = new ReportService();
            reportService.deleteReport(reportNo);

            /***************************3.刪除完成,準備轉交(Send the Success view)***********/
            String url = "/report/listAllReport.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 刪除成功，轉交回送出刪除的來源網站
            successView.forward(req, res);
        }

        if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
            Integer reportNo = null;
            try {
                reportNo = Integer.valueOf(req.getParameter("reportNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("reportNo", "檢舉文章編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("reportNo", "會員編號請不要留白");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/report/select_page.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************2.開始查詢資料*****************************************/
            ReportService reportService = new ReportService();
            ReportVo reportVo = reportService.getOneReport(reportNo);
            if (reportVo == null) {
                errorMsgs.put("reportVo", "查無資料");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/report/select_page.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************3.查詢完成,準備轉交(Send the Success view)*************/
            req.setAttribute("reportVo", reportVo); // 資料庫取出的reportVo物件,存入req
            String url = "/report/listOneReport.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneReport.jsp
            successView.forward(req, res);
        }

        if ("getAll".equals(action)) { // 查詢全部的需求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************2.開始查詢資料*****************************************/
            ReportService reportService = new ReportService();
            List<ReportVo> reportList = reportService.getAll();

            if (reportList.isEmpty()) {
                errorMsgs.put("result", "查無資料"); // 如果結果為空，設置錯誤消息
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req.getRequestDispatcher("/report/select_page.jsp");
                failureView.forward(req, res);
                return; // 程序中斷
            }

            /***************************3.查詢完成,準備轉交(Send the Success view)*************/
            req.setAttribute("reportList", reportList); // 將查詢到的通知消息列表存入請求屬性中
            String url = "/report/listAllReport.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉發到 listAllReport.jsp 頁面
            successView.forward(req, res);
        }
    }
}
