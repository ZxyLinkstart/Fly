package util;


import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtil {
    public static Connection getConnection() throws Exception {
        //com.mysql.jdbc.Driver为Mysql驱动名
        //用了最新的mysql连接驱动,按照最新官方提示支持将com.mysql.jdbc.Driver  改为  com.mysql.cj.jdbc.Driver,
        String driverName = "com.mysql.jdbc.Driver";
        //String driverName = "com.mysql.jdbc.Driver";

        //你需要显式禁用SSL设置usessl = false提供服务器证书验证信任库
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
        String userName = "root";
        String userPWD = "root";

        //将驱动程序的类文件动态加载到内存中，并将其自动注册
        Class.forName(driverName);

        //打开一个连接，要求传递数据库URL，用户名和密码
        Connection connection = DriverManager.getConnection(url, userName, userPWD);
        return connection;
    }
}