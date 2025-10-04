# Activiades en Clase:  RecyclerView con Edición y Long Click

**Curso:** Programación de Dispositivos Móviles  
**Tema:** RecyclerView con Edición y Long Click  
**Estudiante:** Abimael Ernesto Frontado Fajardo  

---

## 1. Descripción general del proyecto

Este proyecto implementa una aplicación Android que muestra una lista de usuarios utilizando el componente **RecyclerView**.  
Cada usuario se puede **editar o eliminar** mediante un **long click**, el cual despliega un menú de opciones.  
Además, el usuario puede **agregar nuevos elementos** utilizando un botón flotante.  

La práctica aplica conceptos de **View Binding**, **RecyclerView Adapter**, **ViewHolder**, y **diálogos personalizados** para la edición de datos.

---

## 2. Objetivos de aprendizaje

- Implementar un RecyclerView para mostrar una lista de elementos.  
- Detectar eventos de **click y long click** en cada elemento.  
- Mostrar un **menú contextual** con opciones de Editar o Eliminar.  
- Utilizar un **diálogo personalizado** para editar información.  
- Aplicar **View Binding** en Fragmentos, Adapters y Diálogos.  
- Actualizar la lista dinámicamente con `notifyItemChanged()` y `notifyItemRemoved()`.  

---

## 3. Estructura de Fragments y Componentes

| Componente | Descripción | Acción principal |
|-------------|--------------|------------------|
| **RecyclerViewFragment** | Fragmento que contiene la lista de usuarios y el botón flotante. | Muestra los usuarios y permite agregar nuevos. |
| **UsuarioAdapter** | Adaptador del RecyclerView. | Muestra cada usuario, detecta long clicks y gestiona las acciones. |
| **UsuarioProvider** | Contenedor con la lista de usuarios (datos iniciales). | Provee los datos al adapter. |
| **Dialog Editar Usuario** | Diálogo personalizado con campos para editar nombre y correo. | Modifica los datos del usuario seleccionado. |

---

## 4. Estructura del proyecto

app/
├── java/com/example/recyclerviewapp/
│ ├── MainActivity.kt
│ ├── RecyclerViewFragment.kt
│ ├── Usuario.kt
│ ├── UsuarioProvider.kt
│ └── adapter/
│ └── UsuarioAdapter.kt
└── res/
├── layout/
│ ├── activity_main.xml
│ ├── fragment_recycler_view.xml
│ ├── item_usuario.xml
│ └── dialog_edit_usuario.xml
└── values/
├── colors.xml
├── strings.xml
└── themes.xml

yaml
Copiar código

---

## 5. Configuración esencial del proyecto

### 5.1 Activar View Binding

En el archivo `build.gradle (Module: app)`, dentro del bloque `android { ... }` agregar:

```gradle
buildFeatures {
    viewBinding = true
}
Esto permitirá utilizar clases generadas automáticamente como:

FragmentRecyclerViewBinding

ItemUsuarioBinding

DialogEditUsuarioBinding

ActivityMainBinding

5.2 Layout principal
En el archivo activity_main.xml debe incluirse un contenedor para el fragmento:

xml
Copiar código
<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/fragmentContainerView"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
Y en MainActivity.kt:

kotlin
Copiar código
supportFragmentManager.beginTransaction()
    .replace(R.id.fragmentContainerView, RecyclerViewFragment())
    .commit()
6. Errores comunes y soluciones
Error	Causa	Solución
Unresolved reference: databinding	View Binding no habilitado.	Agregar buildFeatures { viewBinding = true } y sincronizar el proyecto.
Unresolved reference: UsuarioAdapter	Falta importar o error en el paquete del adapter.	Verificar que esté en com.example.recyclerviewapp.adapter.
App se cierra al hacer long click	Contexto nulo o mal inflado del menú.	Usar requireContext() dentro del Fragment o ViewHolder.
Los cambios no se reflejan	Falta llamar notifyItemChanged() o notifyItemRemoved().	Asegurarse de actualizar el adapter tras modificar la lista.
Error al inflar el diálogo	Error en el layout del diálogo o falta de View Binding.	Revisar dialog_edit_usuario.xml y usar DialogEditUsuarioBinding.

7. Dependencias recomendadas
Asegúrate de incluir las siguientes dependencias en tu build.gradle (Module: app):

gradle
Copiar código
implementation("androidx.recyclerview:recyclerview:1.3.2")
implementation("com.google.android.material:material:1.12.0")
implementation("androidx.constraintlayout:constraintlayout:2.1.4")
implementation("androidx.fragment:fragment-ktx:1.8.2")
8. Ejecución del proyecto
Abrir el proyecto en Android Studio.

Confirmar que View Binding esté activado.

Realizar Build → Rebuild Project.

Ejecutar el proyecto en un emulador o dispositivo físico.

Flujo esperado:
Se muestra la lista de usuarios inicial.

Al mantener presionado un usuario, aparece un menú con:

Editar → abre un diálogo con los datos del usuario.

Eliminar → borra el usuario de la lista.

Con el botón “+” (FloatingActionButton) se puede agregar un nuevo usuario.

Los cambios se actualizan inmediatamente en pantalla.
