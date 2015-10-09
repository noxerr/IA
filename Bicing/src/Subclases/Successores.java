/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subclases;

import MainClasses.Bicing;
import MainClasses.Estado;
import MainClasses.Operadores;
import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Dani
 */
public class Successores implements SuccessorFunction{

    //Esta funcion genera la lista de los estados accesibles a partir del
    //que recibe como parametro.
    //Esta lista contiene pares de elementos que consisten en un string
    //que representa la operacion que se ha aplicado y el estado sucesor resultante.
    @Override 
    public List getSuccessors(Object o) {
        //throw new UnsupportedOperationException("Not supported yet.");
        ArrayList retVal = new ArrayList();
        Estado oldEstado = (Estado) o;
        LocalSearchHeuristicFunction LSHF = new LocalSearchHeuristicFunction();
        for (int i = 0; i < oldEstado.vecCamiones.size(); i++){
         double vMax = 0;
        //for(int j = 0; j < Bicing.e.size(); j++){
            if (oldEstado.vecCamiones.get(i).dest1 == -1){ //si la furgo no tenia desti1 encara
                for(int j = 0; j < oldEstado.estacUnder.size(); j++){
                    Estado nuevoEstado = new Estado(oldEstado.vecCamiones, oldEstado.estacOver, oldEstado.estacUnder, 
                        oldEstado.difDemandaBicis, oldEstado.bicisFaltanTotal, oldEstado.bicisSobranTotal, oldEstado.renta);

                    int aux = nuevoEstado.estacUnder.get(j); //posicion de la estacion en el vector Estaciones
                    Operadores.setDestino1(nuevoEstado.vecCamiones.get(i), aux, 
                            nuevoEstado.difDemandaBicis);
                    //System.out.println("dspues de saliir: " + nuevoEstado.difDemandaBicis + "\n");
                    if (nuevoEstado.difDemandaBicis.get(aux) == 0) nuevoEstado.estacUnder.remove(j);
                    nuevoEstado.renta += Bicing.difDemandaInicial.get(aux)-nuevoEstado.difDemandaBicis.get(aux);
                    double v = -LSHF.getHeuristicValue(nuevoEstado);
                    String S = "Operacion:" + " " + i + " " + j + " Renta(" + v + ") ---> " 
                            + nuevoEstado.toString();
                    //si heuristica es peor que el mejor, no anadir, como mucho un 2o mejor
                    if (v > vMax) {
                        retVal.add(new Successor(S, nuevoEstado));
                        vMax = v;
                        System.out.println("d---irasdasd: " + LSHF.getHeuristicValue(nuevoEstado) + "\n" + (Bicing.difDemandaInicial.get(aux)-nuevoEstado.difDemandaBicis.get(aux)));
                    System.out.println("---iir: " + nuevoEstado.renta + "\n");
                    }
                    //System.out.println(nuevoEstado.toString());
                }
            }
        }
        return retVal;
        //TODO ProbTSPSuccessorFunctionSA a;  ejemplo de generar hijos
        //ProbTSPSuccessorFunction b;
    }
    
}
