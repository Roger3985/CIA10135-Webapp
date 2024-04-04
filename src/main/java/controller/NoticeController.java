package controller;

import VO.NoticeVO;
import service.NoticeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;
import java.util.Map;

@WebServlet("/NoticeController")
public class NoticeController extends HttpServlet {

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
                        .getRequestDispatcher("/emp/addEmp.jsp");
                failureView.forward(req, res);
                return;
            }

            /***************************2.開始新增資料***************************************/
            NoticeService noticeService = new NoticeService();
            noticeService.addNO(memNo, notContent, notTime, notStat);

            /***************************3.新增完成,準備轉交(Send the Success view)***********/
            String url = "/emp/listAllEmp.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
            successView.forward(req, res);
        }
    }
}

