package com.todo.repository;

import org.springframework.data.repository.CrudRepository;

import com.todo.entity.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long>{

}
