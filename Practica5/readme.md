Practica 5

Curso: Programación de Dispositivos Móviles
Tema: Fragments y Navegación
Estudiante: Abimael Ernesto Frontado Fajardo

1. Descripción general del proyecto

Este proyecto implementa una aplicación Android que permite al usuario configurar un pedido de comida paso a paso utilizando Fragments y el componente de Navegación (Navigation Component).
El flujo guía al usuario desde la pantalla de inicio hasta el resumen del pedido, aplicando buenas prácticas de paso de datos entre fragments mediante Bundle, setFragmentResult(), setFragmentResultListener() y navegación con findNavController().

2. Objetivos de aprendizaje

Implementar navegación entre fragments usando Navigation Component.

Transferir datos entre fragments con Bundle.

Comunicar datos de regreso con setFragmentResult().

Usar popBackStack() para retornar al fragmento anterior.

Aplicar View Binding correctamente.

3. Estructura de Fragments
Fragment	Descripción	Acción principal
InicioFragment	Pantalla inicial con un botón “Nuevo pedido”.	Navega a SeleccionComidaFragment.
SeleccionComidaFragment	Permite elegir el tipo de comida (pizza, hamburguesa, ensalada).	Envía el tipo de comida mediante Bundle y navega a SeleccionExtrasFragment.
SeleccionExtrasFragment	Permite elegir extras (bebida, papas, postre).	Agrega los extras al Bundle y navega a ResumenPedidoFragment.
ResumenPedidoFragment	Muestra la comida y los extras seleccionados.	Botones “Confirmar pedido” (muestra Toast y vuelve al inicio) y “Editar pedido” (envía datos de regreso mediante setFragmentResult()).

4. Estructura del proyecto
app/
├── java/com/abi/myapplication/
│   ├── MainActivity.kt
│   ├── InicioFragment.kt
│   ├── SeleccionComidaFragment.kt
│   ├── SeleccionExtrasFragment.kt
│   └── ResumenPedidoFragment.kt
└── res/
    ├── layout/
    │   ├── fragment_inicio.xml
    │   ├── fragment_seleccion_comida.xml
    │   ├── fragment_seleccion_extras.xml
    │   ├── fragment_resumen_pedido.xml
    │   └── activity_main.xml
    └── navigation/
        └── nav_graph.xml

5. Configuración esencial del proyecto
5.1 Activar View Binding

En el archivo build.gradle (Module: app) se debe agregar dentro del bloque android { ... }:

buildFeatures {
    viewBinding = true
}


Esto permite utilizar clases generadas automáticamente como:

FragmentInicioBinding
FragmentSeleccionComidaBinding
FragmentSeleccionExtrasBinding
FragmentResumenPedidoBinding
ActivityMainBinding
 
En el archivo activity_main.xml debe incluirse el host del gráfico de navegación:

<androidx.fragment.app.FragmentContainerView
    android:id="@+id/nav_host_fragment"
    android:name="androidx.navigation.fragment.NavHostFragment"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:navGraph="@navigation/nav_graph"
    app:defaultNavHost="true" />


Si aparece error en app:navGraph="@navigation/nav_graph", asegurarse de:

Crear la carpeta res/navigation/ si no existe.

Colocar nav_graph.xml dentro de esa carpeta.

Realizar Build → Rebuild Project para regenerar referencias.

6. Errores comunes y soluciones
Error	Causa	Solución
Unresolved reference: databinding	View Binding no habilitado.	Agregar buildFeatures { viewBinding = true } y sincronizar el proyecto.
Unresolved reference: findNavController	Falta dependencia del Navigation Component.	Verificar que navigation-fragment-ktx y navigation-ui-ktx estén agregadas.
Unresolved reference: FragmentInicioBinding	Nombre o layout incorrecto.	Asegurar que el XML se llame fragment_inicio.xml y que el binding se genere automáticamente tras sincronizar.
Error en app:navGraph="@navigation/nav_graph"	Falta o ubicación incorrecta del archivo nav_graph.xml.	Crear carpeta res/navigation/ y agregar nav_graph.xml allí.
Errores en FragmentSeleccionComidaBinding	Error tipográfico o falta de sincronización.	Verificar nombre del archivo y realizar Build → Clean Project + Rebuild Project.
7. Dependencias recomendadas

Asegúrese de incluir las siguientes dependencias en build.gradle (Module: app):

implementation("androidx.navigation:navigation-fragment-ktx:2.8.3")
implementation("androidx.navigation:navigation-ui-ktx:2.8.3")
implementation("androidx.constraintlayout:constraintlayout:2.1.4")
implementation("com.google.android.material:material:1.12.0")


Estas versiones pueden variar según la versión de Android Studio utilizada.

8. Ejecución del proyecto

Abrir el proyecto en Android Studio.

Confirmar que viewBinding esté activado.

Confirmar que el archivo nav_graph.xml se encuentre en res/navigation/.

Realizar Build → Rebuild Project.

Ejecutar el proyecto en un emulador o dispositivo físico.

Verificar el flujo:

“Nuevo pedido” → “Seleccionar comida” → “Seleccionar extras” → “Resumen del pedido”.

Desde el resumen se puede confirmar o editar el pedido correctamente.
 
 
