package kh.mclass.bbb.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
public class MemberRes {
	private String memId;
	private String memPwd;
	private String memEmail;
}
