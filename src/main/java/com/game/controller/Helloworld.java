package com.game.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Helloworld 
{

    @RequestMapping("/helloworld")  //此处控制浏览器里访问路径 具体为：/springmvc/helloworld
    public void helloWorld(HttpServletRequest request, HttpServletResponse response) throws IOException 
    {
        
    	 String clientName=request.getParameter("clientName");
    	 if(clientName==null)
    	 clientName="我的朋友";
         //输出字符串
    	 response.setContentType("text/html;charset=GB2312");//输出汉字关键语句
         response.getWriter().append(clientName+":"+"hello world");

    }
}