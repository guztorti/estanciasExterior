/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.persistencia;

import estancias.entidades.Familia;
import java.sql.SQLException;

/**
 *
 * @author Gustavo Torti
 */
public final class FamiliaDAO extends DAO{
    public void guardarFamilia(Familia familia) throws SQLException, ClassNotFoundException, Exception{
        try {
            if (familia == null) {
                throw new NullPointerException("se debe enviar la familia como parámetro");
            }
                conectarBase(); 
                String url = "INSERT INTO familias(nombre, edad_mimima, edad_maxima, num_hijos, email, id_casa_familia) VALUES ('"
                        +familia.getNombre()+ "', '"+familia.getEdadMinima()+"', '"+familia.getEdadMaxima()+"', '"+familia.getNumDeHijos()
                        +"', '"+familia.getEmail()+"', "+familia.getIdCasaFamilia()+");";
                insertarModificarBorrar(url);
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        }
    }
}
