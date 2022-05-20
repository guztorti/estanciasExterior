/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.persistencia;

import java.sql.Connection;
import java.sql.Date;
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
    
    protected void consultarBase(String url , int dato1, int dato2, int dato3) throws ClassNotFoundException, SQLException{
        try {
            conectarBase();
            sentenciaPreparada = conexion.prepareStatement(url);
            sentenciaPreparada.setInt(1, dato1);
            sentenciaPreparada.setInt(2, dato2);
            sentenciaPreparada.setInt(3, dato3);
            resultado = sentenciaPreparada.executeQuery();
            
        } catch (ClassNotFoundException| SQLException e) {
            throw e;
        }
    }
    
    protected void consultarBase(String url , String dato1, int dato2, String dato3, String dato4, String dato5, String dato6, String dato7, int dato8, int dato9, double dato10, String dato11) throws ClassNotFoundException, SQLException{
        try {
            conectarBase();
            sentenciaPreparada = conexion.prepareStatement(url);
            sentenciaPreparada.setString(1, dato1); //calle
            sentenciaPreparada.setInt(2, dato2); //numero
            sentenciaPreparada.setString(3, dato3); //codigo postal
            sentenciaPreparada.setString(4, dato4); //ciudad
            sentenciaPreparada.setString(5, dato5); //pais
            sentenciaPreparada.setString(6, dato6); //fecha desde
            sentenciaPreparada.setString(7, dato7); //fecha desde
            sentenciaPreparada.setInt(8, dato8); //tiempo minimo
            sentenciaPreparada.setInt(9, dato9); //tiempo maximo
            sentenciaPreparada.setDouble(10, dato10); //prcio habitacion
            sentenciaPreparada.setString(11, dato11); //tipo vivienda
            resultado = sentenciaPreparada.executeQuery();
            
        } catch (ClassNotFoundException| SQLException e) {
            throw e;
        }
    }
}
