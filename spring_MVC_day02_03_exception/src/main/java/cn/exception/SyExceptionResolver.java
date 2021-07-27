package cn.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class SyExceptionResolver implements HandlerExceptionResolver {
    /**
     *  处理异常的业务逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取到异常对象
        SyException ex = null;
        if (e instanceof SyException){
            ex = (SyException)e;
        }else {
            ex = new SyException("系统正在维护...");
        }
        // 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg",ex.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
