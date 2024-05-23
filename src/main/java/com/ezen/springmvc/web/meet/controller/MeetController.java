package com.ezen.springmvc.web.meet.controller;

import com.ezen.springmvc.domain.meetArticle.service.MeetArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/meet")
@Slf4j
public class MeetController {

    private final MeetArticleService meetArticleService;

    public MeetController(MeetArticleService meetArticleService) {
        this.meetArticleService = meetArticleService;
    }

    @GetMapping
    public String meetList(){
        return "/meet/meetList";
    }

    @GetMapping("/register")
    public String meetRegister(){
        return "/meet/meetRegister";
    }




    @GetMapping("/read")
    public String meetRead(){
        return "/meet/meetRead";
    }
}
