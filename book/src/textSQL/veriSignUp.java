package textSQL;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import GraIterface.userGraIterface;

public class veriSignUp {
    public void verifications(String userName,String password) throws ClassNotFoundException, SQLException  {
        String URL="jdbc:mysql://127.0.0.1:3306/new_schema?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT";
        String USER="dubai";
        String PASSWORD="qq2572891795";
        //1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获得数据库链接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        String s="select user_name,user_password from user where user_name=? and user_password=?";
        PreparedStatement pst=conn.prepareStatement(s);

        pst.setString(1, userName);
        pst.setString(2, password);
        ResultSet rs=pst.executeQuery();
        //4.处理数据库的返回结果(使用ResultSet类)
        if(rs.next()){
        	JOptionPane.showMessageDialog(null, "注册成功，请登录");
        }
        else {
        	JOptionPane.showMessageDialog(null, "注册失败");
        }
        //关闭资源
        rs.close();
        pst.close();
        conn.close();
    }
}

