/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subclases;

import MainClasses.Estado;
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
        for (int i = 0; i < 10; i++){
            Estado nuevoEstado = new Estado(oldEstado.vecCamiones, oldEstado.estacOver, oldEstado.estacUnder, 
                    oldEstado.bicisFaltanTotal, oldEstado.bicisSobranTotal, oldEstado.renta);
            nuevoEstado.renta = -(int) (Math.random() * 100);
            double v = -LSHF.getHeuristicValue(nuevoEstado);
            String S = "Operacion:" + " " + 1 + " " + 2 + " Renta(" + v + ") ---> " 
                    + nuevoEstado.toString();
            //si heuristica es peor que el mejor, no anadir, como mucho un 2o mejor
            retVal.add(new Successor(S, nuevoEstado));
        }
        return retVal;
        //TODO ProbTSPSuccessorFunctionSA a;  ejemplo de generar hijos
        //ProbTSPSuccessorFunction b;
    }
    
}
