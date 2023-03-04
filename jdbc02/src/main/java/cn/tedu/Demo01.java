package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) {
        try {
            Connection conn=DBUtils.getConn();
            Statement s= conn.createStatement();
            s.executeUpdate("create table hero(name varchar(20),age int)");
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
