package com.yonatankarp.gracefulerrorhandling.either

import arrow.core.left
import arrow.core.right
import kotlin.random.Random
import org.springframework.stereotype.Repository

@Repository
class EitherRepository {
    fun save() =
        when (Random.nextBoolean()) {
            true -> "Saved successfully".right()
            false -> Exception("Failed to save").left()
        }

    fun fallbackWithResult() = save()
}
