package com.roger.member.controller;

import com.roger.member.service.MemberService;
import com.roger.member.vo.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/member/MemberServlet")
public class MemberServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);

        System.out.println("ok");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if ("insert".equals(action)) { // 來自addMem.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
            String mName = req.getParameter("mName");
            String mNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";

            if (mName == null || mName.trim().length() == 0) {
                errorMsgs.put("mName", "會員姓名: 請勿空白");
            } else if (!mName.trim().matches(mNameReg)) { // 以下練習正則(規)表示式(regular-expression)
                errorMsgs.put("mName", "會員姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
            }

            String memAcc = req.getParameter("memAcc");
            String memAccReg = "^[a-zA-Z0-9]{4,10}$";
            if (memAcc == null || memAcc.trim().length() == 0) {
                errorMsgs.put("memAcc", "會員帳號請勿空白");
            } else if (!memAcc.trim().matches(memAccReg)) {
                errorMsgs.put("memAcc", "會員帳號: 只能是英文字母、數字, 且長度必需在4到10之間");
            }

            String memPwd = req.getParameter("memPwd");
            String memPwdReg = "^[a-zA-Z0-9]{4,10}$";
            if (memPwd == null || memPwd.trim().length() == 0) {
                errorMsgs.put("memPwd", "會員密碼請勿空白");
            } else if (!memPwd.trim().matches(memPwdReg)) {
                errorMsgs.put("memPwd", "會員密碼: 只能是英文字母、數字, 且長度必需在4到10之間");
            }

            String memMob = req.getParameter("memMob");
            String memMobReg = "^0\\d{1,2}\\d{6,8}$";
            if (memMob == null || memMob.trim().length() == 0) {
                errorMsgs.put("memMob", "會員電話請勿空白");
            } else if (!memMob.trim().matches(memMobReg)) {
                errorMsgs.put("memMob", "會員電話: 格式必須是開頭為0，第二個數字1-9，後面接6-8位數字");
            }

            Byte mGender = Byte.valueOf(req.getParameter("mGender")); // 假設從請求中獲取性別參數
            try {
                if (mGender != 1 && mGender != 2) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                errorMsgs.put("mGender", "性別只能為 1（男生）或 2（女生）");
            }

            String memMail = req.getParameter("memMail");
            String memMailReg = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            if (memMail == null || memMail.trim().length() == 0) {
                errorMsgs.put("memMail", "會員信箱請勿空白");
            } else if (!memMail.trim().matches(memMailReg)) {
                errorMsgs.put("memMail", "會員信箱: 請輸入正確格式，您的用戶名@您的電子郵件服務名稱，例如: xxx@gmail.com");
            }

            String memAdd = req.getParameter("memAdd");
            String memAddReg = "^[\\u4e00-\\u9fa5\\d\\s\\-()（）]{5,100}$";
            if (memAdd != null) {
                memAdd = memAdd.trim();
            }
            if (memAdd == null || memAdd.trim().length() == 0) {
                // 如果會員地址為空，則不進行驗證，會員地址可以為空
            } else if (!memAdd.trim().matches(memAddReg)) {
                errorMsgs.put("memAdd", "會員地址: 請輸入正確格式，例如:台北市大安區忠孝東路四段100號");
            }

            String memBdString = req.getParameter("memBd");

            // 如果 memBdString 為空或為 null，則將 memBd 設置為 null
            Date memBd = null;
            if (memBdString != null && !memBdString.trim().isEmpty()) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date utilDate = sdf.parse(memBdString.trim());
                    memBd = new Date(utilDate.getTime()); // 將 java.util.Date 轉換為 java.sql.Date
                } catch (ParseException e) {
                    errorMsgs.put("memBd", "請輸入有效的生日日期，格式為 yyyy-MM-dd");
                }
            }

            String memCard = req.getParameter("memCard");
            String memCardReg = "^\\d{15,19}$";
            if (memCard == null || memCard.trim().length() == 0) {
                // 如果信用卡為空，則不進行驗證，信用卡可以為空
            } else if (!memCard.trim().matches(memCardReg)) {
                errorMsgs.put("memCard", "信用卡: 請輸入正確格式，例如:411235678901234 (信用卡卡號有15~19碼)");
            }

            Byte provider = 1;
            String clientID = null;
            String displayName = null;
            String accessToken = null;
            String refreshToken = null;
            Timestamp tknExpireTime = null;
            Timestamp creationTime = null;

            Timestamp memberJoinTime = new Timestamp(System.currentTimeMillis());

            Byte memStat = 0; // 預設為 0

            // 檢查是否為三種選擇之一
            if (memStat != 0 && memStat != 1 && memStat != 2) {
                // 如果不是三種選擇之一，則將其設置為預設值 0
                memStat = 0;
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req.getRequestDispatcher("");
                failureView.forward(req, res);
                return;
            }

            /***************************2.開始新增資料***************************************/
            MemberService memSvc = new MemberService();
            memSvc.addMem(mName, memAcc, memPwd, memMob, mGender, memMail, memAdd, memBd, memCard, provider, clientID, displayName, accessToken, refreshToken, tknExpireTime, creationTime, memberJoinTime, memStat);

            /***************************3.新增完成,準備轉交(Send the Success view)***********/
            String url = "/member/listAllMem.jsp"; // 請檢查此URL是否正確
            RequestDispatcher successView = req.getRequestDispatcher(url);
            successView.forward(req, res);
        }

        if ("update".equals(action)) { // 來自update_notice_input.jsp的請求

            Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
            Integer memNo = Integer.valueOf(req.getParameter("memNo").trim());

            String mName = req.getParameter("mName");
            String mNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";

            if (mName == null || mName.trim().length() == 0) {
                errorMsgs.put("mName", "會員姓名: 請勿空白");
            } else if (!mName.trim().matches(mNameReg)) { // 以下練習正則(規)表示式(regular-expression)
                errorMsgs.put("mName", "會員姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
            }

            String memAcc = req.getParameter("memAcc");
            String memAccReg = "^[a-zA-Z0-9]{4,10}$";
            if (memAcc == null || memAcc.trim().length() == 0) {
                errorMsgs.put("memAcc", "會員帳號請勿空白");
            } else if (!memAcc.trim().matches(memAccReg)) {
                errorMsgs.put("memAcc", "會員帳號: 只能是英文字母、數字, 且長度必需在4到10之間");
            }

            String memPwd = req.getParameter("memPwd");
            String memPwdReg = "^[a-zA-Z0-9]{4,10}$";
            if (memPwd == null || memPwd.trim().length() == 0) {
                errorMsgs.put("memPwd", "會員密碼請勿空白");
            } else if (!memPwd.trim().matches(memPwdReg)) {
                errorMsgs.put("memPwd", "會員密碼: 只能是英文字母、數字, 且長度必需在4到10之間");
            }

            String memMob = req.getParameter("memMob");
            String memMobReg = "^0\\d{1,2}\\d{6,8}$";
            if (memMob == null || memMob.trim().length() == 0) {
                errorMsgs.put("memMob", "會員電話請勿空白");
            } else if (!memMob.trim().matches(memMobReg)) {
                errorMsgs.put("memMob", "會員電話: 格式必須是開頭為0，第二個數字1-9，後面接6-8位數字");
            }

            Byte mGender = Byte.valueOf(req.getParameter("mGender")); // 假設從請求中獲取性別參數
            try {
                if (mGender != 1 && mGender != 2) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                errorMsgs.put("mGender", "性別只能為 1（男生）或 2（女生）");
            }

            String memMail = req.getParameter("memMail");
            String memMailReg = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            if (memMail == null || memMail.trim().length() == 0) {
                errorMsgs.put("memMail", "會員信箱請勿空白");
            } else if (!memMail.trim().matches(memMailReg)) {
                errorMsgs.put("memMail", "會員信箱: 請輸入正確格式，您的用戶名@您的電子郵件服務名稱，例如: xxx@gmail.com");
            }

            String memAdd = req.getParameter("memAdd");
            String memAddReg = "^[\\u4e00-\\u9fa5\\d\\s\\-()（）]{5,100}$";
            if (memAdd != null) {
                memAdd = memAdd.trim();
            }
            if (memAdd == null || memAdd.trim().length() == 0) {
                // 如果會員地址為空，則不進行驗證，會員地址可以為空
            } else if (!memAdd.trim().matches(memAddReg)) {
                errorMsgs.put("memAdd", "會員地址: 請輸入正確格式，例如:台北市大安區忠孝東路四段100號");
            }

            String memBdString = req.getParameter("memBd");

            // 如果 memBdString 為空或為 null，則將 memBd 設置為 null
            Date memBd = null;
            if (memBdString != null && !memBdString.trim().isEmpty()) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date utilDate = sdf.parse(memBdString.trim());
                    memBd = new Date(utilDate.getTime()); // 將 java.util.Date 轉換為 java.sql.Date
                } catch (ParseException e) {
                    errorMsgs.put("memBd", "請輸入有效的生日日期，格式為 yyyy-MM-dd");
                }
            }

            String memCard = req.getParameter("memCard");
            String memCardReg = "^\\d{15,19}$";
            if (memCard == null || memCard.trim().length() == 0) {
                // 如果信用卡為空，則不進行驗證，信用卡可以為空
            } else if (!memCard.trim().matches(memCardReg)) {
                errorMsgs.put("memCard", "信用卡: 請輸入正確格式，例如:411235678901234 (信用卡卡號有15~19碼)");
            }

            Byte provider = 1;
            String clientID = null;
            String displayName = null;
            String accessToken = null;
            String refreshToken = null;
            Timestamp tknExpireTime = null;
            Timestamp creationTime = null;

            Timestamp memberJoinTime = new Timestamp(System.currentTimeMillis());

            Byte memStat = 0; // 預設為 0

            // 檢查是否為三種選擇之一
            if (memStat != 0 && memStat != 1 && memStat != 2) {
                // 如果不是三種選擇之一，則將其設置為預設值 0
                memStat = 0;
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req.getRequestDispatcher("/member/select_page.jsp");
                failureView.forward(req, res);
                return;
            }

            /***************************2.開始修改資料*****************************************/
            MemberService memSvc = new MemberService();
            MemberVO memberVO = memSvc.updateMem(memNo, mName, memAcc, memPwd, memMob, mGender, memMail, memAdd, memBd, memCard, provider, clientID, displayName, accessToken, refreshToken, tknExpireTime, creationTime, memberJoinTime, memStat);

            /***************************3.修改完成,準備轉交(Send the Success view)*************/
            req.setAttribute("memberVO", memberVO); // 資料庫update成功後，正確的memberVO物件，存入req
            String url = "/member/listOneMem.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url);
            successView.forward(req, res);

        }

        if ("delete".equals(action)) { // 來自listAllMem.jsp

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數***************************************/
            Integer memNo = Integer.valueOf(req.getParameter("memNo"));

            /***************************2.開始刪除資料***************************************/
            MemberService memberService = new MemberService();
            memberService.deleteMem(memNo);

            /***************************3.刪除完成,準備轉交(Send the Success view)***********/
            String url = "/member/listAllMem.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 刪除成功，轉交回送出刪除的來源網站
            successView.forward(req, res);
        }

        if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
            Integer memNo = Integer.valueOf(req.getParameter("memNo").trim().length());
            try {
                if (memNo == null || memNo == 0) {
                    errorMsgs.put("memNo", "會員編號請不要留白");
                }
            } catch (NumberFormatException e) {
                errorMsgs.put("memNo", "會員編號請填數字");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/member/select_page.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************2.開始查詢資料*****************************************/
            MemberService memberService = new MemberService();
            MemberVO memberVO = memberService.getOneMem(memNo);
            if (memberVO == null) {
                errorMsgs.put("memNo", "查無資料");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/member/select_page.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************3.查詢完成,準備轉交(Send the Success view)*************/
            req.setAttribute("memberVO", memberVO); // 資料庫取出的noticeVO物件,存入req
            String url = "/member/listOneMem.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
            successView.forward(req, res);
        }

        if ("getOne_For_Name".equals(action)) { // 來自select_page.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
            String mName = req.getParameter("mName");
            String mNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";

            if (mName == null || mName.trim().length() == 0) {
                errorMsgs.put("mName", "會員姓名: 請勿空白");
            } else if (!mName.trim().matches(mNameReg)) { // 以下練習正則(規)表示式(regular-expression)
                errorMsgs.put("mName", "會員姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/member/select_page.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************2.開始查詢資料*****************************************/
            MemberService memberService = new MemberService();
            MemberVO memberVO = memberService.getOneMemName(mName);
            if (memberVO == null) {
                errorMsgs.put("memNo", "查無資料");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/member/select_page.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************3.查詢完成,準備轉交(Send the Success view)*************/
            req.setAttribute("memberVO", memberVO); // 資料庫取出的noticeVO物件,存入req
            String url = "/member/listOneMem.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
            successView.forward(req, res);
        }

        if ("getOne_For_Account".equals(action)) { // 來自select_page.jsp的請求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
            String memAcc = req.getParameter("memAcc");
            String memAccReg = "^[a-zA-Z0-9]{4,10}$";
            if (memAcc == null || memAcc.trim().length() == 0) {
                errorMsgs.put("memAcc", "會員帳號請勿空白");
            } else if (!memAcc.trim().matches(memAccReg)) {
                errorMsgs.put("memAcc", "會員帳號: 只能是英文字母、數字, 且長度必需在4到10之間");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/member/select_page.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************2.開始查詢資料*****************************************/
            MemberService memberService = new MemberService();
            MemberVO memberVO = memberService.getOneMemAccount(memAcc);
            if (memberVO == null) {
                errorMsgs.put("memNo", "查無資料");
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req
                        .getRequestDispatcher("/member/select_page.jsp");
                failureView.forward(req, res);
                return;//程式中斷
            }

            /***************************3.查詢完成,準備轉交(Send the Success view)*************/
            req.setAttribute("memberVO", memberVO); // 資料庫取出的noticeVO物件,存入req
            String url = "/member/listOneMem.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
            successView.forward(req, res);
        }

        if ("getAll".equals(action)) { // 修改为查询全部的请求

            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
            req.setAttribute("errorMsgs", errorMsgs);

            /***************************2.開始查詢資料*****************************************/
            MemberService noticeService = new MemberService();
            List<MemberVO> memberVOList = noticeService.getAll(); // 調用服務類的方法查詢全部資料

            if (memberVOList.isEmpty()) {
                errorMsgs.put("result", "查無資料"); // 如果結果為空，設置錯誤消息
            }

            // Send the use back to the form, if there were errors
            if (!errorMsgs.isEmpty()) {
                RequestDispatcher failureView = req.getRequestDispatcher("/member/select_page.jsp");
                failureView.forward(req, res);
                return; // 程序中斷
            }

            /***************************3.查詢完成,準備轉交(Send the Success view)*************/
            req.setAttribute("noticeList", memberVOList); // 將查詢到的通知消息列表存入請求屬性中
            String url = "/member/listAllNO.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉發到 listAllNO.jsp 頁面
            successView.forward(req, res);
        }
    }
}
