package com.example.conexionBBDD;

import java.sql.*;

public class conexionPostgreSQL {

    public static void main(String[] args) {

        try {
            /* 1. Crear conexión. */
            /* IMPORTANTE: En PostgreSQL el nombre de la BBDD es case sensitive!!!
            * https://jdbc.postgresql.org/documentation/80/connect.html*/
            Connection conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/GESTIONPEDIDOS","postgres","AliNata0");

            /* 2. Creamos el objeto de tipo "Statement".
            * IMPORTANTE: PostgreSQL es case sensitive!!! */
            PreparedStatement query = conexion.prepareStatement("SELECT * FROM \"gestionPedidos_clientes\"");

            /* 3. Ejectutar sentencia mediante el método "executeQuery(String sql)" y la guardamos
             * un objeto de tipo "ResultSet". */
            ResultSet salidaQuery = query.executeQuery();

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
                System.out.println(salidaQuery.getString(1)+" "+salidaQuery.getString("nombre"));

            }

            /* 5. Cerrar "ResultSet" y "Connection" si hemos acabado. */
            salidaQuery.close();
            conexion.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
