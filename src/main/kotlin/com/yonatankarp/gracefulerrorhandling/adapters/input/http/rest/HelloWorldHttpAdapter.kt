package com.yonatankarp.gracefulerrorhandling.adapters.input.http.rest

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldHttpAdapter {
    suspend fun helloWorld(): ResponseEntity<Any> = ResponseEntity.ok("Hello World")
}
