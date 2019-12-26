package org.student.util;


import org.student.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {
    public static PreparedStatement ps = null;
    public static Connection con = null;
    public static ResultSet rs = null;
//    public Connection getCon() {
//        //反射
//        try {
//            Class.forName(PropertiesUtil.getValue("jdbcDriver"));
//            con = DriverManager.getConnection(PropertiesUtil.getValue("dbUrl"),
//                    PropertiesUtil.getValue("dbUserName"),
//                    PropertiesUtil.getValue("dbPassword")
//            );
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("驱动异常");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("检查驱动以及密码是否正确");
//        }
//        return con;
//    }

//    public void CloseCon(Connection con) {
//        if (con != null) {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//                System.out.println("关闭连接异常");
//            }
//        }
//    }


    public static void main(String[] args) {
        DbUtil db = new DbUtil();
        Connection con = db.getCon();
        System.out.println(con);
    }

    //操作连接数据库
    public static Connection getCon(){
        try {
            Class.forName(PropertiesUtil.getValue("jdbcDriver"));
            con = DriverManager.getConnection(PropertiesUtil.getValue("dbUrl"),
                    PropertiesUtil.getValue("dbUserName"),
                    PropertiesUtil.getValue("dbPassword"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动异常");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("检查驱动以及密码是否正确");
        }

        return con;
    }

    //操作预编译
    public static PreparedStatement createPrepareStatement(String sql,Object[] params) throws SQLException {

        ps = getCon().prepareStatement(sql);
        if(params!=null){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1,params[i]);
            }
        }
        return ps;
    }

    //关闭连接
    public static void closeAll(ResultSet rs,Statement stmt,Connection connection){
        try {
                if(rs!=null)rs.close();
                if(ps!=null)ps.close();
                if(connection!=null)con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    //通用增删改
    public static boolean executeUpdate(String sql, Object[] params) {
        try {
//            DbUtil dbUtil = new DbUtil();
//            con = dbUtil.getCon();
//            String sql ="delete from student where sno=?";
//             ps =getCon().prepareStatement(sql);
            //setXxx()方法的个数依赖于sql语句中 ？ 的个数，而 ？ 的个数又和数组params的个数一致
//              setXxx()方法的个数->数组params的个数一致
//            ps.setInt(1,sno);

            ps = createPrepareStatement(sql, params);
            int count = ps.executeUpdate();
            if (count > 0)
                return true;
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            return false;
        } finally {
            closeAll(null,ps,con);

        }
    }

    //通用的查：返回值是一个集合 (Student,List<Student>,null)
    public static ResultSet executeQuery(String sql,Object[] params){
        List<Student> students = new ArrayList<Student>();
        Student student =null;
        try {
//            DbUtil dbUtil = new DbUtil();
//            con = dbUtil.getCon();
//            String sql ="select * from student";
           ps =  createPrepareStatement(sql,params);
            rs =  ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e){
            return null;
        }
//        finally {
//            try {
//                if(rs!=null)rs.close();
//                if(ps!=null)ps.close();
//                if(con!=null)con.close();
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }

    }


    //查询总数
    public static int getTotalCount(String sql){
        int count = -1;
        try {
            ps = createPrepareStatement(sql, null);
            rs = ps.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeAll(rs,ps,con);
        }
        return count;
    }


}