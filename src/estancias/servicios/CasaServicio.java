/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.servicios;

import estancias.entidades.Casa;
import estancias.persistencia.CasaDAO;
import java.sql.SQLException;

/**
 *
 * @author Gustavo Torti
 */
public class CasaServicio {
    private CasaDAO dao = null;

    public CasaServicio() {
        dao = new CasaDAO();
    }
    
    public void listarCasasFechasPais(String fechaD, String fechaH, String pais) throws ClassNotFoundException, SQLException, Exception{
        try {
            for (Casa casa : dao.listarCasasEntreFechasPorPais(pais, fechaD, fechaH)){
                //Casa casa : dao.listarCasas("'%'", 0, "'%'", "'%'", pais, fechaD, fechaH, 0, 365, 1000000.0, "'%'")) {
                System.out.println(casa);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } catch (Exception ex){
            throw ex;
        }
         
    }

    void listarCasasDesdeFechaCantidadDias(String fechaD,  int cantDias) throws ClassNotFoundException, SQLException, Exception{
        try {
            if (dao.listarCasasEntreFechasPorTiempo(fechaD, cantDias).size()<1) {
                System.out.println("no hay casas disponibles desde la fecha , y por el tiempo indicado");
            } else {
                for (Casa casa : dao.listarCasasEntreFechasPorTiempo(fechaD, cantDias)){
                System.out.println(casa);
            }
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
}

    
}
