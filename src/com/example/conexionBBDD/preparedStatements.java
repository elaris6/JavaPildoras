package com.example.conexionBBDD;

import java.sql.*;

/* Las consultas preparadas o prepared statemens son consultas SQL almacenadas como
* objetos que tienen las siguientes ventajas:
*
* - Permiten pasar parámetros a las sentencia SQL
* - Son reutilizables
* - Previenen ataques de inyección SQL
* - Tienen un mejor rendimiento al estar precompiladas
*
* Para ello se hará uso de la interfaz "PreparedStatement".
* https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/PreparedStatement.html
*
* */
public class preparedStatements {

    public static void main(String[] args) {

        /* Crear el objeto de tipo "Connection" . */
        try {
            /* 1. Crear conexión. */
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","NatAli_1411");

            /* 2. Creamos el objeto de tipo "PreparedStatement" con el método
            * ".prepareStatement(String sql)" del objeto "Connection".
            * Se puede crear un objeto String con la query o introducirla directamente
            * como parámetro del método "prepareStatement". */
            String queryString = "SELECT * FROM ACTOR WHERE ACTOR_ID > ? AND ACTOR_ID < ?";
            PreparedStatement query = conexion.prepareStatement(queryString);

            /* Se requiere asignar valor individualmente a cada parámetro con el método
            * ".setString(int indez, String value)". Los parámetros comienzan por 1. */
            query.setString(1,"100");
            query.setString(2,"110");

            /* 3. Ejectutar sentencia mediante el método "executeQuery()" pero en esta
            * ocasión sin parámetro, y la guardamosen un objeto de tipo "ResultSet",
            * como haríamos con una query que no sea preparada. */
            ResultSet salidaQuery = query.executeQuery();

            /* 4. Leer resultados de la sentencia ejecutada del objeto "ResultSet" */
            System.out.println("\nPrimera  consulta\n");
            while (salidaQuery.next()) {

                /* La lectura de cada fila se hace por cada columna, pudiendo acceder
                 * por posición de columna (empezando desde la 1), o por el nombre
                 * entrecomillado de la columna (no es case sensitive). */
                System.out.println(salidaQuery.getString(1)+" "+salidaQuery.getString("LAST_NAME"));

            }

            /* Reutilización de consulta preparada. */

            query.setString(1,"120");
            query.setString(2,"130");
            salidaQuery= query.executeQuery();

            System.out.println("\nSegunda consulta\n");
            while (salidaQuery.next()) {
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
