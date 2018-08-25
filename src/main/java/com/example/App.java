package com.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.example.domain.Customer;

@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner
{
	@Autowired
	CustomerRepository customerRepository;
    
	@Override
	public void run(String... strings) throws Exception { //... varargs 또는 가변인자라고 한다. 객체가 0개부터 여러개까지 매개변수로 올 수 있다라는 뜻 
		// 데이터 추가
		Customer created = customerRepository.save(new Customer(
				null, "Hidetoshi", "Dekisugi"));
		System.out.println(created + "is created");;
		
		// 데이터 표시
		customerRepository.findAll().forEach(System.out::println);
	}
	
	public static void main(String[] args)
    {
        SpringApplication.run(App.class, args);
    }
}
