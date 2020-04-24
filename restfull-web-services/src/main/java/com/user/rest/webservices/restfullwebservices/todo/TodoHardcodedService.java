package com.user.rest.webservices.restfullwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {

	private static List<Todo> todos = new ArrayList<>(1);
	private static Long idCounter = 0L;

	static {
		todos.add(new Todo(++idCounter, "sergio", "Learn to Dance", new Date(), false));
		todos.add(new Todo(++idCounter, "sergio", "Learn about Microservices", new Date(), false));
		todos.add(new Todo(++idCounter, "sergio", "Learn about Angular", new Date(), false));
	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo saveTodo(Todo todo) {
		if (todo.getId() == null) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

	public Todo deleteById(Long id) {
		Todo todo = findById(id);

		if (todo.getId() == null)
			return new Todo();

		if (todos.remove(todo))
			return todo;

		return new Todo();
	}

	public Todo findById(Long id) {
		for (Todo todo : todos)
			if (todo.getId().equals(id))
				return todo;
		return new Todo();
	}

}
