Proyecto: Salud Inteligente - RIAYTECH Solutions
--------------------------------------------------
Descripción: Aplicación Android mínima con Login, SQLite y Dashboard de bienvenida.
Credenciales demo: usuario 'admin' / contraseña 'admin123'

Cómo abrir en Android Studio (Narwhal 4 - 2025.1.4 recomendado):
1. Descargar y extraer el ZIP en tu equipo.
2. Abrir Android Studio -> File -> Open... -> seleccionar la carpeta 'SaludInteligente_RIAYTECH'.
3. Esperar a que Gradle sincronice. Si te pide actualizar el plugin o SDK sigue las indicaciones.
4. Ejecutar en un emulador o dispositivo físico.
5. Para generar APK: Build -> Build Bundle(s) / APK(s) -> Build APK(s) -> Locate.

Cómo compilar desde terminal (Linux/Mac/Windows with Gradle wrapper):
1. Abrir terminal en la carpeta 'SaludInteligente_RIAYTECH'.
2. Ejecutar: ./gradlew assembleDebug   (en Windows: gradlew assembleDebug)
3. El APK quedará en app/build/outputs/apk/debug/app-debug.apk

Nota: Asegúrate de tener instalado JDK 11+, Android SDK (platform 33), y variables ANDROID_HOME configuradas si compilas por terminal.
