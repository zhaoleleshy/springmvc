package cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 常用注解
 */
@Controller
@RequestMapping("/anno")
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println("执行了");
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("执行了SessionAttributes");
        model.addAttribute("msg","美美");
        return "success";
    }
}
