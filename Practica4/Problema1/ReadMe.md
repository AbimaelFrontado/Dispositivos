Práctica 4: Comunicación entre Actividades en Android - Problema 1
Este proyecto de Android Studio demuestra la comunicación entre actividades utilizando Intents, el envío de datos a través de Serializable y el manejo de resultados de vuelta con registerForActivityResult. También muestra cómo persistir el estado de la UI durante cambios de configuración (como la rotación de la pantalla) usando onSaveInstanceState.

Contenido del Proyecto
El proyecto consta de una aplicación que permite:

Editar un perfil con confirmación: El usuario puede ingresar sus datos (nombre, edad, ciudad, correo), ver un resumen y confirmar la información.

Estructura del Proyecto
Los archivos están organizados en las siguientes carpetas, según las convenciones de Android Studio:

app/src/main/java/com.abi.myapplication/: Contiene todos los archivos de código Kotlin (.kt).

app/src/main/res/layout/: Contiene todos los archivos de diseño XML (.xml) de las interfaces de usuario.

app/src/main/: Contiene el archivo de configuración AndroidManifest.xml.

app/src/main/res/xml/: Deberás crear esta carpeta si no existe y colocar el archivo full_backup_content.xml dentro.

Requisitos y Configuración
Para que el proyecto se ejecute correctamente, ten en cuenta los siguientes puntos:

1. Dependencias
Asegúrate de que tu archivo build.gradle (Module: app) contenga la dependencia de AndroidX Activity, ya que registerForActivityResult depende de ella.

dependencies {
    // ...
    implementation 'androidx.activity:activity-ktx:1.8.0'  
}

Puede ser una versión más reciente.

2. Archivo AndroidManifest.xml
El archivo de manifiesto es crucial para declarar las actividades de tu aplicación. Debe estar ubicado en app/src/main/. Asegúrate de que las actividades estén declaradas correctamente.

<application 
    <activity
        android:name=".FormularioActivity"
        android:exported="true">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />
            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
    </activity>
    <activity
        android:name=".ResumenActivity"
        android:exported="false" />
</application>

3. Archivo full_backup_content.xml
Crear este archivo es necesario para la ejecución del programa. Su propósito es definir qué datos se incluyen o excluyen de las copias de seguridad automáticas de Android.

Ubicación: app/src/main/res/xml/full_backup_content.xml

Contenido básico:

<?xml version="1.0" encoding="utf-8"?>
<full-backup-content>
    <exclude domain="file" path="cache/"/>
</full-backup-content>

Cómo Ejecutar el Proyecto
Abre el proyecto en Android Studio.

Sincroniza el proyecto con los archivos de Gradle.

Ejecuta la aplicación en un emulador o un dispositivo físico.

El FormularioActivity será la primera pantalla que se inicie.
