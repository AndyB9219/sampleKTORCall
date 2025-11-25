package com.example

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

fun main() = runBlocking {
    // Create HTTP client with JSON support
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }
    }

    try {
        println("Making API call to JSONPlaceholder dummy API...")
        println("=" * 60)

        // Make GET request to dummy API
        val response: String = client.get("https://jsonplaceholder.typicode.com/posts/1").bodyAsText()

        println("\nAPI Response:")
        println(response)
        println("=" * 60)

    } catch (e: Exception) {
        println("Error making API call: ${e.message}")
        e.printStackTrace()
    } finally {
        client.close()
    }
}

operator fun String.times(n: Int): String = this.repeat(n)
