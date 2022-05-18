/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lorenita
 */
public abstract class DAO {

    private Statement sentencia = null;
    private Connection conexion = null;
    protected ResultSet resultado = null;
    private PreparedStatement sentenciaPreparada = null;

    private final String USER = "root";
    private final String PASSWORD = "root1234";
    private final String DATABASE = "estancias_exterior";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    protected void conectarBase() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?zeroDateTimeBehavior=convertToNull&ServerTimezone=UTC&useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    protected void desconectarBase() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {

            throw e;
        }
    }

    protected void insertarModificarBorrar(String url) throws ClassNotFoundException, SQLException, Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(url);
        } catch (ClassNotFoundException | SQLException e) {
            conexion.rollback();
            throw e;
        } finally {

            desconectarBase();
        }
    }

    protected void consultarBase(String url) throws ClassNotFoundException, SQLException {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(url);
        } catch (ClassNotFoundException| SQLException e) {
            throw e;
        }
    }
}
