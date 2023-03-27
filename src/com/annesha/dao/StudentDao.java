package com.annesha.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.annesha.bean.Student;

public class StudentDao {
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Student student) {
		String query = "insert into student(rollno,studentname,standard,marks) values('"+student.getRollno()+"','"+student.getStudentname()+"','"+student.getStandard()+"','"+student.getMarks()+"')";
		return template.update(query);
	}

	public List<Student> getStudents(){
		String query ="select * from student";
		return template.query(query, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int row) throws SQLException {
				// TODO Auto-generated method stub
				Student student = new Student();
				student.setRollno(rs.getInt(1));
				student.setStudentname(rs.getString(2));
				student.setStandard(rs.getString(3));
				student.setMarks(rs.getInt(4));
				return student;
			}
		});
	}
	
	public Student getStudentByID(int studentID) {
		String query="select * from student where rollno=?";
		return template.queryForObject(query, new Object[]{studentID}, new BeanPropertyRowMapper<Student>(Student.class) {
			@Override
			public Student mapRow(ResultSet rs, int row) throws SQLException {
				Student student = new Student();
				student.setRollno(rs.getInt(1));
				student.setStudentname(rs.getString(2));
				student.setStandard(rs.getString(3));
				student.setMarks(rs.getInt(4));
				return student;
			}
		});
	}
	
	public int update(Student student) {
		String query="update student set studentname='"+student.getStudentname()+"',standard='"+student.getStandard()+"',marks='"+student.getMarks()+"' where rollno='"+student.getRollno()+"'";
		System.out.println("update query : "+query);
		return template.update(query);
	}
	
	public int delete(int roll) {
		String query="delete from student where rollno="+roll;
		System.out.println("delete query : "+query);
		return template.update(query);
	}
	
	

}
