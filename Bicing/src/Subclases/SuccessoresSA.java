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
        
        Random myRandom=new Random();
        /*int i,j;
        
        // Nos ahorramos generar todos los sucesores escogiendo un par de ciudades al azar
        
       i=myRandom.nextInt(board.getNCities());
       
       do{
              j=myRandom.nextInt(board.getNCities());
       } while (i==j);*/
        
        
        Estado nuevoEstado = new Estado(oldEstado.vecCamiones, oldEstado.estacOver, oldEstado.estacUnder, oldEstado.difBicis);
        //aplicamos ops en esta linea
        double v = LSHF.getHeuristicValue(nuevoEstado);
        String S = "Operacion:" + " " + 1 + " " + 2 + " Coste(" + v + ") ---> " + nuevoEstado.toString();
        retVal.add(new Successor(S, nuevoEstado));
        return retVal;
    }
    
}
