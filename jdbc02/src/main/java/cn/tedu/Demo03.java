package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo03 {
    public static void main(String[] args) {
        try {
            Connection conn=DBUtils.getConn();
            Statement s= conn.createStatement();
            s.executeUpdate("delete from hero where name='猪八戒'");
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
