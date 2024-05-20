package kh.mclass.bbb.sub;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//걸어놓고 다른 데서 new 생성 안해줘도 알아서 생성해줌
//@Component div vs. sementic 같은 느낌
@Service("testService")
public class TestService {
	
	public String method1() {
		return "서비스리턴값";
	}
}
