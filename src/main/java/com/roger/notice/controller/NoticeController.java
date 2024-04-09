package com.roger.notice.controller;

import com.roger.notice.service.NoticeService;
import com.roger.notice.vo.NoticeVO;

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

@WebServlet("/notice/NoticeController")
public class NoticeController extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if ("getOne_For_Insert".equals(action)) { // 來自listAllNO.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數****************************************/
            Integer motNo = Integer.valueOf(req.getParameter("motNo"));

            /***************************2.開始查詢資料****************************************/
            NoticeService noticeService = new NoticeService();
            NoticeVO noticeVO = noticeService.getOneNO(motNo);

            /***************************3.查詢完成,準備轉交(Send the Success view)************/
            String param = "?motNo="  +noticeVO.getMotNo()+
                    "&memNo="  +noticeVO.getMemNo()+
                    "&notContent="    +noticeVO.getNotContent()+
                    "&notTime="+noticeVO.getNotTime()+
                    "&notStat="    +noticeVO.getNotStat();

            String url = "/notice/addNO.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_member_input.jsp
            successView.forward(req, res);
        }

        if ("insert".equals(action)) { // 來自addNO.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
            Integer memNo = null;
            try {
                memNo = Integer.valueOf(req.getParameter("memNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("memNo", "會員編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("memNo", "會員編號請不要留白");
            }

            String notContent = req.getParameter("notContent");
            String notContentReg = "^[\u4e00-\u9fa5，。、；：！？（）【】「」『』《》……,.：；！？（）]{1,1000}$";
            if (notContent == null || notContent.trim().length() == 0) {
                errorMsgs.put("notContent", "通知內容: 請勿空白");
            } else if (!notContent.trim().matches(notContentReg)) {
                errorMsgs.put("notContent", "通知內容: 請勿填寫中文以外的內容，且在1000字內");
            }

            Instant currentTime = Instant.now();
            Timestamp notTime = Timestamp.from(currentTime);
            try {
                notTime = Timestamp.valueOf(req.getParameter("notTime").trim());
            } catch (IllegalArgumentException e) {
                errorMsgs.put("notTime", "發送時間請輸入日期以及時間");
            }

            Byte notStat = 0;
            try {
                notStat = Byte.valueOf(req.getParameter("notStat").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("notStat", "讀取狀態請填數字");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/notice/addNO.jsp");
                failureView.forward(req, res);
                return;
            }

            /***************************2.開始新增資料***************************************/
            NoticeService noticeService = new NoticeService();
            noticeService.addNO(memNo, notContent, notTime, notStat);

            /***************************3.新增完成,準備轉交(Send the Success view)***********/
            String url = "/notice/listAllNO.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllNO.jsp
            successView.forward(req, res);
        }

        if ("delete".equals(action)) { // 來自listAllNO.jsp

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數***************************************/
            Integer motNo = Integer.valueOf(req.getParameter("motNo"));

            /***************************2.開始刪除資料***************************************/
            NoticeService noticeService = new NoticeService();
            noticeService.deleteNO(motNo);

            /***************************3.刪除完成,準備轉交(Send the Success view)***********/
            String url = "/notice/listAllNO.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 刪除成功，轉交回送出刪除的來源網站
            successView.forward(req, res);
        }

        if ("getOne_For_Update".equals(action)) { // 來自listAllNO.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數****************************************/
            Integer motNo = Integer.valueOf(req.getParameter("motNo"));

            /***************************2.開始查詢資料****************************************/
            NoticeService noticeService = new NoticeService();
            NoticeVO noticeVO = noticeService.getOneNO(motNo);

            /***************************3.查詢完成,準備轉交(Send the Success view)************/
            String param = "?notNO="  +noticeVO.getMotNo()+
                    "&memNo="  +noticeVO.getMemNo()+
                    "&notContent="    +noticeVO.getNotContent()+
                    "&notTime="+noticeVO.getNotTime()+
                    "&notStat="    +noticeVO.getNotStat();

            String url = "update_member_input.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_member_input.jsp
            successView.forward(req, res);
        }

        if ("update".equals(action)) { // 來自update_notice_input.jsp的請求

            Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
            Integer motNo = Integer.valueOf(req.getParameter("motNo").trim());

            Integer memNo = null;
            try {
                memNo = Integer.valueOf(req.getParameter("memNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("memNo", "會員編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("memNo", "會員編號請不要留白");
            }

            String notContent = req.getParameter("notContent");
            String notContentReg = "^[\u4e00-\u9fa5，。、；：！？（）【】「」『』《》……,.：；！？（）]{1,1000}$";
            if (notContent == null || notContent.trim().length() == 0) {
                errorMsgs.put("notContent", "通知內容: 請勿空白");
            } else if (!notContent.trim().matches(notContentReg)) {
                errorMsgs.put("notContent", "通知內容: 請勿填寫中文以外的內容，且在1000字內");
            }

            Instant currentTime = Instant.now();
            Timestamp notTime = Timestamp.from(currentTime);
            try {
                notTime = Timestamp.valueOf(req.getParameter("notTime").trim());
            } catch (IllegalArgumentException e) {
                errorMsgs.put("notTime", "發送時間請輸入日期以及時間");
            }

            Byte notStat = 0;
            try {
                notStat = Byte.valueOf(req.getParameter("notStat").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("notStat", "讀取狀態請填數字");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/notice/addNO.jsp");
                failureView.forward(req, res);
                return;
            }

            /***************************2.開始修改資料*****************************************/
            NoticeService noticeService = new NoticeService();
            NoticeVO noticeVO = noticeService.updateNO(motNo, memNo, notContent, notTime, notStat);

            /***************************3.修改完成,準備轉交(Send the Success view)*************/
            req.setAttribute("noticeVO", noticeVO); // 資料庫update成功後，正確的noticeVO物件，存入req
            String url = "/notice/listOneNO.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url);
            successView.forward(req, res);

        }

        if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
            Integer motNo = Integer.valueOf(req.getParameter("motNo").trim().length());
            try {
                if (motNo == null || motNo == 0) {
                    errorMsgs.put("motNo", "會員通知編號請不要留白");
                }
            } catch (NumberFormatException e) {
                errorMsgs.put("motNo", "會員通知編號請填數字");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/notice/select_page.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************2.開始查詢資料*****************************************/
            NoticeService noticeService = new NoticeService();
            NoticeVO noticeVO = noticeService.getOneNO(motNo);
            if (noticeVO == null) {
                errorMsgs.put("motNo", "查無資料");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/notice/select_page.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************3.查詢完成,準備轉交(Send the Success view)*************/
            req.setAttribute("noticeVO", noticeVO); // 資料庫取出的noticeVO物件,存入req
            String url = "/notice/listOneNO.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
            successView.forward(req, res);
        }

        if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
            Integer motNo = null;
            try {
                motNo = Integer.valueOf(req.getParameter("motNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("motNo", "會員通知編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("motNo", "會員通知編號請不要留白");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/notice/select_page.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************2.開始查詢資料*****************************************/
            NoticeService noticeService = new NoticeService();
            NoticeVO noticeVO = noticeService.getOneNO(motNo);
            if (noticeVO == null) {
                errorMsgs.put("motNo", "查無資料");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/notice/select_page.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************3.查詢完成,準備轉交(Send the Success view)*************/
            req.setAttribute("noticeVO", noticeVO); // 資料庫取出的noticeVO物件,存入req
            String url = "/notice/listOneNO.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
            successView.forward(req, res);
        }

        if ("getAll".equals(action)) { // 修改为查询全部的请求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************2.開始查詢資料*****************************************/
            NoticeService noticeService = new NoticeService();
            List<NoticeVO> noticeList = noticeService.getAll(); // 調用服務類的方法查詢全部資料

            if (noticeList.isEmpty()) {
                errorMsgs.put("result", "查無資料"); // 如果結果為空，設置錯誤消息
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req.getRequestDispatcher("/notice/select_page.jsp");
                failureView.forward(req, res);
                return; // 程序中斷
            }

            /***************************3.查詢完成,準備轉交(Send the Success view)*************/
            req.setAttribute("noticeList", noticeList); // 將查詢到的通知消息列表存入請求屬性中
            String url = "/notice/listAllNO.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉發到 listAllNO.jsp 頁面
            successView.forward(req, res);
        }

    }

}

