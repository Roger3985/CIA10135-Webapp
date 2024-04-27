package com.roger_hibernate.member.controller;

import com.roger_hibernate.member.service.MemberService;
import com.roger_hibernate.member.service.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/MemberServlet")
public class MemberServlet extends HttpServlet {

    // 一個 servlet 實體對應一個 service 實體
    private MemberService memberService;

    @Override
    public void init() throws ServletException {
        memberService = new MemberServiceImpl();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);

        System.out.println("ok");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        String forwordPath = "";

        switch (action) {
            case "getAll":
                forwordPath = ;
                break;
            case "compositeQuery":
                forwordPath =;
                break;
            default:
                forwordPath = "/index.jsp";
        }

        res.setContentType("text/html; ");
    }
}
