package com.roger_jdbc.clicklike.controller;

import com.roger_jdbc.clicklike.service.ClickLikeService;
import com.roger_jdbc.clicklike.vo.ClickLikeVo;

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

@WebServlet("/clicklike/ClickLikeController")
public class ClickLikeController extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
            doPost(req, res);

        System.out.println("ok");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if ("insert".equals(action)) { // 來自addCA.jsp的請求

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

            Integer artNo = null;
            try {
                artNo = Integer.valueOf(req.getParameter("artNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("artNo", "文章編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("artNo", "文章編號請不要留白");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/clicklike/addCL.jsp");
                failureView.forward(req, res);
                return;
            }

            /***************************2.開始新增資料***************************************/
            ClickLikeService clickLikeService = new ClickLikeService();
            clickLikeService.addCL(memNo, artNo);

            /***************************3.新增完成,準備轉交(Send the Success view)***********/
            String url = "/clicklike/listAllCL.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllCL.jsp
            successView.forward(req, res);
        }

        if ("delete".equals(action)) { // 來自listAllCL.jsp and deleteCL.jsp

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數***************************************/
            Integer memNo = Integer.valueOf(req.getParameter("memNo"));

            /***************************2.開始刪除資料***************************************/
            ClickLikeService clickLikeService = new ClickLikeService();
            clickLikeService.deleteCL(memNo);

            /***************************3.刪除完成,準備轉交(Send the Success view)***********/
            String url = "/clicklike/listAllCL.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 刪除成功，轉交回送出刪除的來源網站
            successView.forward(req, res);
        }

        if ("update".equals(action)) { // 來自update_notice_input.jsp的請求

            Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
            Integer memNo = null;
            try {
                memNo = Integer.valueOf(req.getParameter("memNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("memNo", "會員編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("memNo", "會員編號請不要留白");
            }

            Integer artNo = null;
            try {
                artNo = Integer.valueOf(req.getParameter("artNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("artNo", "文章編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("artNo", "文章編號請不要留白");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/clicklike/addCL.jsp");
                failureView.forward(req, res);
                return;
            }

            /***************************2.開始修改資料*****************************************/
            ClickLikeService clickLikeService = new ClickLikeService();
            ClickLikeVo clickLikeVo = clickLikeService.updateCL(memNo, artNo);

            /***************************3.修改完成,準備轉交(Send the Success view)*************/
            req.setAttribute("clickLikeVo", clickLikeVo); // 資料庫update成功後，正確的clickLikeVo物件，存入req
            String url = "/clicklike/listOneCL.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url);
            successView.forward(req, res);

        }

        if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
            Integer memNo = null;
            try {
                memNo = Integer.valueOf(req.getParameter("memNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("memNo", "會員編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("memNo", "會員編號請不要留白");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/clicklike/select_page.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************2.開始查詢資料*****************************************/
            ClickLikeService clickLikeService = new ClickLikeService();
            ClickLikeVo clickLikeVo = clickLikeService.getOneCL(memNo);
            if (clickLikeVo == null) {
                errorMsgs.put("memNo", "查無資料");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/clicklike/select_page.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************3.查詢完成,準備轉交(Send the Success view)*************/
            req.setAttribute("clickLikeVo", clickLikeVo); // 資料庫取出的clickLikeVo物件,存入req
            String url = "/clicklike/listOneCL.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneCL.jsp
            successView.forward(req, res);
        }

        if ("getAll".equals(action)) { // 修改为查询全部的请求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************2.開始查詢資料*****************************************/
            ClickLikeService clickLikeService = new ClickLikeService();
            List<ClickLikeVo> clickLikeList = clickLikeService.getAll(); // 調用服務類的方法查詢全部資料

            if (clickLikeList.isEmpty()) {
                errorMsgs.put("result", "查無資料"); // 如果結果為空，設置錯誤消息
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req.getRequestDispatcher("/clicklike/select_page.jsp");
                failureView.forward(req, res);
                return; // 程序中斷
            }

            /***************************3.查詢完成,準備轉交(Send the Success view)*************/
            req.setAttribute("clickLikeList", clickLikeList); // 將查詢到的通知消息列表存入請求屬性中
            String url = "/clicklike/listAllCL.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉發到 listAllCL.jsp 頁面
            successView.forward(req, res);
        }
    }
}
