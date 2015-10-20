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

/**
 *
 * @author Dani
 */
public class Successores implements SuccessorFunction{

    @Override
    public List getSuccessors(Object o) {
        ArrayList retVal = new ArrayList();
        Estado oldEstado = (Estado) o;
        LocalSearchHeuristicFunctionWithTransport LSHF = new LocalSearchHeuristicFunctionWithTransport();
        boolean end = false;
        //Genera totes les possibles permutacions entre estacions de origen, desti1, desti2
        for(int n = 0; !end && n < oldEstado.vecCamiones.size(); n++){
            double vMax = 0;
            //Busquem el camió que encara no s'ha setejat
            if(oldEstado.vecCamiones.get(n).origen == -1){
                end = true;
                for(int origen = 0; origen<oldEstado.estacOver.size(); origen++){
                    if (oldEstado.difDemandaBicis.get(oldEstado.estacOver.get(origen)) != Bicing.EstacionUsada){
                        for(int desti1 = 0; desti1 < oldEstado.estacUnder.size(); desti1++){
                                Estado nuevoEstado = new Estado(oldEstado.vecCamiones, oldEstado.estacOver, oldEstado.estacUnder, 
                                    oldEstado.difDemandaBicis, oldEstado.renta, oldEstado.sumaSobraFalta);
                                /*System.out.println("----------");
                                System.out.println("camion n: " + n+n+n + ". Origen: " + origen + ". Demanda: " + 
                                        oldEstado.difDemandaBicis.get(oldEstado.estacOver.get(origen)));
                                System.out.println("bicis1: " + nuevoEstado.vecCamiones.get(n));*/
                                Operadores.setOrigen(nuevoEstado.vecCamiones.get(n), oldEstado.estacOver.get(origen), 
                                        nuevoEstado.difDemandaBicis);
                                //System.out.println("bicis2: " + nuevoEstado.vecCamiones.get(n));
                                Operadores.setDestino1(nuevoEstado.vecCamiones.get(n), oldEstado.estacUnder.get(desti1), 
                                        nuevoEstado);
                                //System.out.println("bicis3: " + nuevoEstado.vecCamiones.get(n));
                                if(nuevoEstado.difDemandaBicis.get(oldEstado.estacUnder.get(desti1))
                                         == 0)nuevoEstado.estacUnder.remove(desti1);
                                if(nuevoEstado.vecCamiones.get(n).numBicis > 0){
                                    
                                    for (int desti2 = 0; desti2 < nuevoEstado.estacUnder.size(); desti2++){
                                        if (desti2 != desti1){ 
                                            Estado nuevoEstado2 = new Estado(nuevoEstado.vecCamiones, nuevoEstado.estacOver, 
                                                    nuevoEstado.estacUnder, nuevoEstado.difDemandaBicis, nuevoEstado.renta, nuevoEstado.sumaSobraFalta);
                                            Operadores.setDestino2(nuevoEstado2.vecCamiones.get(n), 
                                                    nuevoEstado.estacUnder.get(desti2), nuevoEstado2);
                                            //System.out.println("bicis4: " + nuevoEstado2.vecCamiones.get(n));
                                            double v = -LSHF.getHeuristicValue(nuevoEstado2);
                                            if (v > vMax){
                                                vMax = v;
                                            String S = "Operacion:" + " " + origen + " Renta(" + v + ") ---> " 
                                                    + nuevoEstado2.toString();
                                            //System.out.println("Camión: "+ n + " Origen: "+ nuevoEstado2.vecCamiones.get(n).origen + " Destino: " + nuevoEstado2.vecCamiones.get(n).dest1 + " Destino 2: " + nuevoEstado2.vecCamiones.get(n).dest2);
                                            retVal.add(new Successor(S, nuevoEstado2)); 
                                            }
                                        }
                                    }
                                }
                                else {
                                    double v = -LSHF.getHeuristicValue(nuevoEstado);
                                    if (v > vMax){
                                                vMax = v;
                                    String S = "Operacion:" + " " + origen + " Renta(" + v + ") ---> " 
                                            + nuevoEstado.toString();
                                    //System.out.println("Camión: "+ n + " Origen: "+ nuevoEstado.vecCamiones.get(n).origen + " Destino: " + nuevoEstado.vecCamiones.get(n).dest1 + " Destino 2: " + nuevoEstado.vecCamiones.get(n).dest2);
                                    retVal.add(new Successor(S, nuevoEstado));    
                                    }
                                }
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
