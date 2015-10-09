/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Subclases;

import IA.Bicing.Estaciones;
import MainClasses.Bicing;
import MainClasses.Estado;

/**
 *
 * @author Ferran
 */
public class EstadoInicial extends Estado{

    public EstadoInicial(Estaciones e, int numCamiones, int numBicis) {
        super(numCamiones);
        generaEstadoInicial(e, numCamiones);
    }

    private void generaEstadoInicial(Estaciones e, int numCamiones){  
        int k = 0;
 
        for (int i = 0; i < e.size(); i++) {
            int aux = e.get(i).getNumBicicletasNext()- e.get(i).getDemanda();
            if (aux > 0){
                if(k < numCamiones){
                    vecCamiones.get(k).origen = i;
                    vecCamiones.get(k).NumBicis = aux<Bicing.maxBici?aux:Bicing.maxBici;
                }
                estacOver.add(i);
                bicisSobranTotal += aux;
            }
            else {
                estacUnder.add(i);
                bicisFaltanTotal += aux;
            }
        }
        
    }
}
