package com.example.conexionBBDD;

import java.sql.*;

public class conexionOracle {

    public static void main(String[] args) {

        /* Crear el objeto de tipo "Connection" . */
        try {
            /* 1. Crear conexión. */
            Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@lc1orb01:1523:DBBCKCAP","EXEBD","pass3x3BD");

            /* 2. Creamos el objeto de tipo "PreparedStatement" con el método
             * ".prepareStatement(String sql)" del objeto "Connection".
             * Se puede crear un objeto String con la query o introducirla directamente
             * como parámetro del método "prepareStatement". */
            String queryString = "SELECT * FROM APLICBD.BD_CENTRO WHERE ID_TIPO_CENTRO = ?";
            PreparedStatement query = conexion.prepareStatement(queryString);

            /* Se requiere asignar valor individualmente a cada parámetro con el método
             * ".setString(int indez, String value)". Los parámetros comienzan por 1. */
            query.setString(1,"12");

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
                System.out.println(salidaQuery.getString(1)+" "+salidaQuery.getString("nombre_sfc"));

            }


            /* 5. Cerrar "ResultSet" y "Connection" si hemos acabado. */
            salidaQuery.close();
            conexion.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
