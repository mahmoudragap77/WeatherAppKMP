# 🌤️ WeatherAppKMP

A cross-platform weather app built with **Kotlin Multiplatform** and **Compose Multiplatform**.
One shared codebase for UI and business logic, running natively on **Android**, **iOS**, and **Desktop (JVM)**.

---

## ✨ Features

- 📍 Weather updates based on your **current location**
- 🎨 Modern UI built 100% with **Compose Multiplatform** (Material 3), shared across all platforms
- 🌐 Networking with **Ktor** and JSON parsing with **kotlinx.serialization**
- ⚡ **Hot Reload** on Desktop for fast UI iteration
- 🤖 CI workflow that builds the iOS simulator app and uploads it to **Appetize** (no Mac required)

---

## 🧱 Tech Stack

| Area | Technology |
|---|---|
| Language | Kotlin |
| UI | Compose Multiplatform + Material 3 |
| Networking | Ktor Client (CIO engine, Content Negotiation) |
| Serialization | kotlinx.serialization (JSON) |
| Async | Kotlin Coroutines |
| Location | [Compass](https://github.com/jordond/compass) Geolocation |
| Build | Gradle (Kotlin DSL) + Version Catalog |
| CI/CD | GitHub Actions + Appetize |

---

## 📁 Project Structure

```
WeatherAppKMP/
├── shared/        # Shared Kotlin code (UI, networking, logic)
│   └── src/
│       ├── commonMain/   # Code for all platforms
│       ├── androidMain/  # Android-specific code
│       ├── iosMain/      # iOS-specific code
│       └── jvmMain/      # Desktop-specific code
├── androidApp/    # Android application entry point
├── iosApp/        # iOS application entry point (Xcode project)
├── desktopApp/    # Desktop (JVM) application entry point
├── gradle/        # Version catalog (libs.versions.toml)
└── .github/workflows/   # CI: iOS build + Appetize upload
```


### Run the apps

| Platform | Command |
|---|---|
| 🤖 Android | `./gradlew :androidApp:assembleDebug` (or use the run configuration in Android Studio) |
| 🖥️ Desktop | `./gradlew :desktopApp:run` |
| 🖥️ Desktop (Hot Reload) | `./gradlew :desktopApp:hotRun --auto` |
| 🍎 iOS | Open `iosApp/` with Appetize  |

> On Windows/Linux you can still test iOS without a Mac. See [iOS without a Mac](#-ios-without-a-mac-appetize).

### Location permission

The app asks for location access to show local weather:

- **Android**: location permission is requested at runtime.
- **iOS**: `NSLocationWhenInUseUsageDescription` is declared in `Info.plist`.

---

## 🍎 iOS without a Mac (Appetize)

The repository includes a GitHub Actions workflow (`.github/workflows/`) that:

1. Builds the iOS **simulator** app on a macOS runner
2. Zips the `.app` bundle
3. Uploads it to [Appetize](https://appetize.io) so you can run it in the browser
4. Keeps a copy as a downloadable workflow artifact

**Setup**

1. Add these secrets in **Settings → Secrets and variables → Actions**:
   - `APPETIZE_API_TOKEN`
   - `APPETIZE_PUBLIC_KEY`
2. Go to **Actions → Build iOS for Appetize → Run workflow**.

<img width="720" height="1600" alt="6eb7cb51-d5e7-41c9-9521-0a02b31f448e" src="https://github.com/user-attachments/assets/ee156b08-ee76-44a4-85ed-d672881036f7" />
<img width="422" height="683" alt="Screenshot 2026-11-09 085103" src="https://github.com/user-attachments/assets/fa304ec6-54fe-4c65-bfad-80986bffceed" />
<img width="982" height="732" alt="Screenshot 2026-11-09 084914" src="https://github.com/user-attachments/assets/03da2412-d991-4a21-9df4-2fd503b43973" />
