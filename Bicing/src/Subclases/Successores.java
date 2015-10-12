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

    @Override
    public List getSuccessors(Object o) {
        ArrayList retVal = new ArrayList();
        Estado oldEstado = (Estado) o;
        LocalSearchHeuristicFunction LSHF = new LocalSearchHeuristicFunction();
        boolean end = false;
        //Genera totes les possibles permutacions entre estacions de origen, desti1, desti2
        for(int n = 0; !end && n < oldEstado.vecCamiones.size(); n++){
            //Busquem el camió que encara no s'ha setejat
            if(oldEstado.vecCamiones.get(n).origen == -1){
                end = true;
                for(int origen = 0; origen<oldEstado.estacOver.size(); origen++){
                    if (oldEstado.difDemandaBicis.get(oldEstado.estacOver.get(origen)) != 60001){
                        for(int desti1 = 0; desti1 < oldEstado.estacUnder.size(); desti1++){
                                Estado nuevoEstado = new Estado(oldEstado.vecCamiones, oldEstado.estacOver, oldEstado.estacUnder, 
                                    oldEstado.difDemandaBicis, oldEstado.renta, oldEstado.sumaSobraFalta);
                                Operadores.setOrigen(nuevoEstado.vecCamiones.get(n), origen, 5);
                                Operadores.setDestino1(nuevoEstado.vecCamiones.get(n), desti1, nuevoEstado);
                                if(nuevoEstado.vecCamiones.get(n).numBicis > 0){
                                    for (int desti2 = 0; desti2 < oldEstado.estacUnder.size(); desti2++){}
                                    //Operadores.setDestino2(nuevoEstado.vecCamiones.get(n), desti2, nuevoEstado.difDemandaBicis);
                                }
                                double v = -LSHF.getHeuristicValue(nuevoEstado);
                                String S = "Operacion:" + " " + origen + " Renta(" + v + ") ---> " 
                                        + nuevoEstado.toString();
                                retVal.add(new Successor(S, nuevoEstado));    
                        }
                    }
                }      
            }

        }
        return retVal;
    }

    //Esta funcion genera la lista de los estados accesibles a partir del
    //que recibe como parametro.
    //Esta lista contiene pares de elementos que consisten en un string
    //que representa la operacion que se ha aplicado y el estado sucesor resultante.
   // @Override 
   // public List getSuccessors(Object o) {
        //throw new UnsupportedOperationException("Not supported yet.");
      /*  ArrayList retVal = new ArrayList();
        Estado oldEstado = (Estado) o;
        LocalSearchHeuristicFunction LSHF = new LocalSearchHeuristicFunction();
        // Recorremos camiones de Bicing uno por uno...
        for (int i = 0; i < oldEstado.vecCamiones.size(); i++){
         //double vMax = 0;
        //for(int j = 0; j < Bicing.e.size(); j++){
            if (oldEstado.vecCamiones.get(i).dest1 == -1){ //si la furgo no tenia desti1 encara
                //Por cada estación que tenga menos bicis que las demandadas...
                for(int j = 0; j < oldEstado.estacUnder.size(); j++){
                    Estado nuevoEstado = new Estado(oldEstado.vecCamiones, oldEstado.estacOver, oldEstado.estacUnder, 
                        oldEstado.difDemandaBicis, oldEstado.bicisFaltanTotal, oldEstado.bicisSobranTotal, oldEstado.renta);
                    // aux = id de la estación actual
                    int aux = nuevoEstado.estacUnder.get(j); //posicion de la estacion en el vector Estaciones
                    //System.out.println("Estación " + aux +" Camión " + i + " Carga " + nuevoEstado.vecCamiones.get(i).numBicis + "\n------------------------------\nInicial: " + -nuevoEstado.difDemandaBicis.get(aux) + " bicis");
                    // Para chequear que vecCamiones old y new son diferentes instancias 
                    //System.out.println(oldEstado.vecCamiones.get(i) == nuevoEstado.vecCamiones.get(i));
                    Operadores.setDestino1(nuevoEstado.vecCamiones.get(i), aux, 
                            nuevoEstado.difDemandaBicis);
                    
                    //System.out.println("Final:   " + -nuevoEstado.difDemandaBicis.get(aux) + " bicis");        
                            //System.out.println("----+" +j+ nuevoEstado.difDemandaBicis.get(aux) + "\n\n");
                    //System.out.println("Demanda actual: " + nuevoEstado.difDemandaBicis + "\n");
                    // Quitamos estación si la demanda ha sido cubierta 
                    if (nuevoEstado.difDemandaBicis.get(aux) == 0) nuevoEstado.estacUnder.remove(j);
                    nuevoEstado.renta += Bicing.difDemandaInicial.get(aux)-nuevoEstado.difDemandaBicis.get(aux);
                    //nuevoEstado.renta += oldEstado.difDemandaBicis.get(aux)-nuevoEstado.difDemandaBicis.get(aux);
                    double v = -LSHF.getHeuristicValue(nuevoEstado);
                    String S = "Operacion:" + " " + i + " " + j + " Renta(" + v + ") ---> " 
                            + nuevoEstado.toString();
                    //si heuristica es peor que el mejor, no anadir, como mucho un 2o mejor
                    /*if (v > vMax) {
                        retVal.add(new Successor(S, nuevoEstado));
                        vMax = v;
                    }*/
                    //retVal.add(new Successor(S, nuevoEstado));
                    //System.out.println(nuevoEstado.toString());
/*                }
            }
        }
        return retVal;*/
        //TODO ProbTSPSuccessorFunctionSA a;  ejemplo de generar hijos
        //ProbTSPSuccessorFunction b;
   // }
    
}
