/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.persistencia;

/**
 *
 * @author Gustavo Torti
 */
public final class CasaDAO extends DAO{
    public void listarCasas(){
        String url = "SELECT * FROM casas WHERE calle LIKE ? AND numero LIKE ? AND codigo_postal LIKE ? AND ciudad LIKE ? AND pais LIKE ? AND fecha_desde >= ? AND fecha_hasta <= ? AND tiempo_minimo >= ? AND tiempo_maximo <= ? AND precio_habitacion LIKE ? AND tipo_vivienda LIKE ?;";
    }
    
}
