package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scan.next();
        System.out.println("请输入密码:");
        String password = scan.next();
        System.out.println("请输入昵称");
        String nick = scan.next();
        List<String> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConn();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select id from user where username='" + username + "'");
            if(rs.next()){
                System.out.println("用户名已存在");
                return;
            }
            s.executeUpdate("insert into user values(null,'" + username + "','" + password + "','" + nick + "')");
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
