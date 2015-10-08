/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Subclases;

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
        for (int i = 0; i < e.size(); i++) {
            if (e.get(i).getNumBicicletasNext()-e.get(i).getDemanda() > 0) estacOver.add(i);
            else estacUnder.add(i);
        }
        bicisFaltanTotal = estacUnder.size();
        bicisSobranTotal = estacOver.size();        
    }

}
