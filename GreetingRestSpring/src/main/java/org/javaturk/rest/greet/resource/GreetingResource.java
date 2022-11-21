package org.javaturk.rest.greet.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.javaturk.rest.greet.domain.Greeting;
import org.javaturk.rest.greet.repo.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value="/greetings", produces="application/json")
public class GreetingResource {

	@Autowired
	private GreetingRepository repo;

	
	@GetMapping
	public Map<String, String> getAllGreetings() {
		return repo.getGreetingMap();
	}

	
	@GetMapping(value = "objects/1", produces="application/json")
	public List<Greeting> getAllGreetingObjectsAsJSON1() {
		System.out.println("in getAllGreetingObjectsAsJSON1()");
		return repo.getGreetingList();
	}
	
	@GetMapping(value = "objects/2", produces="application/json")
	public ResponseEntity<List<Greeting>> getAllGreetingObjectsAsJSON2() {
		System.out.println("in getAllGreetingObjectsAsJSON2()");
		return ResponseEntity.ok(repo.getGreetingList());
	}
	
	@GetMapping(value = "objects/3", produces="application/json")
	public ResponseEntity<List<Greeting>> getAllGreetingObjectsAsJSON3() {
		System.out.println("in getAllGreetingObjectsAsJSON3()");
		List<Greeting> list = repo.getGreetingList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	
	@GetMapping(value = "objects", produces="application/xml")
	public List<Greeting> getAllGreetingObjectsAsXML() {
		System.out.println("in getAllGreetingObjectsAsXML()");
		return repo.getGreetingList();
	}

	@GetMapping("languages")
	public ResponseEntity<Set<String>> getAllLanguages() {
		return ResponseEntity.ok(repo.getAllLanguages());
	}

	@GetMapping(value = "count/1")
	public ResponseEntity<String> getGreetingCount1() {
		Integer size = repo.getSize();
		return ResponseEntity.ok().body(size.toString());
	}
	
	@GetMapping(value = "count/2")
	public String getGreetingCount2() {
		Integer size = repo.getSize();
		return size.toString();
	}

	@GetMapping(value = "{language}/1")
	public ResponseEntity<String> getGreeting1(@PathVariable("language") String language) {
		String greeting = repo.getGreeting(language);
		if (greeting != null)
			return ResponseEntity.ok(greeting );
		else
			//return ResponseEntity.ok("No such language found: " + language);
			//return new ResponseEntity(HttpStatus.NOT_FOUND);
			return ResponseEntity.status(404).build();
	}
	
	@GetMapping(value = "{language}/2")
	public String getGreeting2(@PathVariable("language") String language) {
		String greeting = repo.getGreeting(language);
		if (greeting != null)
			return greeting;
		else
			return "No such language found: " + language;
	}
	
	@PostMapping("{language}/{greeting}")
	public ResponseEntity<Object> createGreetingByParameter(@PathVariable("language") String language, @PathVariable("greeting") String greeting) {
		Greeting greetingObject = new Greeting(language, greeting);
		if (repo.addGreeting(greetingObject)) {
//			String requestUriString = ServletUriComponentsBuilder.fromCurrentRequest().path("").toString();
//			int index = requestUriString.lastIndexOf('/');
//			String newUriString = requestUriString.substring(0, index) + "/1";
//			URI uri = null;
//			try {
//				uri = new URI(newUriString);
////				System.out.println(uri.getPath());
////				System.out.println(uri);
//			} catch (URISyntaxException e) {
//				e.printStackTrace();
//			}
			
			URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand().toUri(); 
//			System.out.println(ServletUriComponentsBuilder.fromCurrentRequest().path("").toUriString());
//			System.out.println(location);
			return ResponseEntity.created(location).build();
		} else
			return ResponseEntity.status(409).build();
	}
}
