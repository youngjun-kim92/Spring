package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {

	public static void main(String[] args) {
		//메인메소드 실행시 person.xml을 읽어들여서 bean을 생성
		BeanFactory factory=new XmlBeanFactory(new FileSystemResource("person.xml"));
		
		//id가 personService인 bean을 가져옴
		PersonService person=(PersonService)factory.getBean("personService");
		
		//생성된 bean을 이용해 메소드 수행
		person.sayHello();
	}

}
