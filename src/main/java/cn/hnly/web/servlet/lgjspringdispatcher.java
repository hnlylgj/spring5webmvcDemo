package cn.hnly.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.hnly.springapp.springdemo.Application;
import cn.hnly.springapp.springdemo.MessagePrinter;
import cn.hnly.springapp.springdemo.TestFuncService;


public class lgjspringdispatcher extends HttpServlet // 第一步： 扩展 HttpServlet 抽象类。
{
	 private static final String CONTENT_TYPE = "text/html";
	 private static final ApplicationContext MyApplicationContext = new AnnotationConfigApplicationContext(Application.class);;

	  public void init(ServletConfig config) throws ServletException 
	  {
	  	super.init(config);
	  	Springinit();
	  }

	  public void Springinit() throws ServletException 
	  {
		 // MyApplication 
		 //MyApplicationContext = new AnnotationConfigApplicationContext(Application.class);
		 
		  System.out.println("Springinit......");//测试语句,输出到Tomcat启动界面		  
		  MessagePrinter printer = MyApplicationContext.getBean(MessagePrinter.class);
	      //printer.printMessage();//测试语句
	      printer.OutMessage("李庚君!ABC...YES");//测试语句
	  
	  }

	
 	//第二步：覆盖doGet()方法
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException
    {
     //第三步：获取HTTP 请求中的参数信息
    TestFuncService funcer =  MyApplicationContext.getBean(TestFuncService.class);
    funcer.OutMessage("中国人-李庚君!");
    System.out.println(funcer.GetMessage(0));//测试语句
    	
     String clientName=request.getParameter("clientName");
     if(clientName!=null)
      ;//clientName=new String(clientName.getBytes("ISO-8859-1"),"GB2312");//UTF-8过滤器以后无须这个语句
     else
     clientName=funcer.GetMessage(0);//"我的朋友";//从Spring容器中获得数据
     
     
     // 第四步：生成 HTTP 响应结果。
      PrintWriter out;
      String title="HelloServlet";
      String heading1="This is output from HelloServlet by doGet:";
      // set content type.
      response.setContentType("text/html;charset=GB2312");//输出汉字关键语句
      // write html page.
      out = response.getWriter();
      out.print("<HTML><HEAD><TITLE>"+title+"</TITLE>");
      out.print("</HEAD><BODY>");
      out.print(heading1);
      out.println("<h1><P> "+clientName+" : 您好</h1>");
      out.print("</BODY></HTML>");
      //close out.
      out.close();

    }
     //第三步：覆盖doPost()方法
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException
     {
    

     }
}
