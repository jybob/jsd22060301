package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02 {
    public static void main(String[] args) {
        try {
            Connection conn=DBUtils.getConn();
            Statement s=conn.createStatement();
            s.executeUpdate("insert into user values (null,'jerry','123123','杰瑞'),(null,'tom','111','汤姆')");
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
