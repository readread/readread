package com.readread;
import java.sql.*;
public class JDBCTest {
	public static void main(String[] args){

        // ����������
        String driver = "com.mysql.jdbc.Driver";

        // URLָ��Ҫ���ʵ����ݿ���scutcs
        String url = "jdbc:mysql://127.0.0.1:3306/mysql";

        // MySQL����ʱ���û���
        String user = "root"; 

        // MySQL����ʱ������
        String password = "admin";

        try { 
       

         // �������ݿ�
         Connection conn = DriverManager.getConnection(url, user, password);

         if(!conn.isClosed()) 
          System.out.println("Succeeded connecting to the Database!");

         // statement����ִ��SQL���
         Statement statement = conn.createStatement();

         // Ҫִ�е�SQL���
         String sql = "select * from read_article";

         // �����
         ResultSet rs = statement.executeQuery(sql);

         System.out.println("-----------------");
         System.out.println("ִ�н��������ʾ:");
         System.out.println("-----------------");
         System.out.println(" ѧ��" + "\t" + " ����");
         System.out.println("-----------------");

         String name = null;

         while(rs.next()) {
 
          // ѡ��sname��������
          name = rs.getString("title");
 
         

          // ������
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
