package kh.mclass.demo4;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class Demo4Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo4Application.class, args);
//		Arrays.stream(SpringApplication.run(Demo4Application.class, args).getBeanDefinitionNames())
//		.filter(s->s.contains("demo"));
//		.forEach(System.out::println);
	}

}
