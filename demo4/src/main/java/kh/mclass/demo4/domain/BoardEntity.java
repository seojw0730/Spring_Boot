package kh.mclass.demo4.domain;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data//toString+getter/setter+NoArgsConstructor     lombok 제대로 설치 안되면 toString 누락되는 경우 발생
//@NoArgsConstructor
@AllArgsConstructor//NoArgsConstructor 지워버림
@Component//bean 생성을 하는데 NoArgsConstructor 작동하지 않아 문제 발생
@RequiredArgsConstructor
public class BoardEntity {
//	@NonNull
	private String boardId;
	
//	@NonNull
	private String boardTitle;
	
	private String boardContent;
}
