/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.persistencia;

import estancias.entidades.Cliente;
import estancias.servicios.ListaClienteMensaje;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Torti
 */
public final class ClienteDAO extends DAO{

    public ArrayList<ListaClienteMensaje> listarClientesConEstancias() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<ListaClienteMensaje> clientes = new ArrayList();
        try {
            String url = "SELECT cli.*, com.comentario  FROM (clientes cli INNER JOIN estancias est ON est.id_cliente = cli.id_cliente INNER JOIN casas ca ON est.id_casa = ca.id_casa INNER JOIN comentarios com ON ca.id_casa = com.id_casa) GROUP BY cli.id_cliente;";
            consultarBase(url);
            
            while (resultado.next()){
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setCalle(resultado.getString(3));
                cliente.setNumero(resultado.getInt(4));
                cliente.setCodigoPostal(resultado.getString(5));
                cliente.setCiudad(resultado.getString(6));
                cliente.setPais(resultado.getString(7));
                cliente.setEmail(resultado.getString(8));
                String mensaje = resultado.getString(9);
                ListaClienteMensaje objeto = new ListaClienteMensaje(cliente, mensaje);
                clientes.add(objeto);
            }
            desconectarBase();
            return clientes;
        } catch (ClassNotFoundException | SQLException e) {
            desconectarBase();
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
    
    
}
