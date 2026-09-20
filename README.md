<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-1.9.0-7F52FF?logo=kotlin&logoColor=white" alt="Kotlin">
  <img src="https://img.shields.io/badge/Jetpack%20Compose-Material%203-4285F4?logo=jetpackcompose&logoColor=white" alt="Jetpack Compose">
  <img src="https://img.shields.io/badge/Firebase-Auth%20%2B%20Firestore-FFCA28?logo=firebase&logoColor=black" alt="Firebase">
  <img src="https://img.shields.io/badge/Android-8.0%2B-3DDC84?logo=android&logoColor=white" alt="Android">
</p>

<h1 align="center">GGAplication</h1>

<p align="center">Native Android app for UNAB students to browse events and manage their activities.</p>

<p align="center">🇪🇸 <a href="README.es.md">Leer en español</a></p>

## About

GGAplication is a native Android app built with Kotlin and Jetpack Compose. It was created so that students of Universidad Autónoma de Bucaramanga (UNAB) can manage the events that grant *horas libres* (free hours) and keep track of them.

Users sign up and log in with email and password, browse and search events, create events, and create or delete the activities linked to each event. Data is stored in Firebase (Authentication and Cloud Firestore).

Developed as a team project for the *Mobile Technologies* course (4th semester) at UNAB, Oct–Nov 2024.

## Features

- Email/password sign up and login (Firebase Authentication).
- User profile stored in Firestore.
- Event list on the home screen.
- Event search by name.
- Event creation form.
- Per-event activities: list in real time, create and delete.
- Account screen with user data.
- Sign out.

## Tech stack

| Technology | Version | Used for |
|---|---|---|
| Kotlin | 1.9.0 | Language |
| Android Gradle Plugin / Gradle | 8.6.0 / 8.7 | Build |
| Jetpack Compose (BoM) | 2024.04.01 | UI |
| Compose compiler extension | 1.5.1 | Compose compilation |
| Navigation Compose | 2.8.3 | Screen navigation |
| Firebase BoM | 33.5.1 | Firebase versions |
| Firebase Authentication | via BoM | Email/password auth |
| Cloud Firestore (KTX) | 24.0.0 | Database |
| Google Services plugin | 4.4.2 | Firebase configuration |

**SDK:** minSdk 26 · targetSdk 34 · compileSdk 34.

## Prerequisites

- Android Studio Koala Feature Drop (2024.1.2) or newer.
- JDK 17 (the JBR bundled with Android Studio works).
- An emulator or device with Android 8.0 (API 26) or higher.
- A Firebase project (the free Spark plan is enough).

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/DiegoACx/GGAplication.git
   ```
2. Open the folder in Android Studio and wait for the Gradle sync to finish.
3. Set up Firebase (next section) and place your `google-services.json` in `app/`.
4. Select an emulator or device and run the `app` configuration.

To build from the command line: `./gradlew assembleDebug` (requires JDK 17).

## Firebase setup

The app needs your own Firebase project. Credentials are **not** included in the repository.

1. Create a project in the [Firebase Console](https://console.firebase.google.com).
2. Add an Android app with the package name `com.edu.unab.diegocastro.ggaplication`.
3. Enable **Authentication → Sign-in method → Email/Password**.
4. Create a **Cloud Firestore** database.
5. Download `google-services.json` and place it at `app/google-services.json`. Use `app/google-services.json.example` as a structure reference.
6. Set Firestore security rules (see [Security](#security)).

### Firestore collections

| Collection | Document ID | Fields |
|---|---|---|
| `users` | Auth UID | `nombre`, `correo`, `telefono`, `userId` |
| `eventos` | auto | `nombre`, `hora_inicio`, `cupos`, `lider`, `descripcion` |
| `actividades` | auto | `nombre`, `evento` (title of the parent event) |

## Project structure

```
GGAplication/
├─ app/
│  ├─ src/main/java/com/edu/unab/diegocastro/ggaplication/   # one file per screen + navigation
│  │  └─ ui/theme/                                           # Color, Theme, Type
│  ├─ build.gradle.kts
│  └─ google-services.json.example
├─ gradle/libs.versions.toml
└─ build.gradle.kts · settings.gradle.kts
```

Navigation lives in a single `NavHost` inside `AuthActivity` (the launcher activity).

## Security

- `app/google-services.json` is in `.gitignore`. Never commit it.
- Restrict your Firebase API key in Google Cloud Console to your package name and SHA-1.
- Do not leave Firestore in test mode. Minimum recommended rules:
```
  rules_version = '2';
  service cloud.firestore {
    match /databases/{database}/documents {
      match /{document=**} {
        allow read, write: if request.auth != null;
      }
    }
  }
```

## Project status and known limitations

This is a learning project. Known limitations:

- Free-hours tracking is not implemented yet: "Hours" and "Enrolled activities" on the Account screen are hardcoded values.
- The activity detail screen is incomplete (it only shows the name).
- No ViewModel or repository layer: Firestore queries live inside the composables.
- Duplicated model classes (`Eventos`, `Evento`, `Eventoss`).
- Activities are linked to events by title, not by ID.
- `cupos` is stored as text and not validated.
- Basic error handling (generic toasts).
- No real tests (only the default templates).

## Authors

- Diego Castro — [@DiegoACx](https://github.com/DiegoACx)
- [@Guzman2304](https://github.com/Guzman2304)
