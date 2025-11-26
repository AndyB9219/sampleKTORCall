package com.example.samplektorcall

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView

    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

        // Show loading message
        resultTextView.text = "Loading...\nMaking API call to JSONPlaceholder dummy API..."

        // Make API call
        makeApiCall()
    }

    private fun makeApiCall() {
        lifecycleScope.launch {
            try {
                // Make GET request to dummy API
                val response: String = httpClient.get("https://jsonplaceholder.typicode.com/posts/1")
                    .bodyAsText()

                // Update UI with response
                resultTextView.text = buildString {
                    appendLine("✓ API Call Successful!")
                    appendLine("=" * 40)
                    appendLine()
                    appendLine("Response from JSONPlaceholder API:")
                    appendLine()
                    append(response)
                }

            } catch (e: Exception) {
                // Show error message
                resultTextView.text = buildString {
                    appendLine("✗ Error making API call")
                    appendLine("=" * 40)
                    appendLine()
                    appendLine("Error: ${e.message}")
                    appendLine()
                    appendLine("Stack trace:")
                    append(e.stackTraceToString())
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        httpClient.close()
    }
}

private operator fun String.times(n: Int): String = repeat(n)
