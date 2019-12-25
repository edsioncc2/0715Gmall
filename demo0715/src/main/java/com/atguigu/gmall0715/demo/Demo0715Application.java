package com.atguigu.gmall0715.demo;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.gmall0715.demo.mapper")

public class Demo0715Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo0715Application.class, args);
	}

}
