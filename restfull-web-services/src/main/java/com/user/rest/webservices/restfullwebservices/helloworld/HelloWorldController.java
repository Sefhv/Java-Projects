package com.user.rest.webservices.restfullwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {

	public static final String HELLO_WORLD = "Hello World";

	public HelloWorldController() {
		//
	}

	/**
	 * GET URI, with /hello-world Method, returns: "Hello Word"
	 * <p>
	 * When user request mapping with method get:
	 * </p>
	 * 
	 * @RequestMapping(method = RequestMethod.GET, path = "/hello-world") Convert to
	 *                        Get Mapping with path name
	 * 
	 * @GetMapping(path = "/hello-world")
	 */
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return HELLO_WORLD;
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		/*
		 * Using throw error 
		 * <p> 
		 * throw new RuntimeException("Some Error has Happened! Contact Support at *** - ***");
		 * </p>
		 */
		return new HelloWorldBean(HELLO_WORLD);
	}

	// hello-world/path-variable/sergio
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format(HELLO_WORLD + ", %s", name));
	}
}
