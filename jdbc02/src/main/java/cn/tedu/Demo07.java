package cn.tedu;

import java.sql.*;
import java.util.Scanner;

public class Demo07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scan.nextLine();
        System.out.println(username);
        System.out.println("请输入密码:");
        String password = scan.nextLine();
        System.out.println(password);
        try (Connection conn = DBUtils.getConn()) {
//            Statement s = conn.createStatement();
//            ResultSet rs = s.executeQuery("select count(*) from user where username='" + username + "' and password='" + password + "'");

            String sql="select count(*) from user where username=? and password=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            rs.next();
            int d = rs.getInt(1);
            if (d > 0) {
                System.out.println("登陆成功");
            } else {
                System.out.println("用户名或者密码错误");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
