/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias.servicios;

import estancias.persistencia.ClienteDAO;
import java.util.Scanner;

/**
 *
 * @author Gustavo Torti <guztorti@gmail.com>
 */
public class Orchestrator {

    private FamiliaServicio fs;
    private CasaServicio cs;
    private Scanner scn;
    private ClienteDAO clDAO;
    private String mensaje  = " a) Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.\n"
                + "b) Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de\n"
                + "\tagosto de 2020 y el 31 de agosto de 2020 en Reino Unido.\n"
                + "c) Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.\n"
                + "d) Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha\n"
                + "\tdada y un número de días específico.\n"
                + "e) Listar los datos de todos los clientes que en algún momento realizaron una estancia\n"
                + "\ty la descripción de la casa donde la realizaron.\n"
                + "f) Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre,\n"
                + "\tpaís y ciudad del cliente y además la información de la casa que reservó. La que\n"
                + "\treemplazaría a la anterior\n"
                + "g) Debido a la devaluación de la libra esterlina con respecto al euro se desea\n"
                + "\tincrementar el precio por día en un 5% de todas las casas del Reino Unido. Mostar\n"
                + "\tlos precios actualizados.\n"
                + "h) Obtener el número de casas que existen para cada uno de los países diferentes.\n"
                + "i) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas\n"
                + "\t(comentarios) que están ‘limpias’.\n"
                + "j) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.\n"
                + "\nz) Salir.\n";

    public Orchestrator() {
        scn = new Scanner(System.in).useDelimiter("\n");
        fs = new FamiliaServicio();
        cs = new CasaServicio();
        clDAO = new ClienteDAO();
    }
    public void menu() throws Exception{
        char opcion = '1';
        try{
        do {            
            System.out.println(mensaje);
            opcion = scn.next().toLowerCase().charAt(0);
            switch (opcion){
                case 'a':  //Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.
                    fs.listarFamiliasHijos(3, 0, 10);
                    break;
                case 'b':  //Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.
                    cs.listarCasasFechasPais("20200801", "20200831", "Reino Unido");
                    break;
                case 'c':  //Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.
                    fs.listarFamiliasEmailContiente("Hotmail");
                    break;
                case 'd':  //Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada y un número de días específico.
                    cs.listarCasasDesdeFechaCantidadDias("20200801", 10);
                    break;
                case 'e':  //Listar los datos de todos los clientes que en algún momento realizaron una estancia y la descripción de la casa donde la realizaron.
                    listarClientesQueRealizaronEstancia();
                    break;
                case 'f':  //Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y ciudad del cliente y además la información de la casa que reservó. La que reemplazaría a la anterior.
                    break;
                case 'g':  //Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios actualizados.
                    break;
                case 'h':  //Obtener el número de casas que existen para cada uno de los países diferentes.
                    break;
                case 'i':  //Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están ‘limpias’.
                    break;
                case 'j':  //Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.
                    break;
                case 'z':
                    System.out.println("muchas gracias y hasta luego!!");
                    break;
                default:
                    System.out.println("no se reconoce la opción elegida");
            }
        } while (opcion != 'z');
        }catch (Exception e){
            throw e;
        }
    }

    private void listarClientesQueRealizaronEstancia() {
        try {
            if (clDAO.listarClientesConEstancias().size()<1) {
                System.out.println("No hay clientes con esas características");
            } else {
                for (ListaClienteMensaje cliente : clDAO.listarClientesConEstancias()) {
                    System.out.println(cliente.toString());
                }
            }
        } catch (Exception e) {
        }
        
    }

}
