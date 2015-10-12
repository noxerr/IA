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
public class SuccessoresSA implements SuccessorFunction{

    //Esta funcion genera la lista de los estados accesibles a partir del
    //que recibe como parametro.
    //Esta lista contiene pares de elementos que consisten en un string
    //que representa la operacion que se ha aplicado y el estado sucesor resultante.
    @Override 
    public List getSuccessors(Object o) {
        ArrayList retVal = new ArrayList();
//        Estado oldEstado = (Estado) o;
//        LocalSearchHeuristicFunction LSHF = new LocalSearchHeuristicFunction();
//        
//        Random myRandom=new Random();
//        int i, renta = oldEstado.renta;
//        if (oldEstado.estacUnder.size() > 0) {
//            i = myRandom.nextInt(oldEstado.estacUnder.size()-1);
//            int j = myRandom.nextInt(oldEstado.vecCamiones.size()-1);
//            int k = oldEstado.vecCamiones.get(j).origen;
//            if(k == -1) {
//                if (oldEstado.estacOver.size() > 0) {
//                    k = myRandom.nextInt(oldEstado.estacOver.size()/2);
//                    k = oldEstado.estacOver.get(k);
//                }
//                else k = 0;
//            }
//            if (k == 0) renta = 100000;
//            else{
//                /*Operadores.llenarEstacion(oldEstado.vecCamiones.get(j),
//                        Bicing.momentaneo.get(oldEstado.estacOver.get(k)).getNumBicicletasNoUsadas(), 
//                                    oldEstado.estacUnder.get(i),k);*/
//                renta = -Bicing.e.get(oldEstado.estacOver.get(k)).getNumBicicletasNoUsadas() - 
//                                Bicing.e.get(oldEstado.estacOver.get(k)).getDemanda();
//            }
//                    
//        }
//        else renta = 100000;
//        /*int i,j;
//        
//        // Nos ahorramos generar todos los sucesores escogiendo un par de ciudades al azar
//        
//       i=myRandom.nextInt(board.getNCities());
//       
//       do{
//              j=myRandom.nextInt(board.getNCities());
//       } while (i==j);*/
//        
//        
//        Estado nuevoEstado = new Estado(oldEstado.vecCamiones, oldEstado.estacOver, oldEstado.estacUnder, 
//                oldEstado.difDemandaBicis, oldEstado.bicisFaltanTotal, oldEstado.bicisSobranTotal, oldEstado.renta+=renta);
//        //aplicamos ops en esta linea
//        double v = -LSHF.getHeuristicValue(nuevoEstado);
//        String S = "Operacion:" + " " + 1 + " " + 2 + " Renta(" + v + ") ---> " 
//                + nuevoEstado.toString();
//        retVal.add(new Successor(S, nuevoEstado));
        return retVal;
    }
    
}
