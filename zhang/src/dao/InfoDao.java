package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import entity.Info;
import util.DBUtil;

import static util.DBUtil.getConnection;

public class InfoDao {
    /**
     * 单例模式，懒汉模式
     */
    private static InfoDao infoDao;

    public static InfoDao getInfoDao() {
        if(infoDao == null) {
            infoDao = new InfoDao();
        }
        return infoDao;
    }

    public void change(String id, String name, String sex,String grade) throws Exception {
        String sql = "UPDATE gg SET name= '" + name + "',sex= '" + sex + "' ,grade = '" +grade+"'WHERE Id =" + id;
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }
    public void add(String id, String name, String sex,String grade) throws Exception {
        String sql ="INSERT INTO gg (Id,name,sex,grade) VALUES ( '"+id+"','"+name+"','"+sex+"','"+grade+"')" ;
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }
    public void move(String id) throws Exception {
        String sql = "DELETE from gg WHERE Id ="+id;
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeUpdate();
    }

    public static List<Info> findAll() throws Exception {
        String sql = "SELECT * FROM gg";
        List<Info> infos = new ArrayList<>();
        //executeQuery用于产生单个结果集的语句，例如 SELECT 语句
        ResultSet rs = select(sql);
        //getMetaData()得到结果集的结构
        ResultSetMetaData data = rs.getMetaData();
        while (rs.next()) {
            Info info = new Info();
            //i必须从1开始，为第一列的意思
            for (int i = 1; i <= data.getColumnCount(); i++) {
                // 获得指定列的列值
                String columnValue = rs.getString(i);
                switch (i) {
                    case 1: {
                        info.setId(columnValue);
                        break;
                    }
                    case 2: {
                        info.setName(columnValue);
                        break;
                    }
                    case 3: {
                        info.setSex(columnValue);
                        break;
                    }
                    case 4: {
                        info.setGrade(columnValue);
                    }
                    default:break;
                }
            }
            infos.add(info);
        }
        return infos;
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
