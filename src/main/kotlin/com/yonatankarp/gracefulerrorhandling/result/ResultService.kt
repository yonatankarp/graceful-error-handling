package com.yonatankarp.gracefulerrorhandling.result

import org.springframework.stereotype.Service

@Service
class ResultService(
    private val repository: ResultRepository,
) {
    fun action(): Result<String> =
        repository.save()
            .onFailure { return repository.fallbackWithResult() }
}
