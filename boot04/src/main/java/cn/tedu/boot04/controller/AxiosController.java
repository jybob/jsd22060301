package cn.tedu.boot04.controller;

import cn.tedu.boot04.entity.Bmi;
import cn.tedu.boot04.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AxiosController {
    @RequestMapping("/helloAxios")
    public String helloAxios(String info){
        return "测试成功！info="+info;
    }

    @RequestMapping("/postAxios")

    public String postAxios(@RequestBody User user){

        return "测试成功！"+user.toString();
    }

    @RequestMapping("/multi")
    public String multi(@RequestBody Bmi bmi){
        double h= bmi.getHeight();
        double w=bmi.getWeight();
        double result=w/h/h;
        return "您的bmi值为:"+result;
    }

}
