package com.springboot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.entity.Todo;
import com.springboot.service.TodoService;

@Controller
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@GetMapping("/list-todos")
	public String showTodosList(ModelMap model) {
		String user = getLoggedInUsername();
		model.put("todos", service.retrieveTodos(user));
		return "list-todos";
	}

	private String getLoggedInUsername() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}
	
	@GetMapping("/add-todo")
	public String showAddTodo(ModelMap model) {
		model.addAttribute("todo",new Todo(0,getLoggedInUsername(),"",new Date(),false));
		return "add-todo";
	} 
	
	@PostMapping("/add-todo")
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "add-todo";
		}
		String user = getLoggedInUsername();
		service.addTodo(user, todo.getDesc(), todo.getTargetDate(), false);
		return "redirect:/list-todos";
	}
	 
	@GetMapping("/update-todo")
	public String showUpdateTodo(@RequestParam Integer id, ModelMap model) {
		Todo todo = service.retrieveTodo(id);
		model.put("todo", todo);
		return "add-todo";
	}
	
	@PostMapping("/update-todo")
	public String Todo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "add-todo";
		}
		todo.setUser((String)model.get("name"));
		service.updateTodo(todo);
		return "redirect:/list-todos";
	}
	
	@GetMapping("/delete-todo")
	public String deleteTodo(@RequestParam Integer id) {
		service.deleteTodo(id);
		return "redirect:/list-todos";
	}
}
