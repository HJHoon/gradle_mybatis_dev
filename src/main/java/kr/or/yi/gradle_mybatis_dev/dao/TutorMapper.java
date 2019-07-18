package kr.or.yi.gradle_mybatis_dev.dao;

import kr.or.yi.gradle_mybatis_dev.dto.Tutor;

public interface TutorMapper {
	Tutor selectTutorById(Tutor tutor);
}
