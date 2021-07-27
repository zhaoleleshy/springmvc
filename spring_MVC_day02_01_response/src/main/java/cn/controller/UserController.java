package cn.controller;

import cn.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了...");

        User user = new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(18);

        //model对象
        model.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid方法执行了...");
        //请求转发
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
        //response.sendRedirect(request.getContextPath()+"/index.jsp");

        //设置响应体中文乱码
        response.setContentType("text/html;charset=UTF-8");
        //直接会进行响应
        response.getWriter().println("你好");
    }


    /**
     * 返回ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("testModelAndView...");
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setUsername("郭盼静");
        user.setPassword("456");
        user.setAge(23);

        //把user对象存储到mv对象当中去,也会把user对象存储到request对象当中去
        mv.addObject("user",user);

        //跳转到那个页面
        mv.setViewName("success");
        return mv;
    }

    /**
     * 模拟异步请求响应
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax( @RequestBody User user) {
        System.out.println("testAjax方法执行了...");
        //客户端发送Ajax的请求,传的是json字符串,后端把json字符串封装到user对象里
        System.out.println(user);
        //做响应,模拟查询数据库
        user.setUsername("xiaomei");
        user.setAge(10);
        //做响应
        return user;
    }
}
