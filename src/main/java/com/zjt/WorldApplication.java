package com.zjt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
 @MapperScan("com.zjt.**.mapper")
public class WorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldApplication.class, args);
	}
}
