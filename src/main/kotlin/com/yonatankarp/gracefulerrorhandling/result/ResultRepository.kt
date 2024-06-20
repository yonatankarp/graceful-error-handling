package com.yonatankarp.gracefulerrorhandling.result

import kotlin.random.Random
import org.springframework.stereotype.Repository

@Repository
class ResultRepository {
    fun save() =
        when(Random.nextBoolean()) {
            true -> Result.success("Saved successfully")
            false -> Result.failure(Exception("Failed to save"))
        }

    fun fallbackWithResult() = save()
}
