/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Subclases;

import MainClasses.Estado;
import aima.search.framework.HeuristicFunction;
/**
 *
 * @author Ferran
 */
public class HeuristicFunctionOld implements HeuristicFunction {

    @Override
    public double getHeuristicValue(Object o) {
        int recorrido = 0;
        for (int i = 0; i < ((Estado)o).vecCamiones.size(); i++){
            recorrido += ((Estado)o).vecCamiones.get(i).recorridoDest1Dest2;
            recorrido += ((Estado)o).vecCamiones.get(i).recorridoOrigenDest1;
        }
        return -(((Estado)o).renta - recorrido);
        //calcular coste mirando la diferencia d bicis actual con la vieja en cada estacion
        /*int aux = 0;
        for (int i : ((Estado)o).difDemandaBicis){
            aux += i;
        }
        if (((Estado)o).renta < 100) return -((Estado)o).renta;
        return -aux;*/
    }
}
