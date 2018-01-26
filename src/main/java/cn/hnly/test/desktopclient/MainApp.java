package cn.hnly.test.desktopclient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.hnly.springapp.springdemo.Application;
import cn.hnly.springapp.springdemo.MessagePrinter;
import cn.hnly.springapp.springdemo.TestFuncService;

public class MainApp 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		  ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
	     
	      MessagePrinter printer = context.getBean(MessagePrinter.class);
	      printer.printMessage();
	      printer.OutMessage("李庚君!");
	      //---------------------------
	      
	      TestFuncService funcer = context.getBean(TestFuncService.class);
	      funcer.OutMessage("中国人-李庚君!"); 
	      
	      System.out.println(funcer.GetMessage(0));
	      
	     

	}

}
