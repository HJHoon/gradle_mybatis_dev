package kr.or.yi.gradle_mybatis_dev.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.yi.gradle_mybatis_dev.dto.UserPic;
import kr.or.yi.gradle_mybatis_dev.jdbc.MyBatisSqlSessionFactory;

public class UserPicMapperImpl implements UserPicMapper {
	private String namespace = "kr.or.yi.gradle_mybatis_dev.dao.UserPicMapper";
	
	@Override
	public int insertUserPic(UserPic userPic) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			int res = sqlSession.insert(namespace + ".insertUserPic",userPic);
			sqlSession.commit();
			return res;
		}
	}

	@Override
	public UserPic selectUserPic(UserPic userPic) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne(namespace + ".selectUserPic", userPic);
		}
		
	}

	@Override
	public int deleteUserPic(UserPic userPic) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.delete(namespace + ".deleteUserPic", userPic);
		}
	}

}
