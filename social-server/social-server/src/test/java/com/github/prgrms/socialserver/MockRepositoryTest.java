package com.github.prgrms.socialserver;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.prgrms.socialserver.domain.Users;
import com.github.prgrms.socialserver.service.JdbcUsersRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(properties = "server.port=8081")
public class MockRepositoryTest {
	
//	@Mock
//	@Autowired
//	private UserRepository userRepository;
	@Autowired
	JdbcUsersRepository userRepository;
	
	@Test
	public void findByIdTest() {
		
		//MockitoAnnotations.initMocks(this);
		// 아래 코드로도 Mock 객체 생성 가능
		// Animal animal = mock(Animal.class);
		Users user = new Users("user5", "test@naver.com", "1111");
		userRepository.allUsers();
		System.out.println(user.getUserId());
		Long returnLong = userRepository.save(user);
		System.out.println(returnLong);
		System.out.println(userRepository.findById("user1"));
		userRepository.findById("user1");
		
//		assertTrue(userRepository.findById("user5")==null);
		assertTrue(userRepository.findById("user5").getUserId().equals(user.getUserId()));
	}
	
	

}
