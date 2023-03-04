package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        try (Connection conn = DBUtils.getConn()) {

            String sql="select * from car";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt(1);
                String title=rs.getString(2);
                String type=rs.getString(3);
                double price=rs.getDouble(4);
                System.out.println(id+","+title+","+type+","+price);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
