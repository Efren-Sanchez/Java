# Conexión a BD MySQL con JDBC

Ejemplos básicos de manejo de una BD MySQL con Java a través del driver JDBC.

## Ficheros

### MySQL_Conexion.java

    Ejemplo simple de conexión a una BD MySQL usando JDBC.

### MySQL_Sentencias1.java

    Ejemplo de ejecución de consulta SQL usando bloques try-catch anidados.

### MySQL_Sentencias2.java

    Ejemplo de ejecución de consulta SQL usando bloques try-catch al mismo nivel.

### MySQL_Sentencias3.java

    Ejemplo de ejecución de consulta SQL refinada para consultar primero el número de registros que se van a devolver.

### MySQL_Metodos1.java

    Ejemplo de clase con métodos individuales para cada acción sobre la BD.

    Se pasan las sentencias SQL como strings, lo que puede ser un problema de seguridad en el caso de obtener los datos si han sifo introducidos por el usuarios (SQL injection)

### MySQL_Metodos2.java

    Ejemplo de clase con métodos individuales para cada acción sobre la BD.

    En esta versión de empiezan a utilizar prepared staments para proteger las sentencias SQL.

### MySQLManager1.java

  **Cambios realizados:**

    obtenerSiguienteId: Este método ejecuta un SELECT MAX(columna). Si la tabla tiene registros, devuelve el valor más alto + 1. Si está vacía, devuelve 1. Es la forma manual de simular un Auto-increment.

    Los métodos insertar, actualizar y eliminar devuelven el número de filas afectadas, lo que permite al programador saber si la operación tuvo éxito.

    insertarRegistro (Genérico):

        Usa Object... parametros. Esto significa que puedes pasarle tantos datos como quieras separados por comas.

        Utiliza ps.setObject(i + 1, parametros[i]). El método setObject de JDBC es inteligente: si le pasas un String, lo trata como String; si le pasas un Integer, como Integer. Esto hace que el método sirva para cualquier tabla.

    El método consultarGenerico utiliza MetaData. Esto significa que no necesitas saber los nombres de las columnas de antemano; el método lee la estructura de la tabla y te devuelve una lista fácil de recorrer.
    
    Utiliza el bloque try-with-resources en el main. Esto garantiza que, pase lo que pase (incluso si hay un error), la conexión a la base de datos se cerrará automáticamente, evitando fugas de memoria.

    He incluido los esqueletos para commit y rollback, necesarios cuando quieres realizar varias operaciones que deben tener éxito juntas (como cobrar una factura y restar stock al mismo tiempo).
    
    Uso en main:

        Primero llamamos a obtenerSiguienteId para saber qué número toca.

        Luego pasamos ese ID y el resto de datos al método insertarRegistro.

        Esto garantiza que nunca intentarás insertar un ID duplicado (Primary Key violation).

  **Características de esta versión:**

    Seguridad Total: Uso de PreparedStatement en todos los métodos de escritura (crear, actualizar, borrar) para blindar la aplicación contra inyecciones SQL.

    Abstracción Genérica: El método ejecutarActualizacion centraliza la lógica de escritura, permitiendo que crearRegistro o actualizarRegistro sean muy simples.

    Flexibilidad de Datos: El uso de Object... parametros (varargs) permite que pases cualquier tipo de dato (String, Integer, Double, Date) sin preocuparte por la conversión manual.

    Gestión de Transacciones: Incluye el bloque try-catch dentro del main para demostrar cómo el deshacerTransaccion protege la integridad de los datos si ocurre un error inesperado a mitad de un proceso.

    Consulta de Metadatos: El método consultarRegistros lee los nombres de las columnas directamente de la base de datos, lo que lo hace compatible con cualquier tabla sin necesidad de cambiar el código.

    Formato JavaDOC: Todos los métodos incluyen la documentación estándar de Java, lista para ser exportada a HTML si fuera necesario.

### MySQLManager2.java

  **Características de esta versión:**

    Independencia de Datos: El uso de meta.getColumnLabel(i) en lugar de getColumnName permite que, si haces una consulta con alias (ej: SELECT nombre AS alias_nombre...), el mapa use el alias correctamente.

    Seguridad de Tipos Interna: El método ejecutarEscritura es ahora privado. Esto obliga a los desarrolladores a usar los métodos semánticos (crear, actualizar, borrar), lo que hace el código más legible.

    Mantenibilidad: Si mañana decides cambiar de MySQL a MariaDB o SQLite, solo tienes que llamar a configurarConexion al principio de tu programa. No tienes que entrar en esta clase a cambiar Strings.

    Uso de String.format: Hace que las consultas dinámicas (como las de borrar por ID) sean mucho más fáciles de leer que concatenando con +.

## Falta

- Añadir biblioteca.sql a la carpeta lib.
