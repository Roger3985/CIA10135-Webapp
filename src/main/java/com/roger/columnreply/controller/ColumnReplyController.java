package com.roger.columnreply.controller;

import com.roger.columnreply.service.ColumnReplyService;
import com.roger.columnreply.vo.ColumnReplyVo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
            ColumnReplyVo columnReplyVo = columnReplyService.getOneCR(columnReplyNo);
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
            List<ColumnReplyVo> columnReplyList = columnReplyService.getAll(); // 調用服務類的方法查詢全部資料

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
