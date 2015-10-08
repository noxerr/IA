/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Subclases;

import IA.Bicing.Estacion;
import IA.Bicing.Estaciones;
import MainClasses.Estado;

/**
 *
 * @author Ferran
 */
public class EstadoInicial extends Estado{

    public EstadoInicial(Estaciones e, int numCamiones, int numBicis) {
        super(numCamiones);
        generaEstadoInicial(e);
    }

    private void generaEstadoInicial(Estaciones e){  
        int aux;
        for (Estacion e1 : e) {
            aux = e1.getNumBicicletasNext()-e1.getDemanda();
            if (aux > 0) estacOver.add(e1);
            else estacUnder.add(e1);
            difBicis += aux;
        }
        
    }

}
