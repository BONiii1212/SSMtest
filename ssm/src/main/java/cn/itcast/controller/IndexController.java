package cn.itcast.controller;

import cn.itcast.domain.Commodity;
import cn.itcast.domain.Order;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@SessionAttributes(value = {"username","password","commodity"})
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private UserService userService;

    /**注册按钮的页面跳转
     * @return
     */
    @RequestMapping("/register")
    public String register(){

        return "register";
    }

    /**注册界面返回首页的页面跳转
     * @param response
     * @param request
     * @throws Exception
     */
    @RequestMapping("/boom")
    public void boom(HttpServletResponse response,HttpServletRequest request) throws Exception {
        System.out.println("执行了");
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

    /**测试方法
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public String login(User user){
        return "list";
    }

    /**登录界面中登录的AJAX异步请求
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/testAjax")
    public @ResponseBody String testAjax(@RequestBody User user, Model model) {
        System.out.println("Ajax执行了");
        System.out.println(user);
        User user1=userService.findByUsername(user.getUsername());
        System.out.println(user1);
        if(user.getPassword().equals(user1.getPassword())==true){
            List<Commodity> list=user1.getCommodity();
            for(Commodity commodity:list){
                System.out.println(commodity);
            }
            System.out.println("账号密码正确");
            //将用户信息以键值对的形式存到Model对象中
            model.addAttribute("username",user1.getUsername());
            model.addAttribute("password",user1.getPassword());
            model.addAttribute("commodity",user1.getCommodity());
            model.addAttribute("order",user1.getOrder());
            return "YES";
        }else{
            System.out.println("账号密码错误");
            return "NO";
        }
    }

    /**注册界面中注册的AJAX的异步请求
     * @param user
     * @return
     */
    @RequestMapping("/testAjax1")
    public @ResponseBody String testAjax1(@RequestBody User user) {
        System.out.println(user);
       if(userService.findByUsername(user.getUsername())!= null){
           System.out.println("用户名已存在");
           return "False";
       }
       else{
           userService.createUser(user);
           System.out.println("存储成功");
           return "True";
       }
    }
}
