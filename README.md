# 🎬 Fauzi Movie App

[![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=flat&logo=android&logoColor=white)](https://www.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.4.10-7F52FF?style=flat&logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/UI-Jetpack%25 Compose-4285F4?style=flat&logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![Hilt](https://img.shields.io/badge/DI-Hilt-2875C7?style=flat&logo=dagger&logoColor=white)](https://dagger.dev/hilt/)

A production-grade, modern Android application showcasing **Modern Android Development (MAD)** standards, **Multi-Module Clean Architecture**, and robust offline-first patterns. This project integrates with The Movie Database (TMDB) API to deliver a seamless browsing, reviewing, and favoriting experience.

---

## 🏛️ Architecture & Design Patterns

This project strictly adheres to **Clean Architecture** combined with **Layered and Feature-Based Modularization**, drawing inspiration from Google's *"Now in Android"* reference architecture.

### 1. Multi-Module Separation of Concerns
The project is decoupled into independent Gradle modules to enforce strict architectural boundaries, optimize Gradle build parallelization, and prevent code leakage:
*   **Feature Modules (`:feature:movie`)**: Encapsulates the complete user flow (Home, Detail, Favorite screens, and ViewModels).
*   **Core Infrastructure (`:core:network`, `:core:database`)**: Isolated leaf modules handling raw API communication (Retrofit/OkHttp) and local data persistence (Room).
*   **Core Business Logic (`:core:domain`)**: Pure Kotlin module containing business rules, **UseCases**, and **Repository Interfaces**.
*   **Core Data (`:core:data`)**: Acts as the *Data Orchestrator*, implementing repositories and bridging local/remote data sources.
*   **Core UI (`:core:ui`)**: Acts as an internal Design System containing reusable Compose components, custom toolbars, image loaders, and shimmer animations.
*   **Core Model (`:core:model`)**: Houses pure Kotlin data classes acting as the *Universal Language* across the entire application, eliminating circular dependencies.

### 2. Unidirectional Data Flow (UDF)
State flows strictly **down** from the ViewModel to the UI via `StateFlow` and `Flow`, while user actions and events flow **up** to the ViewModel. This ensures a predictable single source of truth and simplifies state debugging.

---

## 🚀 Tech Stack & Libraries

*   **UI Toolkit**: [Jetpack Compose](https://developer.android.com/jetpack/compose) & [Material 3](https://m3.material.io)
*   **Dependency Injection**: [Dagger Hilt](https://dagger.dev/hilt/) with [KSP](https://kotlinlang.org/docs/ksp.html)
*   **Async & Reactive Streams**: [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) & [Flow](https://kotlinlang.org/kotlin.html)
*   **Network**: [Retrofit 2](https://square.github.io/retrofit/) & [OkHttp 5](https://square.github.io/okhttp/)
*   **Serialization**: [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization) (Compile-time, reflection-free parsing)
*   **Local Database**: [Room Database](https://developer.android.com/training/data-storage/room) (Offline-first data persistence)
*   **Pagination**: [Paging 3](https://developer.android.com/topic/paging/v3-overview) with custom `BasePagingSource`
*   **Image Loading**: [Coil 3](https://coil-kt.github.io/coil/) (Kotlin-first image loading with memory/disk caching)
*   **Navigation**: Jetpack Compose Navigation with type-safe argument handling

---

## 💎 Engineering Best Practices Implemented

*   **Strict Encapsulation (`internal` visibility)**: Room DAOs, Entities, and database builders are strictly hidden inside `:core:database`, preventing feature modules from bypassing the repository layer.
*   **Process Death Resilience**: Uses `SavedStateHandle` in ViewModels to securely preserve navigation arguments and state across system-initiated process terminations.
*   **Resource Optimization**: Implements `SharingStarted.WhileSubscribed(5000)` to keep StateFlows alive during configuration changes (like screen rotation) while automatically pausing background streams to conserve battery and CPU resources.
*   **Declarative Performance**: Features custom skeleton shimmer loaders and optimized lazy lists to eliminate UI jank during network requests.
*   **Modern Build Optimization**: Fully migrated to Kotlin DSL (`build.gradle.kts`), Version Catalogs (`libs.versions.toml`), and KSP for high-performance code generation.

---

## 📁 Project Structure

```text
FauziMovieApp/
│
├── app/                  # Main entry point, Hilt Application, NavHost
├── core/
│   ├── data/             # Repository implementations & Mappers
│   ├── database/         # Room Database, DAOs, Entities, LocalDataSource
│   ├── domain/           # UseCases & Repository Interfaces
│   ├── model/            # Pure Kotlin Data Models (Universal Language)
│   ├── network/          # Retrofit Services, DTOs, Interceptors, RemoteDataSource
│   └── ui/               # Design system, Theme, Shimmers, Reusable Components
└── feature/
    └── movie/            # Home, Detail, Favorite Screens & ViewModels
```

---

## 📱 Features

1.  **Home Screen**: 
    *   Browse Popular, Top Rated, and Now Playing movies with horizontal paginated carousels.
    *   Smooth snap-scrolling behavior and custom shimmer loading states.
2.  **Detail Screen**: 
    *   Immersive header with a hero backdrop overlapping a transparent toolbar.
    *   View movie details, release date formatting, synopsis, and paginated user reviews (with empty-state handling).
    *   Native **Share Intent** integration to share movie summaries.
    *   Real-time **Favorite Toggling** synced directly with the local Room database.
3.  **Favorite Screen**: 
    *   Offline-first list of user-favorited movies persisted locally, backed by reactive `StateFlow`.

---

## 🧑‍💻 Author
**Muhammad Fauzi Maulana**  
*Android Engineer with 4+ YoE*
