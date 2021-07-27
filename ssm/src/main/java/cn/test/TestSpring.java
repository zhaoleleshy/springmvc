package cn.test;

import cn.service.AccountService;
import cn.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void run1(){
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取配置文件(拿接口的类对象)
        AccountService as = ac.getBean("accountService", AccountService.class);
        //调用方法
        as.findAll();
    }
}
