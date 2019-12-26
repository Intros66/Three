package org.student.service;

import org.student.entity.Student;

import java.util.List;

public interface IStudentService {
    public Student queryStudentBySno(int sno);

    public List<Student> queryAllStudents();

    public boolean deleteStudentBySno(int sno);

    public boolean updateStudentBySno(int sno,Student student);

    public boolean addStudent(Student student);

    public int getTotalCount();

    public List<Student> queryStudentsByPage(int currentPage,int pageSize);
}
