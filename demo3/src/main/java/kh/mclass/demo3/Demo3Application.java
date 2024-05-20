package kh.mclass.demo3;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import kh.mclass.demo3.Demo3Application;

@SpringBootApplication
public class Demo3Application {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(Demo3Application.class, args);
		//주입된 객체들 확인
		String[] beansNameArr = appContext.getBeanDefinitionNames();
		
		System.out.println("===");
		for(String beanName : beansNameArr) {
			System.out.println(beanName);
		}
//		Arrays.stream(appContext.getBeanDefinitionNames()).forEach(System.out::println);
		System.out.println("=== filter");
		Arrays.stream(appContext.getBeanDefinitionNames()).filter(s->s.contains("board")).forEach(System.out::println);
		System.out.println("===");
	}

}
