package textSQL;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//添加用户到数据库实现注册
public class updateUser {

    public void updateuser(String user_name,String user_password,String identity) throws ClassNotFoundException, SQLException  {
        String URL="jdbc:mysql://127.0.0.1:3306/new_schema?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT";
        String USER="dubai";
        String PASSWORD="qq2572891795";
        //1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获得数据库链接
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
        String s="UPDATE user SET identity='"+identity+"' WHERE user_name='"+user_name+"';";
        Statement stmt=conn.createStatement();//创建一个Statement对象
        stmt.executeUpdate(s);//执行SQL语句

        stmt.close();
        conn.close();
    }
}
