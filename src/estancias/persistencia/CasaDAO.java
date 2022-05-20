/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.persistencia;

import estancias.entidades.Casa;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Torti
 */
public final class CasaDAO extends DAO {

//    public ArrayList<Casa> listarCasas(String calle, int numero, String CP, String ciudad, String pais, String fechaDesde, String fechaHasta, int tiempoMin, int tiempoMax, double precioHab, String tipoVivienda) throws ClassNotFoundException, SQLException, Exception {
//        String url = "SELECT * FROM casas WHERE calle LIKE ? AND numero LIKE ? AND codigo_postal LIKE ? AND ciudad LIKE ? AND pais LIKE ? AND fecha_desde >= ? AND fecha_hasta <= ? AND tiempo_minimo >= ? AND tiempo_maximo <= ? AND precio_habitacion <= ? AND tipo_vivienda LIKE ?;";
//        
//        try {
//            consultarBase(url, calle, numero, CP, ciudad, pais, fechaDesde, fechaHasta, tiempoMin, tiempoMax, precioHab, tipoVivienda);
//            ArrayList<Casa> casas = new ArrayList();
//            Casa casa = null;
//            
//            while (resultado.next()) {
//                casa = new Casa();
//                casa.setCalle(resultado.getString(2));
//                casa.setNumero(resultado.getInt(3));
//                casa.setCodigoPostal(resultado.getString(4));
//                casa.setCiudad(resultado.getString(5));
//                casa.setPais(resultado.getString(6));
//                casa.setFechaDesde(resultado.getString(7));
//                casa.setFechaHasta(resultado.getString(8));
//                casa.setTiempoMinimo(resultado.getInt(9));
//                casa.setTiempoMaximo(resultado.getInt(10));
//                casa.setPrecioHabitacion(resultado.getDouble(11));
//                casa.setTipoVivienda(resultado.getString(12));
//                casas.add(casa);
//            }
//            desconectarBase();
//            return casas;
//
//        } catch (ClassNotFoundException | SQLException e) {
//            desconectarBase();
//            throw e;
//        } catch (Exception ex) {
//            throw ex;
//        }
//
//    }
    
    public ArrayList<Casa> listarCasasEntreFechasPorPais( String pais, String fechaDesde, String fechaHasta) throws ClassNotFoundException, SQLException, Exception {
        String url = "SELECT * FROM casas WHERE  pais LIKE '"+pais+"' AND fecha_desde >= '"+fechaDesde+"' AND fecha_hasta <= '"+fechaHasta+"';";
        ArrayList<Casa> casas = new ArrayList();
        Casa casa = null;
        try {
            consultarBase(url);
            while (resultado.next()) {
                casa = new Casa();
                casa.setIdCasa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getDate(7));
                casa.setFechaHasta(resultado.getDate(8));
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                casas.add(casa);
            }
            desconectarBase();
            return casas;

        } catch (ClassNotFoundException | SQLException e) {
            desconectarBase();
            throw e;
        } catch (Exception ex) {
            throw ex;
        }

    }

    public ArrayList<Casa> listarCasasEntreFechasPorTiempo(String fechaD, int cantDias) throws ClassNotFoundException, SQLException, Exception {
        String url = "SELECT * FROM casas WHERE  fecha_desde >= '"+fechaD+"' AND tiempo_maximo >= "+cantDias+";";
        ArrayList<Casa> casas = new ArrayList();
        Casa casa = null;
        try {
            consultarBase(url);
            while (resultado.next()) {
                casa = new Casa();
                casa.setIdCasa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getDate(7));
                casa.setFechaHasta(resultado.getDate(8));
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                casas.add(casa);
            }
            desconectarBase();
            return casas;

        } catch (ClassNotFoundException | SQLException e) {
            desconectarBase();
            throw e;
        } catch (Exception ex) {
            throw ex;
        }
    }

}
