/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.servicios;

import estancias.entidades.Cliente;
import estancias.persistencia.ClienteDAO;

/**
 *
 * @author Gustavo Torti <guztorti@gmail.com>
 */
public class ClienteServicio {
    ClienteDAO dao;
    Cliente cliente;
   

    public ClienteServicio() {
        dao = new ClienteDAO();
        cliente = new Cliente();
    }
    
    
    
}
