/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subclases;


import MainClasses.Bicing;
import MainClasses.Estado;
import MainClasses.OperadoresSA;
import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Dani
 */
public class SuccessoresSA implements SuccessorFunction{

    //Esta funcion genera la lista de los estados accesibles a partir del
    //que recibe como parametro.
    //Esta lista contiene pares de elementos que consisten en un string
    //que representa la operacion que se ha aplicado y el estado sucesor resultante.
    @Override 
    public List getSuccessors(Object o) {
        ArrayList retVal = new ArrayList();
        Estado oldEstado = (Estado) o;
        LocalSearchHeuristicFunction LSHF = new LocalSearchHeuristicFunction();
        Estado nuevoEstado = new Estado(oldEstado.vecCamiones, oldEstado.estacOver, oldEstado.estacUnder, 
                                    oldEstado.difDemandaBicis, oldEstado.renta, oldEstado.sumaSobraFalta);
//        
        Random myRandom=new Random();
        int i;
        if (oldEstado.estacUnder.size() > 0) {
            i = myRandom.nextInt(oldEstado.estacUnder.size());
            int j = myRandom.nextInt(oldEstado.vecCamiones.size());
            if (oldEstado.estacOver.size() > 0) {
                int k = myRandom.nextInt(oldEstado.estacOver.size());
                if (nuevoEstado.difDemandaBicis.get(nuevoEstado.estacOver.get(k)) == Bicing.EstacionUsada) 
                    nuevoEstado.renta = -100000;
                else {
                    OperadoresSA.changeOrigen(nuevoEstado.vecCamiones.get(j), nuevoEstado.estacOver.get(k), 
                        nuevoEstado.difDemandaBicis, nuevoEstado);
                    OperadoresSA.changeDestino1(nuevoEstado.vecCamiones.get(j), nuevoEstado.estacUnder.get(i), 
                            nuevoEstado);
                    if (nuevoEstado.vecCamiones.get(j).numBicis > 0){
                        k = myRandom.nextInt(oldEstado.estacUnder.size());
                        OperadoresSA.changeDestino2(nuevoEstado.vecCamiones.get(j), oldEstado.estacUnder.get(k), 
                                nuevoEstado);
                    }
                }
            }
            else nuevoEstado.renta = -100000;
        }
        else nuevoEstado.renta = -100000;

//        //aplicamos ops en esta linea
        double v = -LSHF.getHeuristicValue(nuevoEstado);
        String S = "Operacion:" + " " + 1 + " " + 2 + " Renta(" + v + ") ---> " 
                + nuevoEstado.toString();
        retVal.add(new Successor(S, nuevoEstado));
        return retVal;
    }
    
}
