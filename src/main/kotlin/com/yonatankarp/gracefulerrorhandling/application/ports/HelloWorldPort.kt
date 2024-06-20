package com.yonatankarp.gracefulerrorhandling.application.ports

fun interface HelloWorldPort {
    suspend fun greet(): String
}
