package com.oracle.coherence.spring.demo.controller;

import com.oracle.coherence.spring.configuration.annotation.CoherenceCache;
import com.tangosol.net.NamedCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	private final NamedCache<String, String> foobarCache;

	public HelloWorldController(@CoherenceCache NamedCache<String, String> foobarCache) {
		this.foobarCache = foobarCache;
	}

	@PostMapping("/")
	public String addToCache() {
		this.foobarCache.put("hello", "world - " + Math.random());
		return "Done.";
	}

	@GetMapping("/")
	public String hello() {
		return "Hello " + this.foobarCache.get("hello") + "!";
	}

}
