package cn.tedu.b00t03.controller;

import cn.tedu.b00t03.entity.User;
import cn.tedu.b00t03.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserMapper mapper;

    @RequestMapping("/reg")
    @ResponseBody
    public String reg(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String nick = user.getNick();
        if (username == null || username.isEmpty() || password == null || password.isEmpty() || nick == null || nick.isEmpty()) {

            return "注册失败！请重新注册";
        }
        User user1=mapper.selectByUsername(username);
        if(user1!=null){
            return "该用户已存在！";
        }

        mapper.insert(user);
        return "注册成功！";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if(username==null||username.isEmpty()||password==null||password.isEmpty()){
            return "输入有误！请重新输入！";
        }
        User user1=mapper.selectByUsername(username);
        if(user1==null){
            return "用户名不存在！";
        }else if(!user1.getPassword().equals(password)){
            return "密码有误！";
        }
        return "登录成功！";
    }


}
