package yike.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@RequestMapping("/helloworld")
	String home() {
		return "Hello World!";
	}
	
	@RequestMapping("/exception")
	String exception() {
		int x= 1/0;
		return "Hello World!";
	}

}
