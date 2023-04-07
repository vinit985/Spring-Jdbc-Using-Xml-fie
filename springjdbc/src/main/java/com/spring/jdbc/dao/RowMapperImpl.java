package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entites.Student;

public class RowMapperImpl implements RowMapper<Student>{

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Student s =new Student();
		s.setId(rs.getInt(1));
		s.setName(rs.getString(2));
		s.setCity(rs.getString(3));
		
	return s;
	}

}
