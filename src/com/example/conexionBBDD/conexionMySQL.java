package com.example.conexionBBDD;


/* JDBC Java Data Base Connectivity
*
* Será necesario un driver específico para cada SGBD, que deberemos instalar
* en el host que queramos usar como cliente de la conexión que que vaya a
* ejecutar la aplicación Java que realizará dicha conexión.
*
* Hay un conjunto de paquetes y clases que nos permitirán conectar con los
* diferentes sistemas gestores de BBDD e interactuar con ellos.
*
* Paquetes importantes: "Java.sql" y "Javax.sql"
*
* La clase más importante es la clase "DriverManager", con sus interfaces:
* "ResultSet", "Connection", "Statement" y "DataSource".
*
* https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/DriverManager.html
* */

import java.sql.*;

public class conexionMySQL {

    public static void main(String[] args) {

        /* Crear el objeto de tipo "Connection" . */
        try {
            /* 1. Crear conexión. */
            /* Se debe introducir la cadena de conexión según corresponda al gestor de bbdd
            * correspndiente. Además, el constructor necesario en este caso incluye usuario
            * y contraseña.
            * https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/Connection.html
            * */
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","NatAli_1411");

            /* 2. Creamos el objeto de tipo "Statement".
            * https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/Statement.html
            * */
            Statement query = conexion.createStatement();

            /* 3. Ejectutar sentencia mediante el método "executeQuery(String sql)" y la guardamos
             * un objeto de tipo "ResultSet". */
            ResultSet salidaQuery = query.executeQuery("SELECT * FROM ACTOR");

            /* 4. Leer resultados de la sentencia ejecutada del objeto "ResultSet"
            * https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/ResultSet.html
            *
            * Es necesario leer los resultados con un bucle indeterminado porque no
            * se puede saber el número de filas que devolverá la consulta. Para ello
            * se puede usar (entre otras opciones) el método "Boolean .next()", que
            * devolverá "false" cuando no haya más filas.
            * */
            while (salidaQuery.next()) {

                /* La lectura de cada fila se hace por cada columna, pudiendo acceder
                * por posición de columna (empezando desde la 1), o por el nombre
                * entrecomillado de la columna (no es case sensitive). */
                System.out.println(salidaQuery.getString(1)+" "+salidaQuery.getString("LAST_NAME"));

            }

            /* 5. Cerrar "ResultSet" y "Connection" si hemos acabado. */
            salidaQuery.close();
            conexion.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
