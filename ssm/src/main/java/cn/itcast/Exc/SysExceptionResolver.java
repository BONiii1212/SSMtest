package cn.itcast.Exc;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        SysException exception=null;
        if(e instanceof SysException){
            exception=(SysException)e;
        }else{
            exception=new SysException("系统正在维护中");
        }
        //创建ModelAndView对象
        System.out.println("有执行这个拉");
        ModelAndView mv=new ModelAndView();
        mv.addObject("errorMsg",exception.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
