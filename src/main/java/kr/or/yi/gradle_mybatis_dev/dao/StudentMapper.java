package kr.or.yi.gradle_mybatis_dev.dao;

import kr.or.yi.gradle_mybatis_dev.dto.Student;

public interface StudentMapper {
	Student selectStudentByNo(Student student);
	Student selectStudentByNoWithResultMap(Student student);
}
