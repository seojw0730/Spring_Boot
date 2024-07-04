package kh.mclass.demo8;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.RETURNS_DEFAULTS;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
//@WebMvcTest
@WebAppConfiguration
class Demo8ApplicationTests {
	// Mock MVC - Controller 역할은 확실히 함. Service, Repository 못함.
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
//	private static EmpService empService; // static: 프로그램 시작 전에 미리 메모리 차지
	private EmpService empService;
	
	@BeforeEach // = JUnit4의 @BeforeClass
//	@BeforeAll
	void setUp() {
		// 주로 Service 객체 생성
//		this.mockMvc = MockMvcBuilders.standaloneSetup(new Demo8Controller()).build(); // Demo8Controller 가지고 기본 생성
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); // 이게 나올 것
		this.empService = new EmpService();
		System.out.println("======= setUp --- @Test 돌릴 준비완료");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("======= tearDown");
	}
	
	@Test
	void loginTest() {
		try {
//			mockMvc.perform(get("/emp")).andDo(print()/*각종 정보 출력*/).andExpect(status().isOk()/*success 조건*/); // ... : 가변인자(1개 이상 들어올 수 있음)
			mockMvc
			.perform(post("/find/area").param("findArea", "서울").param("page", "12"))
			.andDo(print())
			.andExpect(status().isNotFound());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Test 들은 랜덤한 순서로 실행.
	@Test
	void contextLoads() {
		System.out.println("======= contextLoads");
		String a = "aaa";
		String b = "aaa";
		assertEquals(a, b);
//		assertSame(a, b);
//		assertEquals(a, b);
//		assertTrue(a == b);
//		assertFalse(a == b);
//		assertNotNull(a);
//		assertArrayEquals(arr1, arr2);
	}

	@Test
	void contextLoads2() {
		System.out.println("======= contextLoads2");
		String a = "aaa";
		assertNotNull(a);
	}
	
}
