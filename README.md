# Simple Ktor API Call Application

A simple Kotlin application using Ktor client to make HTTP requests to a dummy API and print the results.

## Features

- Uses Ktor HTTP client for making API calls
- Calls JSONPlaceholder dummy API (https://jsonplaceholder.typicode.com)
- Parses and displays JSON responses
- Built with Kotlin and Gradle

## Project Structure

```
sampleKTORCall/
├── build.gradle.kts          # Gradle build configuration
├── settings.gradle.kts        # Gradle settings
├── gradle.properties          # Gradle properties
└── src/
    └── main/
        └── kotlin/
            └── com/
                └── example/
                    └── Main.kt  # Main application file
```

## Dependencies

- **Ktor Client Core** (3.0.2) - Core HTTP client functionality
- **Ktor Client CIO** (3.0.2) - Coroutine-based I/O engine
- **Ktor Content Negotiation** (3.0.2) - Automatic content type handling
- **Ktor Serialization** (3.0.2) - JSON serialization support
- **Kotlin Coroutines** (1.9.0) - Asynchronous programming
- **Logback** (1.5.12) - Logging framework

## How It Works

The application:
1. Creates an HTTP client with JSON content negotiation support
2. Makes a GET request to `https://jsonplaceholder.typicode.com/posts/1`
3. Receives a JSON response containing a post object
4. Prints the response to the console

## Running the Application

### Prerequisites
- JDK 21 or higher
- Gradle 8.x
- Internet connection (to download dependencies and access the API)

### Build and Run

```bash
# Using Gradle wrapper (if available)
./gradlew run

# Or using system Gradle
gradle run
```

### Expected Output

```
Making API call to JSONPlaceholder dummy API...
============================================================

API Response:
{
  "userId": 1,
  "id": 1,
  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
  "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita..."
}
============================================================
```

## Code Explanation

### Main.kt

The main application file contains:

- **Post data class**: A serializable data class representing the API response
- **HTTP Client setup**: Configured with CIO engine and JSON content negotiation
- **API call**: Async GET request using Kotlin coroutines
- **Error handling**: Try-catch block for network errors
- **Resource cleanup**: Client is properly closed in the finally block

## Notes

- This is a simple demonstration of Ktor client usage
- In production, you would want to add more robust error handling
- The JSONPlaceholder API is a free fake REST API for testing
- Network access is required to reach the external API

## Troubleshooting

If you encounter build issues:
1. Ensure you have a stable internet connection
2. Check that Maven Central is accessible
3. Verify your JDK version with `java -version`
4. Clear Gradle cache if needed: `gradle clean`
