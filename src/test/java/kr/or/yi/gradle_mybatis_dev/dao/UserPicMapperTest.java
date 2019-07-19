package kr.or.yi.gradle_mybatis_dev.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_dev.AbstractTest;
import kr.or.yi.gradle_mybatis_dev.dto.UserPic;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserPicMapperTest extends AbstractTest {
	private static UserPicMapper picDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		picDao = new UserPicMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		picDao = null;
	}

	@Test
	public void test01InsertUserPic() throws IOException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		UserPic userPic = new UserPic();
		userPic.setId(1);
		userPic.setName("채지안");
		
		String bio = "2001년 성균관대학교 연기예술학과에 입학하여 연출을 하다가 지도교수 눈에 띄어 연극을 한 것을 계기가 되어 연기에 입문하였다. 2004년 부산의 가마골 소극장[3]에서 연극 '서툰 사람들'의 화이라는 역을 맡았다. '서툰 사람들'은 2개월 정도의 장기 공연이었고 화이 역에 이민정을 포함해 4명의 배우가 캐스팅되었는데 이민정은 가장 화이 같은 배우라는 평을 들었다고 한다.[4]\r\n" + 
				"\r\n" + 
				"이후 장진의 '아는 여자'로 영화에 데뷔했다. 공식적인 첫 번째 주연작은 민병훈의 '포도나무를 베어라'이다.[5] 첫 주연작인 이 영화에서 1인 2역을 소화했는데 두 인물 간의 차이를 두기 위해서 각기 다른 렌즈를 착용했다고 한다. 영화 자체는 평론가들의 호평을 받았으나 독립영화의 특성상 큰 흥행은 하지 못했다. \r\n" + 
				"\r\n" + 
				"첫 번째 TV 드라마 출연작은 SBS에서 2005년 방송한 금요드라마 '사랑공감'이다. 여기서는 딸 하나를 가진 이혼녀를 연기했다.\r\n" + 
				"\r\n" + 
				"MBC의 '있을 때 잘해, 깍두기, 누구세요' 등 몇몇 드라마와 영화에 조, 단역으로 출연했으나 주목받지는 못했다.\r\n" + 
				"\r\n" + 
				"2009년 '꽃보다 남자'에서 남자 주인공 구준표(이민호 분)의 약혼녀 하재경으로 출연하면서 주목을 받기 시작했다. 2009년 '그대 웃어요'에서 처음으로 주연에 발탁되면서 좋은 연기를 보여주며 입지를 굳혔다.\r\n" + 
				"\r\n" + 
				"'그대 웃어요'의 인기로 디시인사이드에 이민정 갤러리가 생성되었다. 이민정 역시 스스로도 '그대 웃어요'의 주연으로 발탁된 것을 중요하게 생각 하는 듯.[6] ";
		userPic.setBio(bio);
		userPic.setPic(getPicfile());
		int result = picDao.insertUserPic(userPic);
		Assert.assertEquals(1, result);
	}

	private byte[] getPicfile() throws IOException{
		byte[] pic = null;
		File file = new File(System.getProperty("user.dir") + "\\images\\채지안2.jpg");
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){
			pic = new byte[bis.available()];
			bis.read(pic);
			return pic;
	}
		
	}

	@Test
	public void test02SelectUserPic() throws IOException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		UserPic userPic = new UserPic();
		userPic.setId(1);
		
		UserPic searchPic = picDao.selectUserPic(userPic);
		Assert.assertNotNull(searchPic);
		
		if(searchPic.getPic() != null) {
			File file = getPicFile(searchPic);
			log.debug("file path = " + file.getAbsolutePath());
		}
	}

	private File getPicFile(UserPic userPic) throws IOException {
		File pics = new File(System.getProperty("user.dir")+"\\pics\\");
		if(!pics.exists()) {
			pics.mkdir();
		}
		File pic = new File(pics, userPic.getName() + ".jpg");
		try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(pic))){
			bos.write(userPic.getPic());
		}
		return pic;
	}
	
	@Test
	public void test03deleteUserPic() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		UserPic userPic = new UserPic();
		userPic.setId(1);
		
		int result = picDao.deleteUserPic(userPic);
		Assert.assertEquals(1, result);
	
	}

}
