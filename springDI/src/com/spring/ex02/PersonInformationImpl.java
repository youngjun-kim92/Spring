package com.spring.ex02;

public class PersonInformationImpl implements PersonInformation {
	private String name;
	private int age;
	
	
	
	public PersonInformationImpl(String name) {
		super();
		this.name = name;
	}



	public PersonInformationImpl(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}



	@Override
	public void info() {
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
	}
	
	
}
