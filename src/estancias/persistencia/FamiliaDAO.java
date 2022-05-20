/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.persistencia;

import estancias.entidades.Familia;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Torti
 */
public final class FamiliaDAO extends DAO {

    public void guardarFamilia(Familia familia) throws SQLException, ClassNotFoundException, Exception {
        try {
            if (familia == null) {
                throw new NullPointerException("se debe enviar la familia como parámetro");
            }
            conectarBase();
            String url = "INSERT INTO familias(nombre, edad_mimima, edad_maxima, num_hijos, email, id_casa_familia) VALUES ('"
                    + familia.getNombre() + "', '" + familia.getEdadMinima() + "', '" + familia.getEdadMaxima() + "', '" + familia.getNumDeHijos()
                    + "', '" + familia.getEmail() + "', " + familia.getIdCasaFamilia() + ");";
            insertarModificarBorrar(url);
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        }
    }

    /**
     * *
     * Devuelve una lista de Familias que cumplen con los requisitos
     *
     * @param numHijos cantidad hasta
     * @param edadMin límite inferior del rango de edades
     * @param edadMax límite superior del rango de edades
     * @return ArrayList<Familia>
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws Exception
     */
    public ArrayList<Familia> consultarFamilia(int numHijos, int edadMin, int edadMax) throws ClassNotFoundException, SQLException, Exception {
        String url = "SELECT * FROM familias WHERE num_hijos <= ? AND edad_minima >= ? AND edad_maxima <=?";
        try {
            consultarBase(url, numHijos, edadMin, edadMax);
            ArrayList<Familia> familias = new ArrayList();
            Familia familia = null;

            while (resultado.next()) {
                familia = new Familia();
                familia.setIdFamilia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdadMinima(resultado.getInt(3));
                familia.setEdadMaxima(resultado.getInt(4));
                familia.setNumDeHijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familia.setIdCasaFamilia(resultado.getInt(7));
                familias.add(familia);
            }
            desconectarBase();
            return familias;
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } catch (Exception ex) {
            throw ex;
        }

    }

    public ArrayList<Familia> buscarEnEmail(String cadenaABuscar) throws ClassNotFoundException, SQLException, Exception {
        try {

            ArrayList<Familia> familias = new ArrayList();
            Familia familia = null;
            String url = "SELECT * FROM familias WHERE email LIKE '%" + cadenaABuscar + "%';";
            consultarBase(url);
            while (resultado.next()) {
                familia = new Familia();
                familia.setIdFamilia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdadMinima(resultado.getInt(3));
                familia.setEdadMaxima(resultado.getInt(4));
                familia.setNumDeHijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familia.setIdCasaFamilia(resultado.getInt(7));
                familias.add(familia);
            }
            desconectarBase();
            return familias;
        } catch (ClassNotFoundException | SQLException e) {
            throw e;

        } catch (Exception e) {
            throw e;
        }
    }
}
