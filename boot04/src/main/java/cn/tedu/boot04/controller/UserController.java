package cn.tedu.boot04.controller;

import cn.tedu.boot04.entity.User;
import cn.tedu.boot04.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserMapper mapper;

    @RequestMapping("/reg")
    public String reg(@RequestBody User user){

        String username= user.getUsername();
        String password=user.getPassword();
        String nick=user.getNick();
        if(username==null||username.isEmpty()||password==null||password.isEmpty()||nick==null||nick.isEmpty()){
            return "1";
        }
        User u=mapper.selectByUsername(username);
        if(u!=null){
            return "2";
        }

        mapper.insert(user);
        return "3";
    }
}
