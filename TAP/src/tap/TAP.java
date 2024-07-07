/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tap;

import java.sql.*;

public class TAP {

    static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql:148.225.64.5:3389";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection conexion = null; //Maneja la conexion statement
        Statement instruccion = null; //Instruccion de consulta resultset
        ResultSet conjuntoResultados = null; // Maneja los resultados

        String SQL = "SELECT * FROM books"; //Instruccion SQL
        String user = "fcirett";
        String password = "happy1234";

        try {
            //Carga la clase controlador
            Class.forName(CONTROLADOR);

            //Establece la conexion a la base de datos
            conexion = DriverManager.getConnection(URL, user, password);

            //Crea un objeto statement para consultar la base de datos
            instruccion = conexion.createStatement();

            //Consulta la base de datos
            conjuntoResultados = instruccion.executeQuery(SQL);

            System.out.println("Tabla de libros:\n");
            //Procesa los resultados de la consulta

            ResultSetMetaData metaDatos = conjuntoResultados.getMetaData();
            int numeroColumnas = metaDatos.getColumnCount();

            for (int i = 1; i <= numeroColumnas; i++) {
                System.out.printf("%-8s\t", metaDatos.getColumnName(i));
            }

            System.out.println("");

            while (conjuntoResultados.next()) {
                for (int i = 1; i <= numeroColumnas; i++) {
                    System.out.printf("%-8s\t", conjuntoResultados.getObject(i));
                }

                System.out.println("");

            }
        } catch (SQLException excepcionSql) {
            excepcionSql.printStackTrace();
                    
        } finally // asegura que conjuntoResultados, instruccion y conexion esten cerrados
        {
            try
            {
                conjuntoResultados.close();
                instruccion.close();
                conexion.close();
            } catch (Exception excepcion){
                excepcion.printStackTrace();
            }
        }
        

    }
}

