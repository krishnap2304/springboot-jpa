package com.demo;

import com.demo.model.Employee;
import com.demo.repository.EmployeRepository;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringBootJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Registration and Login Application API")
						.version("1.0")
						.description("Registration and Login Service Description")
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}
	@Bean
	public EmployeRepository getEmplRepository(){
		return new EmployeRepository() {
			@Override
			public Optional<Employee> findByEmpName(String empName) {
				return Optional.empty();
			}

			@Override
			public List<Employee> findAll() {
				return null;
			}

			@Override
			public List<Employee> findAll(Sort sort) {
				return null;
			}

			@Override
			public List<Employee> findAllById(Iterable<Long> iterable) {
				return null;
			}

			@Override
			public <S extends Employee> List<S> saveAll(Iterable<S> iterable) {
				return null;
			}

			@Override
			public void flush() {

			}

			@Override
			public <S extends Employee> S saveAndFlush(S s) {
				return null;
			}

			@Override
			public void deleteInBatch(Iterable<Employee> iterable) {

			}

			@Override
			public void deleteAllInBatch() {

			}

			@Override
			public Employee getOne(Long aLong) {
				return null;
			}

			@Override
			public <S extends Employee> List<S> findAll(Example<S> example) {
				return null;
			}

			@Override
			public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
				return null;
			}

			@Override
			public Page<Employee> findAll(Pageable pageable) {
				return null;
			}

			@Override
			public <S extends Employee> S save(S s) {
				return null;
			}

			@Override
			public Optional<Employee> findById(Long aLong) {
				return Optional.empty();
			}

			@Override
			public boolean existsById(Long aLong) {
				return false;
			}

			@Override
			public long count() {
				return 0;
			}

			@Override
			public void deleteById(Long aLong) {

			}

			@Override
			public void delete(Employee employee) {

			}

			@Override
			public void deleteAll(Iterable<? extends Employee> iterable) {

			}

			@Override
			public void deleteAll() {

			}

			@Override
			public <S extends Employee> Optional<S> findOne(Example<S> example) {
				return Optional.empty();
			}

			@Override
			public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
				return null;
			}

			@Override
			public <S extends Employee> long count(Example<S> example) {
				return 0;
			}

			@Override
			public <S extends Employee> boolean exists(Example<S> example) {
				return false;
			}
		};
	}
}
