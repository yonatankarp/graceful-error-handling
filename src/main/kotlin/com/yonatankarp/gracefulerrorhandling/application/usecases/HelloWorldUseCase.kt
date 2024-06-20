package com.yonatankarp.gracefulerrorhandling.application.usecases

import com.yonatankarp.gracefulerrorhandling.application.ports.HelloWorldPort
import com.yonatankarp.gracefulerrorhandling.domain.valueobject.HelloWorld
import org.springframework.stereotype.Service

@Service
class HelloWorldUseCase : HelloWorldPort {
    override suspend fun greet() = HelloWorld().sayHello()
}
