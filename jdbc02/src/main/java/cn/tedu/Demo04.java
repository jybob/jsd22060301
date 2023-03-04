package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo04 {
    public static void main(String[] args) {
        try {
            Connection conn=DBUtils.getConn();
            Statement s=conn.createStatement();
            s.executeUpdate("update hero set name='齐天大圣' where name='孙悟空'");
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
