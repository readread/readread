package com.readread;
import java.sql.*;
public class JDBCTest {
	public static void main(String[] args){

        // 驱动程序名
        String driver = "com.mysql.jdbc.Driver";

        // URL指向要访问的数据库名scutcs
        String url = "jdbc:mysql://127.0.0.1:3306/mysql";

        // MySQL配置时的用户名
        String user = "root"; 

        // MySQL配置时的密码
        String password = "admin";

        try { 
       

         // 连续数据库
         Connection conn = DriverManager.getConnection(url, user, password);

         if(!conn.isClosed()) 
          System.out.println("Succeeded connecting to the Database!");

         // statement用来执行SQL语句
         Statement statement = conn.createStatement();

         // 要执行的SQL语句
         String sql = "select * from read_article";

         // 结果集
         ResultSet rs = statement.executeQuery(sql);

         System.out.println("-----------------");
         System.out.println("执行结果如下所示:");
         System.out.println("-----------------");
         System.out.println(" 学号" + "\t" + " 姓名");
         System.out.println("-----------------");

         String name = null;

         while(rs.next()) {
 
          // 选择sname这列数据
          name = rs.getString("title");
 
         

          // 输出结果
          System.out.println(rs.getString("article_key") + "\t" + name);
         }

         rs.close();
         conn.close();

        }  catch(SQLException e) {


         e.printStackTrace();


        } catch(Exception e) {


         e.printStackTrace();


        } 
} 
}
