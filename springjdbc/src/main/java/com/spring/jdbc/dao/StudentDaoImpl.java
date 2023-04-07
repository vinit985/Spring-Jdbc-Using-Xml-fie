package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entites.Student;

public class StudentDaoImpl implements StudentDao{
	private JdbcTemplate jdbcTemplate;

	public int insert(Student student) {
	      
		String query ="insert into student(id,name,city) values(?,?,?)";
		int r = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		
		return r;
		
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int change(Student student) {
		String s = "update  student set name=?,city=? where id=?";
		int update = this.jdbcTemplate.update(s,student.getName(),student.getCity(),student.getId());
		return update;
	}

	public int delete(int id) {
		String query =" delete from student where id=?";
		int delete=this.jdbcTemplate.update(query,id);
		return delete;
	}

	public Student getStudent(int id) {
	
		
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
	Student s=	this.jdbcTemplate.queryForObject(query, rowMapper,id);
	return s;
	}

	public List<Student> getAllStudents() {
		
		String query = "select * from student";
		
		List<Student> students=this.jdbcTemplate.query(query,new RowMapperImpl());
		return students;
		
	}


}
