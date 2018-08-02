package com.example.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.stereotype.Controller
import org.springframework.ui.Model

@SpringBootApplication
open class KotlinDemoApplication

@RestController
class HelloController {
	@GetMapping("/hello")
	fun helloKotlin(): String { 
		return "hello world kotlin spring web"
	}
}

@Controller
class MainController {
    @GetMapping("login")
    fun login(modle : Model): String {
        val a = 100;
        modle.addAttribute("a", a); 
        return "/login.html"
    }
}

fun main(args: Array<String>) {
	SpringApplication.run(KotlinDemoApplication::class.java, *args)
}
