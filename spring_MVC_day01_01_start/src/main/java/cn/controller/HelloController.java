package cn.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 控制器类
 */
@Controller
@RequestMapping(path = "/user")
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("Hello StringMVC");
        return "success" ;
    }

    /**
     * 测试RequestMapping
     * @return
     */
    @RequestMapping(value = "/requestMapping",
                    params = {"username=heihei"},
                    headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("测试RequestMapping...");
        return "success";
    }
}
