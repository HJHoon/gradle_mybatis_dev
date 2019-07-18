package kr.or.yi.gradle_mybatis_dev.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_dev.dto.Tutor;
import kr.or.yi.gradle_mybatis_dev.jdbc.MyBatisSqlSessionFactory;

public class TutormapperImpl implements TutorMapper {
	private String namespace = "kr.or.yi.gradle_mybatis_dev.dao.TutorMapper";
	@Override
	public Tutor selectTutorById(Tutor tutor) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace + ".selectTutorById", tutor);
		}
	}

}
