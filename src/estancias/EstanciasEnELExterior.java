/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estancias;

import estancias.servicios.Orchestrator;

/**
 *
 * @author Gustavo Torti
 */
public class EstanciasEnELExterior {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Orchestrator orch = new Orchestrator();
        orch.menu();
    }
    
}
