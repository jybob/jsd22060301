package cn.tedu.jsd22060301.controller;

import cn.tedu.jsd22060301.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class BMIController {
    @RequestMapping("/bmi")
    @ResponseBody
    public String bmi(User user) {
        double bmi;
        double h = user.getHeight();
        double w = user.getWeight();
        bmi = w / h / h;
        return "您的bmi值为:"+bmi;
//        System.out.println("您的bmi值为:" + bmi);
    }
}
