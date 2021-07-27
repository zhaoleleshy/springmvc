package cn.controller;

import cn.exception.SyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws SyException{
        System.out.println("testException方法...");

        try {
            //模拟异常
            int a = 10/0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SyException("查询用户出现错误了...");
        }

        return "success";
    }
}
