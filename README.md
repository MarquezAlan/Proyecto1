# Proyecto1
# 1.-Enunciado 
Crear una aplicacion de la lista de tareas que permita a los usuarios -> 

a).- Agregar nuevas tareas.

b).- Marcarlas como completadas .

c).- Eliminarlas de la lista.

d).- Generar reportes por estados de tareas en curso .

e).- Tareas completadas .

- Lenguaje de programacion 

# 2.-Planificacion

Funcionalidades:

## - Agregar nuevas tareas:

Interfaz de usuario para que los usuarios ingresen el nombre de la tarea y la agreguen a la lista.
Lógica para almacenar las nuevas tareas en la memoria de la aplicación (por ejemplo, en un arreglo o en el almacenamiento local del navegador).

## - Marcar tareas como completadas:

Permitir a los usuarios seleccionar una tarea de la lista y marcarla como completada.
Actualizar el estado de la tarea en la memoria de la aplicación.

## - Eliminar tareas:

Permitir a los usuarios eliminar tareas de la lista.
Eliminar la tarea correspondiente de la memoria de la aplicación.

## - Generar reportes:

Crear una funcionalidad para generar reportes que muestren el estado de las tareas (en curso, completadas).
Presentar los reportes de manera clara y comprensible en la interfaz de usuario.

## - Tareas completadas:

Mostrar las tareas completadas en una sección separada de la aplicación.
Permitir a los usuarios ver las tareas completadas.

# 3.-Diseño

Clase Main (Principal):

Esta clase contendrá el método main.
Será responsable de inicializar la interfaz de usuario y ejecutar el bucle principal de la aplicación.
Interfaz de Usuario (TaskUI):

Gestionará la interacción con el usuario a través de la consola.
Mostrará un menú con las opciones disponibles.
Llamará a los métodos correspondientes en función de la opción seleccionada por el usuario.
Tendrá métodos para agregar, marcar como completada, eliminar tareas y generar reportes.
Clase TaskManager (Gestor de Tareas):

Administrará las tareas.
Tendrá métodos para agregar, marcar como completada y eliminar tareas.
Podrá proporcionar una lista de todas las tareas y métodos para generar reportes.
Clase Task (Tarea):

Representará una tarea.
Tendrá propiedades como el nombre de la tarea y su estado (pendiente o completada).

# 4.-Ramas

Rama de Desarrollo Principal (master/main): Esta rama contendrá el código base y las integraciones finales. Los desarrolladores pueden fusionar sus cambios aquí una vez que estén completos y probados.

Rama de Funcionalidad de Agregar Tareas (feature/add-task): Un desarrollador trabajará en esta rama para implementar la funcionalidad de agregar nuevas tareas. Aquí se pueden realizar cambios relacionados con la adición de tareas, como la interfaz de usuario para agregar tareas, la lógica para almacenarlas en una base de datos, etc.

Rama de Funcionalidad de Marcar Tareas Completadas (feature/complete-task): Otro desarrollador puede trabajar en esta rama para implementar la funcionalidad de marcar tareas como completadas. Esto puede incluir la lógica para cambiar el estado de una tarea en la base de datos, actualizar la interfaz de usuario para reflejar las tareas completadas, etc.

Rama de Funcionalidad de Eliminar Tareas (feature/delete-task): El tercer desarrollador puede trabajar en esta rama para implementar la funcionalidad de eliminar tareas de la lista. Aquí se puede trabajar en la lógica para eliminar tareas tanto en la interfaz de usuario como en la base de datos.

# 5.-Funciones (Asignado)

## Día 1:

Desarrollador 1 (Rama feature/add-task):

Implementar la funcionalidad de agregar nuevas tareas.
Crear la interfaz de usuario para permitir a los usuarios agregar nuevas tareas.
Asegurarse de que las tareas agregadas se almacenen correctamente en la lista de tareas.
Desarrollador 2 (Rama feature/complete-task):

Implementar la funcionalidad de marcar tareas como completadas.
Desarrollar la interfaz de usuario para que los usuarios puedan marcar las tareas como completadas.
Asegurarse de que el estado de las tareas se actualice correctamente después de marcarlas como completadas.

## Día 2:

Desarrollador 1 (Rama feature/add-task):

Realizar pruebas exhaustivas de la funcionalidad de agregar tareas.
Corregir cualquier error o problema identificado durante las pruebas.
Realizar integración parcial con la rama principal para asegurarse de que no haya conflictos.
Desarrollador 3 (Rama feature/delete-task):

Implementar la funcionalidad de eliminar tareas de la lista.
Crear la interfaz de usuario para permitir a los usuarios eliminar tareas.
Asegurarse de que las tareas se eliminen correctamente de la lista.

## Día 3:

Desarrollador 2 (Rama feature/complete-task):

Realizar pruebas exhaustivas de la funcionalidad de marcar tareas como completadas.
Corregir cualquier error o problema identificado durante las pruebas.
Realizar integración parcial con la rama principal para asegurarse de que no haya conflictos.
Desarrollador 3 (Rama feature/delete-task):

Realizar pruebas exhaustivas de la funcionalidad de eliminar tareas.
Corregir cualquier error o problema identificado durante las pruebas.
Realizar integración parcial con la rama principal para asegurarse de que no haya conflictos.
