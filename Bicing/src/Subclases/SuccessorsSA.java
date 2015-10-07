/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subclases;

import aima.search.framework.SuccessorFunction;
import java.util.List;

/**
 *
 * @author Dani
 */
public class SuccessorsSA implements SuccessorFunction{

    //Esta funcion genera la lista de los estados accesibles a partir del
    //que recibe como parametro.
    //Esta lista contiene pares de elementos que consisten en un string
    //que representa la operacion que se ha aplicado y el estado sucesor resultante.
    @Override 
    public List getSuccessors(Object o) {
        return null;
        //TODO ProbTSPSuccessorFunctionSA a;  ejemplo de generar hijos
        //ProbTSPSuccessorFunction b;
    }
    
}
