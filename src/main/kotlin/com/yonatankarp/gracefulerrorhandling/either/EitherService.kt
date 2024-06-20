package com.yonatankarp.gracefulerrorhandling.either

import arrow.core.Either
import org.springframework.stereotype.Service

@Service
class EitherService(
    private val repository: EitherRepository,
) {
    fun action(): Either<Exception, String> =
        repository.save()
            .mapLeft { return repository.fallbackWithResult() }
}
