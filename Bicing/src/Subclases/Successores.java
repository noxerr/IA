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
        
        Estado nuevoEstado = new Estado(oldEstado.vecCamiones, oldEstado.estacOver, oldEstado.estacUnder, oldEstado.difBicis);
        double v = LSHF.getHeuristicValue(nuevoEstado);
        retVal.add(new Successor("", nuevoEstado));
        return retVal;
        //TODO ProbTSPSuccessorFunctionSA a;  ejemplo de generar hijos
        //ProbTSPSuccessorFunction b;
    }
    
}
