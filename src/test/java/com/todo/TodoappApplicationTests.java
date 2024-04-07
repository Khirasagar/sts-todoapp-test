package com.todo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.todo.entity.Todo;
import com.todo.repository.TodoRepository;

@SpringBootTest
class TodoappApplicationTests {
	@Autowired
	private TodoRepository todoRepository;

	@Test
	void addTodo() {
		Todo t = new Todo();
		t.setName("Fred");
		t.setTask("Snipe");
		t.setStatus(true);
		todoRepository.save(t);
	}
	
	@Test
	void deleteTodoRecord() {
		todoRepository.deleteById(2L);
	}
	
	@Test
	void getTodoRecord() {
		Optional<Todo> opTodo = todoRepository.findById(1L);
		if(opTodo.isPresent()) {
			Todo todo = opTodo.get();
			System.out.println(todo.getId());
			System.out.println(todo.getName());
			System.out.println(todo.getTask());
			System.out.println(todo.isStatus());
			
		}else {
			System.out.println("No Record found!");
		}
		
	}
	
	
	@Test
	void updateTodoRecord() {
		Optional<Todo> opTodo = todoRepository.findById(1L);
		if(opTodo.isPresent()) {
			Todo t = opTodo.get();
			t.setName("Abrar");
			t.setTask("Kill");
			t.setStatus(false);
			todoRepository.save(t);
		}else {
			System.out.println("No Record Found!");
		}
		
	}
	
	
	@Test
	void getAllTodoRecords() {
		Iterable<Todo> todos = todoRepository.findAll();
		for (Todo todo : todos) {
			System.out.println(todo.getId());
			System.out.println(todo.getName());
			System.out.println(todo.getTask());
			System.out.println(todo.isStatus());
		}
		
	}
		

}
