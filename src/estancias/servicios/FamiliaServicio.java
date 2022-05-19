/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.servicios;

import estancias.entidades.Familia;
import estancias.persistencia.FamiliaDAO;
import java.sql.SQLException;

/**
 *
 * @author Gustavo Torti <guztorti@gmail.com>
 */
public class FamiliaServicio {
    FamiliaDAO dao;

    public FamiliaServicio() {
        dao = new FamiliaDAO();
    }
    public Familia crearFamilia(String nombre, int edadMin, int edadMax, int numHijos, String email, int idCasa) throws Exception, SQLException, ClassNotFoundException{
        Familia familia = new Familia(nombre,edadMin, edadMax, numHijos, email, idCasa);
        try {
            dao.guardarFamilia(familia);
            return familia;
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        } catch (Exception ex){
            throw ex;
        }
        
    }
    
    public void listarFamiliasHijos(int cantHijos, int edadMin, int edadMax) throws Exception{
        try {
            for (Familia familia : dao.consultarFamilia(cantHijos, edadMin, edadMax)) {
            System.out.println(familia);
            }
        
        } catch (Exception e) {
            throw e;
        }
        
        
    }
    
}
