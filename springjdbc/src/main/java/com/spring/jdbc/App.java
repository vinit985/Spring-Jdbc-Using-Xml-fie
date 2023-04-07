package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;
import com.spring.jdbc.entites.Student;

public class App 
{
  

	public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
    	StudentDao bean = context.getBean("studentDao",StudentDao.class);
    	List<Student> student = bean.getAllStudents();
    	for(Student s:student)
    	{
    		System.out.println(s);
    	}
    	
    	
    	
           
    }
}
