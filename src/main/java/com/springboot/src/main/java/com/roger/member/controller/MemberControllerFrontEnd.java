package com.roger.member.controller;

import com.roger.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/frontend/member")
public class MemberControllerFrontEnd {

    @Autowired
    private MemberService memberService;

    @Autowired
    private StringRedisTemplate redisTemplate;

}
