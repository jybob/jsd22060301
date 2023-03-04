package cn.tedu.boot01.controller;

import cn.tedu.boot01.entity.User;
import cn.tedu.boot01.utils.DBUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class UserController {
    @RequestMapping("/regUser")
    @ResponseBody
    public String reg(User user) {
        System.out.println("user=" + user);
        try (Connection conn = DBUtils.getConn()) {

            String sql = "select id from user where username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return "用户已存在！";
            }
            String insert_sql="insert into user values(null,?,?,?)";
            PreparedStatement ps1= conn.prepareStatement(insert_sql);
            ps1.setString(1, user.getUsername());
            ps1.setString(2, user.getPassword());
            ps1.setString(3, user.getNickname());
            ps1.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return "注册成功！";
    }
    @RequestMapping("/loginUser")
    @ResponseBody
    public String login(User user){
        System.out.println("user = " + user);
        try (Connection conn=DBUtils.getConn()){
            String sql="select password from user where username=?";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                if(rs.getString(1).equals(user.getPassword())){
                    return "登录成功";
                }else{
                    return "密码错误！";
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

       return "用户不存在";
    }
}
