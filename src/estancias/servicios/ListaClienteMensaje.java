/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.servicios;

import estancias.entidades.Cliente;

/**
 *
 * @author cecsa
 */
public class ListaClienteMensaje {

    private Cliente cliente;
    private String mensaje;

    public ListaClienteMensaje() {
    }

    public ListaClienteMensaje(Cliente cliente, String mensaje) {
        this.cliente = cliente;
        this.mensaje = mensaje;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cliente=" + cliente.getNombre() +"calle=" + cliente.getCalle() +"número=" + cliente.getNumero() +" CP=" + cliente.getCodigoPostal()+ " pais: "+ cliente.getPais()+" email: "+cliente.getEmail()+", mensaje=" + mensaje + '}';
    }
    
    
}
