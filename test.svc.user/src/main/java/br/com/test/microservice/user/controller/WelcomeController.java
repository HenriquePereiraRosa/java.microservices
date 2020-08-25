package br.com.test.microservice.user.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

	@Autowired
	private Environment environment;
	
	@GetMapping
	public List<String> welcome(HttpServletRequest request) {
		List<String> list = new ArrayList<>();
		list.add("Welcome from USER Service");
		list.add("Today is: " + LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
		list.add("Server is running on PORT: " +
				environment.getProperty("local.server.port") + "...");
		list.add("Requested from IP: " + request.getRemoteAddr());
		return list;
	}
}
