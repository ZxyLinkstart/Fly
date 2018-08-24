package dao;

import entity.Welcome;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import static util.DBUtil.getConnection;

public class WelcomeDao {
    private static Welcome infoDao;

    public static Welcome getInfoDao() {
        if(infoDao == null) {
            infoDao = new Welcome();
        }
        return infoDao;
    }

    public static List<Welcome> findAll() throws Exception {
        String sql = "SELECT * FROM wel";
        List<Welcome> infos = new ArrayList<>();
        //executeQuery用于产生单个结果集的语句，例如 SELECT 语句
        ResultSet rs = select(sql);
        //getMetaData()得到结果集的结构
        ResultSetMetaData data = rs.getMetaData();
        while (rs.next()) {
            Welcome info = new Welcome();
            //i必须从1开始，为第一列的意思
            for (int i = 1; i <= data.getColumnCount(); i++) {
                // 获得指定列的列值
                String columnValue = rs.getString(i);
                switch (i) {
                    case 1: {
                        info.setName(columnValue);
                        break;
                    }
                    case 2: {
                        info.setPassword(columnValue);
                    }
                    default:break;
                }
            }
            infos.add(info);
        }
        rs.close();
        return infos;
    }

    public static void newOne(String name, String password) throws Exception {
        String sql ="INSERT INTO wel (name,password) VALUES ( '"+name+"','"+password+"')" ;
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }


    public static ResultSet select(String sql) throws Exception {
        Connection connection = getConnection();
        //当计划要多次使用SQL语句时使用。PreparedStatement接口在运行时接受输入参数。
        PreparedStatement stmt = connection.prepareStatement(sql);
        //SQL语句执行后从数据库查询读取数据，返回的数据放在结果集中
        //executeQuery用于产生单个结果集的语句，例如 SELECT 语句
        //stmt.execute(sql);
        return stmt.executeQuery(sql);
    }


}
