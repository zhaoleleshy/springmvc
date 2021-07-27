package cn.controller;

import cn.domain.Account;
import cn.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *请求参数绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * 请求参数绑定
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println("执行了....");
        System.out.println(username+"-"+password);
        return "success";
    }

    /**
     * 把请求参数封装到JavaBean类当中
     * @param account
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("封装JavaBean执行了....");
        System.out.println(account);
        return "success";
    }

    /**
     * 把自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveAccount(User user){
        System.out.println("自定义类型转换器执行了....");
        System.out.println(user);
        return "success";
    }

    /**
     * 把自定义类型转换器
     * @param
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("原生的API....");
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);
        return "success";
    }
}
