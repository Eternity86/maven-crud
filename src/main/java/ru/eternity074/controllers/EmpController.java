package ru.eternity074.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ru.eternity074.entities.Emp;
import ru.eternity074.dao.EmpDao;

@Controller
public class EmpController {

	@Autowired
	EmpDao dao;
	
//	@GetMapping("/")
//	public String index() {
//		return "index";
//	}

	@GetMapping("/empform")
	public String showForm(Model m) {
		m.addAttribute("command", new Emp());
		return "empform";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("emp") Emp emp) {
		dao.save(emp);
		return "redirect:/";
	}

	@GetMapping("/")
	public String viewEmp(Model m) {
		List<Emp> list = dao.getEmployees();
		m.addAttribute("list", list);
		return "viewemp";
	}

	@GetMapping("/editemp/{id}")
	public String edit(@PathVariable int id, Model m) {
		Emp emp = dao.getEmpById(id);
		m.addAttribute("command", emp);
		return "empeditform";
	}

	@PostMapping("/editsave")
	public String editSave(@ModelAttribute("emp") Emp emp) {
		dao.update(emp);
		return "redirect:/";
	}

	@GetMapping("/deleteemp/{id}")
	public String delete(@PathVariable int id) {
		dao.delete(id);
		return "redirect:/";
	}

}
