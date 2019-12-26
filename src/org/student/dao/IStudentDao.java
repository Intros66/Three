package org.student.dao;

import org.student.entity.Student;

import java.util.List;

public interface IStudentDao {
    public boolean isExist(int sno);

    //添加学生
    public boolean addStudent(Student student);

    //根据学号找到待修改的人，把这个人修改成studnet
    public boolean updateStudentBySno(int sno,Student student);

    //根据学号删除学生
    public boolean deleteStudentBySno(int sno);

    //查询全部
    public List<Student> queryAllStudnets();

    //根据学号查人
    public Student queryStudentBySno(int sno);

    //查询总数
    public int getTotalCount();

    //查询当前页的数据集合 current:当前页(页码) pageSize：页面大小（每页的数据量）
    public List<Student> queryStudentsByPage(int currentPage,int pageSize);
}
