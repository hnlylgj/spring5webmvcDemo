package cn.hnly.springapp.springdemo;

/**
 * Hello world!
 *
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class Application 
{

    @Bean
    IMessageService mockMessageService() 
    {
        return new IMessageService()//匿名类
        {
            public String getMessage() 
            {
              return "Hello World!";
            }
            
            public void OutMessage(String Str)
            {
            	 System.out.println(Str);
            }
            
        };
    }
    
    
    @Bean
    ITestFunc mockTestFuncService() 
    {
        return new ITestFunc()//匿名类
        {
                      
            public void OutMessage(String Str)
            {
            	 System.out.println(Str);
            }
            
            public String GetMessage(int IndeX)
            {
            	
            	return "中国人,ligengjun";
            }
            
        };
    }
    
  
    
    
    
    /*
    
    
  public static void main(String[] args)
   {
      ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
     
      MessagePrinter printer = context.getBean(MessagePrinter.class);
      printer.printMessage();
      printer.OutMessage("李庚君!");
      //---------------------------
      
      TestFuncService funcer = context.getBean(TestFuncService.class);
      funcer.OutMessage("中国人!"); 
      
      
      
   }
  */
    
}
