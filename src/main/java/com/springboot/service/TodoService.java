package com.springboot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.entity.Todo;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
    
    public Todo retrieveTodo(Integer id) {
        for (Todo todo : todos) {
            if (todo.getId()==id) {
                return todo;
            }
        }
        return null;
    }

    public void addTodo(String name, String desc, Date targetDate,
            boolean isDone) {
    	int size = todos.size();
        Todo todo = new Todo(++size, name, desc, targetDate, isDone);
		todos.add(todo);
    }
    
    public void updateTodo(Todo todo) {
    	
    	for(Todo getTodo : todos) {
    		if(getTodo.getId()==todo.getId()) {
    			getTodo.setDesc(todo.getDesc());
    			getTodo.setTargetDate(todo.getTargetDate());
    		}
    	}
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }
}