package com.yonatankarp.gracefulerrorhandling.either

import arrow.core.Either
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EitherController(
    private val service: EitherService,
) {
    @GetMapping("/withEither")
    fun withEither(): ResponseEntity<out Any> =
        service.action().eitherAsResponse()

    private fun <L, R> Either<L, R>.eitherAsResponse(): ResponseEntity<Any> =
        when (this) {
            is Either.Right -> ResponseEntity.ok(this.value)
            is Either.Left -> ResponseEntity.badRequest().body((this.value as Exception).message)
        }
}
