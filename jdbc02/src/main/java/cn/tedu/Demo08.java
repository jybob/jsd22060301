package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo08 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入姓名");
        String username=scan.nextLine();
        System.out.println("请输入密码");
        String password=scan.nextLine();
        System.out.println("请输入昵称");
        String nick=scan.nextLine();
        try ( Connection conn = DBUtils.getConn()){

            String sql="insert into user values(null,?,?,?)";
            PreparedStatement ps =conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,nick);
            ps.executeUpdate();

        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }
    }
}
