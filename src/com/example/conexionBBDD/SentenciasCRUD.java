package com.example.conexionBBDD;

import java.sql.*;

public class SentenciasCRUD {

    public static void main(String[] args) {

        /* Crear el objeto de tipo "Connection" . */
        try {
            /* 1. Crear conexión.
             * https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/Connection.html
             * */
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","NatAli_1411");

            /* 2. Creamos el objeto de tipo "Statement".
             * https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/Statement.html
             * */
            Statement query = conexion.createStatement();

            /* 3. En este caso, al desear ejecutar sentencias de tipo actualización de BBDD,
             * ejectutar sentencia mediante el método "int executeUpdate(String sql)" cuyo
             * resultado es un "int" con el número de filas afectadas por la sentencia.
             *
             * https://docs.oracle.com/en/java/javase/11/docs/api/java.sql/java/sql/Statement.html#executeUpdate(java.lang.String)*/

            //int resultadoI = query.executeUpdate("INSERT INTO ACTOR (FIRST_NAME,LAST_NAME) VALUES ('JARED','LETO')");
            //int resultadoU = query.executeUpdate("UPDATE ACTOR SET LAST_NAME = 'CRUZ' WHERE FIRST_NAME = 'PENELOPE'");
            int resultadoD = query.executeUpdate("DELETE FROM ACTOR WHERE ACTOR_ID = 202");


            /* 4. Si es preciso, leer operar con el resultado de la sentencia de actualización
             * */
            //System.out.println("Filas afectadas inserción: "+resultadoI);
            //System.out.println("Filas afectadas actualización: "+resultadoU);
            System.out.println("Filas afectadas borradas: "+resultadoD);

            /* 5. Cerrar "ResultSet" y "Connection" si hemos acabado. (En este caso, no hay
            * "ResultSet" al ser sentencias de actualización. */
            query.close();
            conexion.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
