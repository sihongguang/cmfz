package com.baizhi.controller;

import com.baizhi.entity.Guru;
import com.baizhi.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("article")
@Controller
public class ArticleController {

    @Autowired
    private GuruService guruService;

    @ResponseBody
    @RequestMapping("queryallGuruAndArticle")
    public List<Guru> queryallGuruAndArticle(){
        List<Guru> gurus = guruService.queryallGuruAndArticle();
        return  gurus;
    }
}
