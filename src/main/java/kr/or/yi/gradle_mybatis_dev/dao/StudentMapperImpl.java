package kr.or.yi.gradle_mybatis_dev.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_dev.dto.Student;
import kr.or.yi.gradle_mybatis_dev.jdbc.MyBatisSqlSessionFactory;

public class StudentMapperImpl implements StudentMapper {
	private String namespace = "kr.or.yi.gradle_mybatis_dev.dao.StudentMapper";
	
	@Override
	public Student selectStudentByNo(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".selectStudentByNo", student);
		}
	}

	@Override
	public Student selectStudentByNoWithResultMap(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".selectStudentByNoWithResultMap", student);
		}
	}
}
