# Ktor Android API Call Sample

A simple Android application using Ktor HTTP client to make API calls to a dummy REST API and display the results on screen.

## Features

- Native Android app built with Kotlin
- Uses Ktor HTTP client for making API calls
- Calls JSONPlaceholder dummy API (https://jsonplaceholder.typicode.com)
- Displays JSON responses in a scrollable TextView
- Implements coroutines for asynchronous networking
- Material Design 3 theme

## Project Structure

```
sampleKTORCall/
├── build.gradle.kts                    # Root build configuration
├── settings.gradle.kts                 # Gradle settings
├── gradle.properties                   # Gradle properties
└── app/
    ├── build.gradle.kts               # App module build configuration
    ├── proguard-rules.pro             # ProGuard rules
    └── src/main/
        ├── AndroidManifest.xml        # Android manifest
        ├── kotlin/com/example/samplektorcall/
        │   └── MainActivity.kt        # Main activity with API call
        └── res/
            ├── layout/
            │   └── activity_main.xml  # Main layout
            ├── values/
            │   ├── strings.xml        # String resources
            │   ├── colors.xml         # Color resources
            │   └── themes.xml         # Theme definitions
            └── mipmap-*/              # App icons
```

## Dependencies

### Android Core
- AndroidX Core KTX (1.12.0)
- AppCompat (1.6.1)
- Material Components (1.11.0)
- ConstraintLayout (2.1.4)

### Networking
- **Ktor Client Android** (2.3.7) - Android-optimized HTTP client
- **Ktor Content Negotiation** (2.3.7) - Automatic JSON handling
- **Ktor Serialization** (2.3.7) - JSON serialization support

### Coroutines
- Kotlinx Coroutines Android (1.7.3) - Async operations
- Lifecycle Runtime KTX (2.7.0) - Lifecycle-aware coroutines

## How It Works

The Android app:

1. **MainActivity** launches and displays a loading message
2. Creates a Ktor HTTP client with Android engine and JSON content negotiation
3. Makes an asynchronous GET request to `https://jsonplaceholder.typicode.com/posts/1`
4. Receives a JSON response containing a post object
5. Displays the formatted response in a scrollable TextView
6. Handles errors gracefully with user-friendly error messages

## Building and Running

### Prerequisites
- Android Studio (Arctic Fox or newer)
- Android SDK with API level 34
- JDK 17 or higher
- Internet connection (to download dependencies and access the API)

### Build and Run in Android Studio

1. Open the project in Android Studio
2. Sync Gradle files
3. Connect an Android device or start an emulator (API 24+)
4. Click Run (▶️) or press Shift+F10

### Build from Command Line

```bash
# Build debug APK
./gradlew assembleDebug

# Install on connected device
./gradlew installDebug

# Build and install
./gradlew installDebug
```

### Expected Output

When the app launches, you'll see:

```
✓ API Call Successful!
========================================

Response from JSONPlaceholder API:

{
  "userId": 1,
  "id": 1,
  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
  "body": "quia et suscipit\nsuscipit recusandae..."
}
```

## Code Explanation

### MainActivity.kt

The main activity contains:

- **Post data class**: A `@Serializable` data class representing the API response
- **HTTP Client**: Configured with Android engine for optimal performance
- **onCreate()**: Sets up the UI and initiates the API call
- **makeApiCall()**: Launches a coroutine using `lifecycleScope` to make the async network request
- **Error handling**: Try-catch block displays errors to the user
- **Resource cleanup**: Client is properly closed in `onDestroy()`

### Key Features

- **Lifecycle-aware**: Uses `lifecycleScope` to automatically cancel requests when activity is destroyed
- **Thread-safe UI updates**: Coroutines ensure UI updates happen on the main thread
- **Material Design**: Follows Android design guidelines with Material 3 theme
- **Internet permission**: AndroidManifest includes required `INTERNET` permission

## Permissions

The app requires:
- `android.permission.INTERNET` - To make network requests
- `android.permission.ACCESS_NETWORK_STATE` - To check network connectivity

## Configuration

### Minimum SDK Requirements
- **minSdk**: 24 (Android 7.0)
- **targetSdk**: 34 (Android 14)
- **compileSdk**: 34

### Supported Architectures
- ARM64-v8a
- ARMv7
- x86
- x86_64

## Notes

- This is a simple demonstration of Ktor client usage in Android
- In production, you should add:
  - Network connectivity checks
  - Loading indicators (ProgressBar)
  - Retry mechanisms
  - Better error handling with user actions
  - Repository pattern for data layer
  - ViewModel for UI state management
- The JSONPlaceholder API is a free fake REST API for testing
- Network access is required to reach the external API

## Troubleshooting

### Build Issues
1. Sync Gradle files: File → Sync Project with Gradle Files
2. Clean and rebuild: Build → Clean Project, then Build → Rebuild Project
3. Invalidate caches: File → Invalidate Caches / Restart
4. Check internet connection for dependency downloads

### Runtime Issues
1. Ensure device/emulator has internet connectivity
2. Check that the app has internet permission
3. Verify API endpoint is accessible: https://jsonplaceholder.typicode.com/posts/1
4. Check Logcat for detailed error messages

## Testing

To test without internet access, you can modify the code to use a local mock server or add mock responses for offline testing.

## License

This is a sample project for educational purposes.
