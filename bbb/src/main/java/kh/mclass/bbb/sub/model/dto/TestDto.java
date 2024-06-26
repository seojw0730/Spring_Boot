package kh.mclass.bbb.sub.model.dto;

import org.springframework.stereotype.Component;

@Component("testDto")
public class TestDto {
	private String a1;
	private String a2;
	private TestFileDto testFileDto;

	private void init() {
		//초기값 설정
		System.out.println("init()");
	}
	@Override
	public String toString() {
		return "TestDto [a1=" + a1 + ", a2=" + a2 + ", testFileDto=" + testFileDto + "]";
	}

	public TestDto() {
		super();
	}

	public TestDto(String a1, String a2, TestFileDto testFileDto) {
		super();
		//init(); xml파일에서 init-method에 넣어주면 여긴 필요 없음
		this.a1 = a1;
		this.a2 = a2;
		this.testFileDto = testFileDto;
	}

	public TestDto(String a2) {
		super();
		this.a2 = a2;
	}

	public String getA1() {
		return a1;
	}

	public void setA1(String a1) {
		this.a1 = a1;
	}

	public String getA2() {
		return a2;
	}

	public void setA2(String a2) {
		this.a2 = a2;
	}

	public TestFileDto getTestFileDto() {
		return testFileDto;
	}

	public void setTestFileDto(TestFileDto testFileDto) {
		this.testFileDto = testFileDto;
	}

}
