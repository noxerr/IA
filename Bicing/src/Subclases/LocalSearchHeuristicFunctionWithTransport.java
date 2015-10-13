/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Subclases;

import MainClasses.Estado;
import MainClasses.Furgoneta;
import aima.search.framework.HeuristicFunction;
/**
 *
 * @author Ferran
 */
public class LocalSearchHeuristicFunctionWithTransport implements HeuristicFunction {

    @Override
    public double getHeuristicValue(Object o) {
        //calcular coste mirando la diferencia d bicis actual con la vieja en cada estacion
        int h=0;
        for (Furgoneta f: ((Estado)o).vecCamiones){
            h = ((f.numBicis+9)/10)*(f.recorridoOrigenDest1/1000);
        }
        //return ((Estado) o).sumaSobraFalta;
        return h;
    }

}
