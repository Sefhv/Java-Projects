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
		todos.add(new Todo(++idCounter, "sergio", "Learn about Angualar", new Date(), false));
	}

	public List<Todo> findAll() {
		return todos;
	}

}
