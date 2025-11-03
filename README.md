![icons](images/icons.png)

---

🩺 Salud Inteligente - Fase 2 (con Firebase, Cámara y Maps)

Aplicación Android con flujo de Login/Registro (SQLite), Dashboard, Notificaciones Push (FCM), Cámara (CameraX) y Geolocalización (Google Maps).

Esta es la Fase 2 del proyecto, que expande la base de la Fase 1 (Login/Registro/Dashboard) para incluir funcionalidades avanzadas de hardware y servicios en la nube.

---

🚨 REQUISITOS DE CONFIGURACIÓN (¡MUY IMPORTANTE!)

La Fase 2 de esta app DEPENDE de servicios de Google y Firebase. La app NO COMPILARÁ O CRASHEARÁ si no se configuran las siguientes 3 claves:

---

1. Archivo de Configuración de Firebase

Ve a Firebase Console y crea un nuevo proyecto.

Añade una aplicación Android a tu proyecto con el nombre de paquete: com.riaytech.saludinteligente.

Descarga el archivo google-services.json.

Coloca este archivo en la carpeta app/ del proyecto (reemplazando al que está en el repositorio si es necesario).

---

2. Autenticación de Firebase (Huella SHA-1)

Para que las Notificaciones Push (FCM) funcionen, Firebase debe autenticar tu app.

Abre la pestaña Terminal en Android Studio.

Ejecuta el comando para obtener tu huella digital de depuración (debug):

.\gradlew signingReport

Copia la huella SHA-1 que aparece para la variante debug.
(Ej: CE:0C:AA:FB:CD:66:07:86:08:F8:D0:35:33:94:3C:83:CA:3E:34:E4)

Ve a la Consola de Firebase -> Configuración del proyecto -> Tus apps.

Selecciona tu app de Android y añade esta SHA-1 en la sección "Huellas digitales de certificado SHA".

Vuelve a descargar el archivo google-services.json y reemplázalo en tu carpeta app/.

---

3. API Key de Google Maps

Para que el mapa de geolocalización funcione, necesitas una API Key de Google Maps.

Ve a Google Cloud Console (asegúrate de seleccionar tu proyecto de Firebase).

Habilita la API "Maps SDK for Android".

Crea una clave de API (API Key) y restríngela a tu app de Android (usando el package_name y tu SHA-1).

Copia la clave de API.

Abre el archivo app/src/main/res/values/strings.xml y reemplaza el valor de Maps_key:

<!-- Reemplaza "TU_API_KEY_DE_GOOGLE_MAPS_AQUÍ" con tu clave real -->
<string name="google_maps_key">TU_API_KEY_DE_GOOGLE_MAPS_AQUÍ</string>

---

🚀 Cómo Abrir en Android Studio

(Se recomienda usar Android Studio Narwhal [4 - 2025.1.4] o una versión superior).

Descarga y extrae el archivo .zip en tu equipo.

Abre Android Studio y selecciona File -> Open...

Navega y selecciona la carpeta raíz del proyecto (SaludInteligente_RIAYTECH).

Espera a que Gradle sincronice todas las dependencias.

Ejecuta la aplicación en un emulador o en un dispositivo físico.

---

📦 Generar un APK (desde Android Studio)

En el menú superior, ve a Build -> Build Bundle(s) / APK(s).

Selecciona Build APK(s).

Una vez que la compilación termine, aparecerá una notificación. Haz clic en Locate para encontrar el archivo app-debug.apk.

---

💻 Compilar desde Terminal

Abre tu terminal (o CMD/PowerShell en Windows).

Navega hasta la carpeta raíz del proyecto (SaludInteligente_RIAYTECH).

Ejecuta el wrapper de Gradle:

En Windows:

.\gradlew assembleDebug


En Linux / Mac:

./gradlew assembleDebug


El APK compilado se encontrará en la siguiente ruta:
app/build/outputs/apk/debug/app-debug.apk

---

📋 Requisitos Previos

Asegúrate de tener el siguiente entorno configurado:

☕ JDK 11 o superior.

🤖 Android SDK (API 33+ recomendado).

🌎 La variable de entorno ANDROID_HOME debe estar configurada.

📡 Conexión a Internet (para descargar dependencias de Google y Firebase).
