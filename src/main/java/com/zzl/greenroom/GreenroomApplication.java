package com.zzl.greenroom;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;





@SpringBootApplication()
@MapperScan("com.zzl.greenroom.module.system.dao")
public class GreenroomApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(GreenroomApplication.class, args);
	}

}
