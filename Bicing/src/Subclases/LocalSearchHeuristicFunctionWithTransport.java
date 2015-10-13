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
            //int test = ((f.numBicis+9-(f.bicisIniciales-f.numBicis))/10)*(f.recorridoOrigenDest1/1000);
            //if(f.dest1!=-1 && f.dest2!=-1){
                //System.out.println("Bicis furgo: " + f.numBicis + " Bicis iniciales: " + f.bicisIniciales + " Resultado: " + test + " O: "+ f.origen + " D1: " + f.dest1 + " D2: "+ f.dest2);
            //}
            //if(f.origen == -1){
                //System.out.println("Bicis furgo: " + f.numBicis + " Bicis iniciales: " + f.bicisIniciales + " Resultado: " + test + " O: "+ f.origen + " D1: " + f.dest1 + " D2: "+ f.dest2);
            //}
            
            
            
            h += ((f.numBicis+9-(f.bicisIniciales-f.numBicis))/10)*(f.recorridoOrigenDest1/1000);
            //numBicis+9-(bicisDescarregadesADest1)
            h += ((f.numBicis+9)/10)*(f.recorridoDest1Dest2/1000);            
        }
        return h;
    }

}
