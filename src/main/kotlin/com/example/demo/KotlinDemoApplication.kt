package com.example.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping

@SpringBootApplication
open class KotlinDemoApplication

@RestController
class HelloController {
	@GetMapping("/hello")
	fun helloKotlin(): String {
		return "hello world kotlin spring web"
	}
}

fun main(args: Array<String>) {
	SpringApplication.run(KotlinDemoApplication::class.java, *args)
}
