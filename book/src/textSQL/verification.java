package textSQL;

//用户登录

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import GraIterface.bookAdmin;
import GraIterface.userAdmin;
import GraIterface.userGraIterface;

public class verification {
	public String zhanghao;
	public String mima;
    public void verifications(String userName,String password) throws ClassNotFoundException, SQLException  {
        String URL="jdbc:mysql://127.0.0.1:3306/new_schema?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT";
        String USER="dubai";
        String PASSWORD="qq2572891795";
        //1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获得数据库链接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        String s="select user_name,user_password from user where user_name=? and user_password=? ";
        PreparedStatement pst=conn.prepareStatement(s);

        pst.setString(1, userName);
        pst.setString(2, password);
        ResultSet rs=pst.executeQuery();
        //4.处理数据库的返回结果(使用ResultSet类)

        
//异常处理---------------------------------------------------
        if(userName.length()==0||password.length()==0) {
        	JOptionPane.showMessageDialog(null, "账户或密码为空，程序退出");
        	System.exit(0);
        }
        if(!userName.matches("[0-9A-Za-z]*")) {
        	JOptionPane.showMessageDialog(null, "用户名只能是数字或者字母！");
        	System.exit(0);
        }
//判断用户身份（管理员）-----------------------------------------
        if(rs.next()) {
        	String a="select user_name,user_password,identity from user where user_name=? and user_password=? and identity=?";
        	PreparedStatement pstadmin=conn.prepareStatement(a);
        	pstadmin.setString(1, userName);
        	pstadmin.setString(2, password);
        	pstadmin.setString(3, "useradmin");
        	
        	ResultSet userAdmin=pstadmin.executeQuery();
        	if(userAdmin.next()){
        		userAdmin useradmin = new userAdmin();
        		useradmin.setVisible(true);
        	}
//判断用户身份（借阅者）-----------------------------------------
        	String b="select user_name,user_password from user where user_name=? and user_password=? and identity=?";
        	PreparedStatement pstuser=conn.prepareStatement(b);
        	pstuser.setString(1, userName);
        	pstuser.setString(2, password);
        	pstuser.setString(3,"user");
        	
        	ResultSet userGra=pstuser.executeQuery();
        	if(userGra.next()) {
        		userGraIterface user = new userGraIterface();
        		this.zhanghao = userName;
        		this.mima = password;
            	user.setVisible(true);
        	}
//判断用户身份（图书管理员）---------------------------------------
        	String c="select user_name,user_password,identity from user where user_name=? and user_password=? and identity=?";
        	PreparedStatement pstbook = conn.prepareStatement(c);
        	pstbook.setString(1, userName);
        	pstbook.setString(2, password);
        	pstbook.setString(3, "bookadmin");
        	
        	ResultSet userBook = pstbook.executeQuery();
        	if(userBook.next()){
        		bookAdmin bookadmin = new bookAdmin();
        		bookadmin.setVisible(true);
        	}
        	
        	
        }    
        else {
        	JOptionPane.showMessageDialog(null, "账户或密码错误，程序退出");
        }
        //关闭资源
        rs.close();
        pst.close();
        conn.close();
    }

}