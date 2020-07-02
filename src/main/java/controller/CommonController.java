package controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import serviceImpl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CommonController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/")
    public String inSite(){
        return "index";
    }

    @RequestMapping("/main")
    public String toMain(){
        return "main";
    }

    @RequestMapping("/login")
    public void login(HttpServletRequest request) throws Exception {
        //如果登录失败从request中获取认证异常信息,shiroLoginFailure就是shiro异常类的全限定名
        String exceptionClassName= (String) request.getAttribute("shiroLoginFailure");
        System.out.println(exceptionClassName);
        //根据shiro返回的异常类路径判断，抛出指定异常信息
//        if(exceptionClassName!=null){
//            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
//                //最终会抛给异常处理器
//                throw new UnknownAccountException("账号不存在");
//            } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
//                throw new UnknownAccountException("用户名/密码错误");
//            } else if("randomCodeError".equals(exceptionClassName)){
//                throw new UnknownAccountException("验证码错误");
//            } else{
//                throw new Exception();
//            }
//        }
    }

    @RequestMapping("/user")
    @ResponseBody
    public Map user(){
        Map map = new HashMap();
        map.put("user",userService.selectAll());
        return map;
    }

    @RequestMapping("/noPerms")
    public String noPerms(){
        return "noPerms";
    }
    @RequestMapping("/refuse")
    @ResponseBody
    public String refuse(){
        return "No admin Perms";
    }
}
