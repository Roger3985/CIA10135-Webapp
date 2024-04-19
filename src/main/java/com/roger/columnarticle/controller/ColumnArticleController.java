package com.roger.columnarticle.controller;

import com.roger.columnarticle.service.ColumnArticleService;
import com.roger.columnarticle.vo.ColumnArticleVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/columnarticle/ColumnArticleController")
public class ColumnArticleController extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if ("insert".equals(action)) { // 來自addCA.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
            Integer admNo = null;
            try {
                admNo = Integer.valueOf(req.getParameter("admNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("admNo", "管理員編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("admNo", "管理員編號請不要留白");
            }

            String artTitle = req.getParameter("artTitle");
            String artTitleReg = "^[\u4e00-\u9fa5，。、；：！？（）【】「」『』《》……,.：；！？（）]{1,45}$";
            if (artTitle == null || artTitle.trim().length() == 0) {
                errorMsgs.put("artTitle", "文章標題: 請勿空白");
            } else if (!artTitle.trim().matches(artTitleReg)) {
                errorMsgs.put("artTitle", "文章標題: 請勿填寫中文以外的內容，且在45字內");
            }

            String artContent = req.getParameter("artContent");
            String artContentReg = "^[\u4e00-\u9fa5，。、；：！？（）【】「」『』《》……,.：；！？（）]{1,2000}$";
            if (artContent == null || artContent.trim().length() == 0) {
                errorMsgs.put("artContent", "文章內容: 請勿空白");
            } else if (!artContent.trim().matches(artContentReg)) {
                errorMsgs.put("artContent", "文章內容: 請勿填寫中文以外的內容，且在2000字內");
            }

            Timestamp artTime = null;
            String artTimeReg = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1]) ([0-1][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";
            try {
                // 如果格式不正確，則將錯誤訊息存儲在 errorMsgs 中
                if (!artTime.toString().trim().matches(artTimeReg)) {
                    errorMsgs.put("artTime", "文章發表時間請填日期時間且請填以下的格式 ex: 2023-03-02 09:00:00");
                }
            } catch (NullPointerException e) {
                // 如果 artTime 參數為空或為 null，則處理 NullPointerException
                errorMsgs.put("artTime", "文章發表時間請不要留白");
            }

            Integer artCatNo = null;
            try {
                artCatNo = Integer.valueOf(req.getParameter("artCatNo").trim());
                if (artCatNo < 1000) {
                    errorMsgs.put("artCatNo", "文章分類標號不要填小於1000的數值");
                }
            } catch (NumberFormatException e) {
                errorMsgs.put("artCatNo", "文章分類標號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("artCatNo", "文章分類標號請不要留白");
            }

            Byte artStat = null;
            try {
                artStat = Byte.valueOf(req.getParameter("artStat").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("artStat", "文章狀態請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("artStat", "文章狀態請不要留白");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/columnarticle/addCA.jsp");
                failureView.forward(req, res);
                return;
            }

            /***************************2.開始新增資料***************************************/
            ColumnArticleService columnArticleService = new ColumnArticleService();
            columnArticleService.addCa(admNo, artTitle, artContent, artTime, artCatNo, artStat);

            /***************************3.新增完成,準備轉交(Send the Success view)***********/
            String url = "/columnarticle/listAllCA.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllCA.jsp
            successView.forward(req, res);
        }

        if ("delete".equals(action)) { // 來自listAllCA.jsp and deleteCA.jsp

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數***************************************/
            Integer artNo = Integer.valueOf(req.getParameter("artNo"));

            /***************************2.開始刪除資料***************************************/
            ColumnArticleService columnArticleService = new ColumnArticleService();
            columnArticleService.deleteCa(artNo);

            /***************************3.刪除完成,準備轉交(Send the Success view)***********/
            String url = "/columnartice/listAllCA.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 刪除成功，轉交回送出刪除的來源網站
            successView.forward(req, res);
        }

        if ("update".equals(action)) { // 來自update_notice_input.jsp的請求

            Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
            Integer artNo = null;
            try {
                artNo = Integer.valueOf(req.getParameter("artNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("artNo", "文章編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("artNo", "文章編號請不要留白");
            }

            Integer admNo = null;
            try {
                admNo = Integer.valueOf(req.getParameter("admNo").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("admNo", "管理員編號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("admNo", "管理員編號請不要留白");
            }

            String artTitle = req.getParameter("artTitle");
            String artTitleReg = "^[\u4e00-\u9fa5，。、；：！？（）【】「」『』《》……,.：；！？（）]{1,45}$";
            if (artTitle == null || artTitle.trim().length() == 0) {
                errorMsgs.put("artTitle", "文章標題: 請勿空白");
            } else if (!artTitle.trim().matches(artTitleReg)) {
                errorMsgs.put("artTitle", "文章標題: 請勿填寫中文以外的內容，且在45字內");
            }

            String artContent = req.getParameter("artContent");
            String artContentReg = "^[\u4e00-\u9fa5，。、；：！？（）【】「」『』《》……,.：；！？（）]{1,2000}$";
            if (artContent == null || artContent.trim().length() == 0) {
                errorMsgs.put("artContent", "文章內容: 請勿空白");
            } else if (!artContent.trim().matches(artContentReg)) {
                errorMsgs.put("artContent", "文章內容: 請勿填寫中文以外的內容，且在2000字內");
            }

            Timestamp artTime = null;
            String artTimeReg = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1]) ([0-1][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";
            try {
                // 如果格式不正確，則將錯誤訊息存儲在 errorMsgs 中
                if (!artTime.toString().trim().matches(artTimeReg)) {
                    errorMsgs.put("artTime", "文章發表時間請填日期時間且請填以下的格式 ex: 2023-03-02 09:00:00");
                }
            } catch (NullPointerException e) {
                // 如果 artTime 參數為空或為 null，則處理 NullPointerException
                errorMsgs.put("artTime", "文章發表時間請不要留白");
            }

            Integer artCatNo = null;
            try {
                artCatNo = Integer.valueOf(req.getParameter("artCatNo").trim());
                if (artCatNo < 1000) {
                    errorMsgs.put("artCatNo", "文章分類標號不要填小於1000的數值");
                }
            } catch (NumberFormatException e) {
                errorMsgs.put("artCatNo", "文章分類標號請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("artCatNo", "文章分類標號請不要留白");
            }

            Byte artStat = null;
            try {
                artStat = Byte.valueOf(req.getParameter("artStat").trim());
            } catch (NumberFormatException e) {
                errorMsgs.put("artStat", "文章狀態請填數字");
            } catch (NullPointerException nullPointerException) {
                errorMsgs.put("artStat", "文章狀態請不要留白");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/columnarticle/addCA.jsp");
                failureView.forward(req, res);
                return;
            }

            /***************************2.開始修改資料*****************************************/
            ColumnArticleService columnArticleService = new ColumnArticleService();
            ColumnArticleVO columnArticleVo = columnArticleService.updateCa(artNo, admNo, artTitle, artContent, artTime, artCatNo, artStat);

            /***************************3.修改完成,準備轉交(Send the Success view)*************/
            req.setAttribute("columnArticleVo", columnArticleVo); // 資料庫update成功後，正確的columnArticleVo物件，存入req
            String url = "/columnarticle/listOneCA.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url);
            successView.forward(req, res);

        }

        if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
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
                        .getRequestDispatcher("/columnarticle/select_page.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************2.開始查詢資料*****************************************/
            ColumnArticleService columnArticleService = new ColumnArticleService();
            ColumnArticleVO columnArticleVo = columnArticleService.getOneCa(artNo);
            if (columnArticleVo == null) {
                errorMsgs.put("artNo", "查無資料");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/columnarticle/select_page.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************3.查詢完成,準備轉交(Send the Success view)*************/
            req.setAttribute("columnArticleVo", columnArticleVo); // 資料庫取出的columnArticleVo物件,存入req
            String url = "/columnarticle/listOneCA.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneCA.jsp
            successView.forward(req, res);
        }

        if ("getAll".equals(action)) { // 修改为查询全部的请求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************2.開始查詢資料*****************************************/
            ColumnArticleService columnArticleService = new ColumnArticleService();
            List<ColumnArticleVO> columnarticleList = columnArticleService.getAll(); // 調用服務類的方法查詢全部資料

            if (columnarticleList.isEmpty()) {
                errorMsgs.put("result", "查無資料"); // 如果結果為空，設置錯誤消息
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req.getRequestDispatcher("/notice/select_page.jsp");
                failureView.forward(req, res);
                return; // 程序中斷
            }

            /***************************3.查詢完成,準備轉交(Send the Success view)*************/
            req.setAttribute("columnarticleList", columnarticleList); // 將查詢到的通知消息列表存入請求屬性中
            String url = "/columnartice/listAllCA.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉發到 listAllCA.jsp 頁面
            successView.forward(req, res);
        }

    }

}
