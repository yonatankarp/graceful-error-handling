package com.yonatankarp.gracefulerrorhandling.result

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ResultController(
    private val service: ResultService,
) {
    @GetMapping("/withResult")
    fun withResult(): ResponseEntity<out Any> =
        service.action().resultAsResponse()

    private fun <T> Result<T>.resultAsResponse() =
        onFailure { return ResponseEntity.badRequest().body(it.message) }
        .getOrNull()?.toResponse()
        ?: ResponseEntity.badRequest().body("Success")

    private fun <T> T.toResponse() = ResponseEntity.ok(this)
}
