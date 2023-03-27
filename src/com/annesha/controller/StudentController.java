package com.annesha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.annesha.bean.Student;
import com.annesha.dao.StudentDao;

@Controller
public class StudentController {
	
	@Autowired
	StudentDao dao;
	
	@RequestMapping(value="/showstdform") 
	public String showstudentform(Model m) {
		m.addAttribute("command", new Student());
		return "studentformpage";
	}
	
	@RequestMapping(value="/save", method= RequestMethod.POST) 
	public String save(@ModelAttribute("student") Student student) {
		dao.save(student);
		return "redirect:/viewstudent";
	}
	
	@RequestMapping(value="/viewstudent") 
	public String viewstudent(Model m) {
		List<Student> list = dao.getStudents();
		m.addAttribute("list", list);
		return "viewstudentpage";
	}
	
	@RequestMapping(value="/editstudentform/{rollno}") 
	public String editStudentfor(@PathVariable int rollno,  Model m) {
		Student student = dao.getStudentByID(rollno);
		m.addAttribute("command", student);
		return "studenteditform";
	}

	
	@RequestMapping(value="/editsave", method= RequestMethod.POST) 
	public String editstudent(@ModelAttribute("student") Student student) {
		dao.update(student);
		return "redirect:/viewstudent";
	}
	
	@RequestMapping(value="/deletestudent/{rollno}") 
	public String editStudentfor(@PathVariable int rollno) {
		dao.delete(rollno);
		return "redirect:/viewstudent";
	}
}
