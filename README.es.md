<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-1.9.0-7F52FF?logo=kotlin&logoColor=white" alt="Kotlin">
  <img src="https://img.shields.io/badge/Jetpack%20Compose-Material%203-4285F4?logo=jetpackcompose&logoColor=white" alt="Jetpack Compose">
  <img src="https://img.shields.io/badge/Firebase-Auth%20%2B%20Firestore-FFCA28?logo=firebase&logoColor=black" alt="Firebase">
  <img src="https://img.shields.io/badge/Android-8.0%2B-3DDC84?logo=android&logoColor=white" alt="Android">
</p>

<h1 align="center">GGAplication</h1>

<p align="center">App Android nativa para que estudiantes de la UNAB consulten eventos y gestionen sus actividades.</p>

<p align="center">🇬🇧 <a href="README.md">Read in English</a></p>

## Acerca del proyecto

GGAplication es una app Android nativa hecha con Kotlin y Jetpack Compose. Se creó para que los estudiantes de la Universidad Autónoma de Bucaramanga (UNAB) puedan gestionar los eventos que otorgan horas libres y llevar un control de ellas.

Los usuarios se registran e inician sesión con correo y contraseña, consultan y buscan eventos, crean eventos, y crean o eliminan las actividades asociadas a cada evento. Los datos se guardan en Firebase (Authentication y Cloud Firestore).

Desarrollado como proyecto en equipo para el curso de *Tecnologías Móviles* (4.º semestre) de la UNAB, oct–nov 2024.

## Funcionalidades

- Registro e inicio de sesión con correo y contraseña (Firebase Authentication).
- Perfil de usuario guardado en Firestore.
- Lista de eventos en la pantalla principal.
- Búsqueda de eventos por nombre.
- Formulario de creación de eventos.
- Actividades por evento: lista en tiempo real, creación y eliminación.
- Pantalla de cuenta con los datos del usuario.
- Cierre de sesión.

## Stack tecnológico

| Tecnología | Versión | Para qué se usa |
|---|---|---|
| Kotlin | 1.9.0 | Lenguaje |
| Android Gradle Plugin / Gradle | 8.6.0 / 8.7 | Compilación |
| Jetpack Compose (BoM) | 2024.04.01 | Interfaz |
| Compose compiler extension | 1.5.1 | Compilación de Compose |
| Navigation Compose | 2.8.3 | Navegación entre pantallas |
| Firebase BoM | 33.5.1 | Versiones de Firebase |
| Firebase Authentication | vía BoM | Autenticación por correo |
| Cloud Firestore (KTX) | 24.0.0 | Base de datos |
| Plugin Google Services | 4.4.2 | Configuración de Firebase |

**SDK:** minSdk 26 · targetSdk 34 · compileSdk 34.

## Requisitos previos

- Android Studio Koala Feature Drop (2024.1.2) o superior.
- JDK 17 (sirve el JBR que trae Android Studio).
- Un emulador o dispositivo con Android 8.0 (API 26) o superior.
- Un proyecto de Firebase (el plan gratuito Spark alcanza).

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/DiegoACx/GGAplication.git
   ```
2. Abre la carpeta en Android Studio y espera a que termine la sincronización de Gradle.
3. Configura Firebase (siguiente sección) y coloca tu `google-services.json` en `app/`.
4. Elige un emulador o dispositivo y ejecuta la configuración `app`.

Para compilar desde la línea de comandos: `./gradlew assembleDebug` (requiere JDK 17).

## Configuración de Firebase

La app necesita tu propio proyecto de Firebase. Las credenciales **no** están en el repositorio.

1. Crea un proyecto en la [Consola de Firebase](https://console.firebase.google.com).
2. Agrega una app Android con el paquete `com.edu.unab.diegocastro.ggaplication`.
3. Habilita **Authentication → Método de acceso → Correo electrónico/contraseña**.
4. Crea una base de datos **Cloud Firestore**.
5. Descarga `google-services.json` y colócalo en `app/google-services.json`. Usa `app/google-services.json.example` como referencia de estructura.
6. Configura las reglas de seguridad de Firestore (ver [Seguridad](#seguridad)).

### Colecciones de Firestore

| Colección | ID del documento | Campos |
|---|---|---|
| `users` | UID de Auth | `nombre`, `correo`, `telefono`, `userId` |
| `eventos` | automático | `nombre`, `hora_inicio`, `cupos`, `lider`, `descripcion` |
| `actividades` | automático | `nombre`, `evento` (título del evento padre) |

## Estructura del proyecto

```
GGAplication/
├─ app/
│  ├─ src/main/java/com/edu/unab/diegocastro/ggaplication/   # un archivo por pantalla + navegación
│  │  └─ ui/theme/                                           # Color, Theme, Type
│  ├─ build.gradle.kts
│  └─ google-services.json.example
├─ gradle/libs.versions.toml
└─ build.gradle.kts · settings.gradle.kts
```

La navegación vive en un único `NavHost` dentro de `AuthActivity` (la actividad de inicio).

## Seguridad

- `app/google-services.json` está en el `.gitignore`. No lo subas nunca.
- Restringe tu API key de Firebase en Google Cloud Console a tu paquete y SHA-1.
- No dejes Firestore en modo de prueba. Reglas mínimas recomendadas:
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

## Estado del proyecto y limitaciones conocidas

Es un proyecto de aprendizaje. Limitaciones conocidas:

- El control de horas libres aún no está implementado: "Horas" y "Actividades inscritas" en la pantalla de cuenta son valores fijos.
- La pantalla de detalle de actividad está incompleta (solo muestra el nombre).
- Sin capa de ViewModel ni repositorio: las consultas a Firestore están dentro de los composables.
- Modelos duplicados (`Eventos`, `Evento`, `Eventoss`).
- Las actividades se enlazan a los eventos por título, no por ID.
- `cupos` se guarda como texto y no se valida.
- Manejo de errores básico (toasts genéricos).
- Sin tests reales (solo las plantillas por defecto).

## Autores

- Diego Castro — [@DiegoACx](https://github.com/DiegoACx)
- [@Guzman2304](https://github.com/Guzman2304)
