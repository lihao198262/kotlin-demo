package com.example.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.StringRedisTemplate
import javax.annotation.Resource
import org.springframework.data.redis.core.ValueOperations
import org.springframework.web.bind.annotation.PostMapping
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@SpringBootApplication
open class KotlinDemoApplication

val logger: Logger = LoggerFactory.getLogger("KotlinApplication.kt")

@Service
class RedisService {
	@Autowired
	private val template: StringRedisTemplate? = null

	@Resource(name = "stringRedisTemplate")
	var valOpsStr: ValueOperations<String, String>? = null

	fun test(username: String, password: String) {
		valOpsStr?.set(username, password)
	}
}

@RestController
class HelloController {
	@GetMapping("hello")
	fun helloKotlin(): String {
		return "hello world kotlin spring web"
	}
}

@Controller
class MainController {
	@Autowired
    private val a: RedisService? = null
	
	@GetMapping("login")
	fun login(modle: Model): String {
		val a = 100;
		modle.addAttribute("a", a);
		return "login.html"
	}

	@PostMapping("login-post")
	fun loginCheck(username: String, password: String): String {
		logger.info("aa $username-> $password")

		logger.info(a.toString())
		a?.test(username, password)
		return "index"
	}
}

fun main(args: Array<String>) {
	SpringApplication.run(KotlinDemoApplication::class.java, *args)
}
