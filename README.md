# Göteborgaren 🏙️

En modern Android-app för Göteborg — kollektivtrafik, väder, sevärdheter och mer.

## Tech Stack

| | |
|---|---|
| **Språk** | Kotlin 100% |
| **UI** | Jetpack Compose + Material 3 |
| **Arkitektur** | Clean Architecture (data/presentation/di) |
| **DI** | Hilt (Dagger) |
| **Navigation** | Navigation Compose (Single Activity) |
| **State** | Coroutines + StateFlow |
| **Nätverk** | Retrofit + OkHttp (redo för API:er) |

## Skärmar

- **🏠 Hem** — Snabbvy över Göteborg
- **🚋 Avgångar** — Kollektivtrafik i realtid
- **🌤️ Väder** — 7-dagarsprognos
- **📍 Upptäck** — Sevärdheter, parker, museer
- **👨‍💻 Om mig** — CV för jobbansökningar

## Bygg & kör

```bash
./gradlew assembleDebug
```

APK finns i `app/build/outputs/apk/debug/app-debug.apk`
