package org.student.dao.impl;

import org.student.dao.IStudentDao;
import org.student.entity.Student;
import org.student.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据访问层：原子性 增删改查  不可修改
 */
public class StudentDaoImpl implements IStudentDao {

    public boolean isExist(int sno){//判断是否存在
       return queryStudentBySno(sno)==null? false:true;
    }

    //添加学生
    public boolean addStudent(Student student){
        String sql ="insert into student values(?,?,?,?)";
        Object[] params = {student.getSno(),student.getSname(),student.getSage(),student.getSaddress()};
        return DbUtil.executeUpdate(sql,params);

    }

    //String sql ="insert into student values(?,?,?,?)";
    //String sql ="update student set sname=?,sage=?,saddress=? where sno=?";
    //String sql ="delete from student where sno=?";
    //String sql ="select * from student";
    //根据学号找到待修改的人，把这个人修改成studnet
    public boolean updateStudentBySno(int sno,Student student){
        String sql ="update student set sname=?,sage=?,saddress=? where sno=?";
        Object[] params = {student.getSname(),student.getSage(),student.getSaddress(),sno};
        return DbUtil.executeUpdate(sql,params);
    }

    //根据学号删除学生
    public boolean deleteStudentBySno(int sno){
        String sql ="delete from student where sno=?";
        Object[] params ={sno};
        return  DbUtil.executeUpdate(sql,params);
    }

    //查询全部
    public List<Student> queryAllStudnets(){
        List<Student> students = new ArrayList<Student>();
        Student student =null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            String sql ="select * from student";

            rs = DbUtil.executeQuery(sql, null);
            while(rs.next()){
                int no = rs.getInt("sno");
                String name = rs.getString("sname");
                int age = rs.getInt("sage");
                String address = rs.getString("saddress");
                student = new Student(no,name,age,address);
                students.add(student);
            }
            return students;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return null;
        } catch (Exception e){
            return null;
        }
        finally {
           DbUtil.closeAll(rs,ps,DbUtil.con);

        }

    }


    //根据学号查人
    public Student queryStudentBySno(int sno){
        Student student =null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con =null;
        
        try {
            DbUtil dbUtil = new DbUtil();
            con = dbUtil.getCon();
            String sql ="select * from student where sno=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,sno);
            rs =  ps.executeQuery();
            if(rs.next()){
                int no = rs.getInt("sno");
                String name = rs.getString("sname");
                int age = rs.getInt("sage");
                String address = rs.getString("saddress");
                student = new Student(no,name,age,address);
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e){
            return null;
        }
       finally {
            try {
                if(rs!=null)rs.close();
                if(ps!=null)ps.close();
                if(con!=null)con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        }

        //查询总数据量
    @Override
    public int getTotalCount() {
        String sql = "select count(1) from student";
        return DbUtil.getTotalCount(sql);
    }

    @Override
    public List<Student> queryStudentsByPage(int currentPage, int pageSize) {
       String sql = "select * from student limit ?,?";
       Object[] params = {(currentPage-1)*pageSize,pageSize};
       List<Student> students = new ArrayList<Student>();
        ResultSet rs = DbUtil.executeQuery(sql, params);

            try {
                while (rs.next()){
                    Student student = new Student(rs.getInt("sno"),
                            rs.getString("sname"),
                            rs.getInt("sage"),
                            rs.getString("saddress"));
                    students.add(student);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e ){
                e.printStackTrace();
            }


        return students;
    }


}
