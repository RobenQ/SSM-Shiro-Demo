package controller;

import Aop.Aop1;
import bean.Admin;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import serviceImpl.AdminServiceImpl;
import serviceImpl.UserServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("needPerms")
    public String needPerms(){
        return "needPerms";
    }

}
