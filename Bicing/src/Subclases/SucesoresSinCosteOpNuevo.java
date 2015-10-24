/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subclases;

import MainClasses.Bicing;
import MainClasses.Estado;
import MainClasses.OperadoresSinCoste;
import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Dani
 */
public class SucesoresSinCosteOpNuevo implements SuccessorFunction{

    @Override
    public List getSuccessors(Object o) {
        ArrayList retVal = new ArrayList();
        Estado oldEstado = (Estado) o;
        LocalSearchHeuristicFunctionWithTransport LSHF = new LocalSearchHeuristicFunctionWithTransport();
        boolean end = false;
        //Genera totes les possibles permutacions entre estacions de origen, desti1, desti2
        for(int n = 0; n < oldEstado.vecCamiones.size(); n++){
            //Busquem el camió que encara no s'ha setejat
                for(int origen = 0; origen<oldEstado.estacOver.size(); origen++){
                    if (oldEstado.difDemandaBicis.get(oldEstado.estacOver.get(origen)) != Bicing.EstacionUsada){
                        for(int desti1 = 0; desti1 < oldEstado.estacUnder.size(); desti1++){
                                Estado nuevoEstado = new Estado(oldEstado.vecCamiones, oldEstado.estacOver, oldEstado.estacUnder, 
                                    oldEstado.difDemandaBicis, oldEstado.renta, oldEstado.sumaSobraFalta);

                                OperadoresSinCoste.changeOrigen(nuevoEstado.vecCamiones.get(n), oldEstado.estacOver.get(origen), 
                                        nuevoEstado.difDemandaBicis, nuevoEstado);
                                //System.out.println("bicis2: " + nuevoEstado.vecCamiones.get(n));
                                OperadoresSinCoste.changeDestino1(nuevoEstado.vecCamiones.get(n), oldEstado.estacUnder.get(desti1), 
                                        nuevoEstado);
                                //System.out.println("bicis3: " + nuevoEstado.vecCamiones.get(n));
                                if(nuevoEstado.vecCamiones.get(n).numBicis > 0){
                                    //nuevoEstado.estacUnder.remove(desti1);
                                    for (int desti2 = 0; desti2 < nuevoEstado.estacUnder.size(); desti2++){
                                        if (desti2 != desti1){ 
                                            Estado nuevoEstado2 = new Estado(nuevoEstado.vecCamiones, nuevoEstado.estacOver, 
                                                    nuevoEstado.estacUnder, nuevoEstado.difDemandaBicis, nuevoEstado.renta, nuevoEstado.sumaSobraFalta);
                                            OperadoresSinCoste.changeDestino2(nuevoEstado2.vecCamiones.get(n), 
                                                    oldEstado.estacUnder.get(desti2), nuevoEstado2);
                                            //System.out.println("bicis4: " + nuevoEstado2.vecCamiones.get(n));
                                            double v = -LSHF.getHeuristicValue(nuevoEstado2);
                                            String S = "Operacion:" + " " + origen + " Renta(" + v + ") ---> " 
                                                    + nuevoEstado2.toString();
                                            //System.out.println("Camión: "+ n + " Origen: "+ nuevoEstado2.vecCamiones.get(n).origen + " Destino: " + nuevoEstado2.vecCamiones.get(n).dest1 + " Destino 2: " + nuevoEstado2.vecCamiones.get(n).dest2);
                                            retVal.add(new Successor(S, nuevoEstado2)); 
                                        }
                                    }
                                }
                                else {
                                    double v = -LSHF.getHeuristicValue(nuevoEstado);
                                    String S = "Operacion:" + " " + origen + " Renta(" + v + ") ---> " 
                                            + nuevoEstado.toString();
                                    //System.out.println("Camión: "+ n + " Origen: "+ nuevoEstado.vecCamiones.get(n).origen + " Destino: " + nuevoEstado.vecCamiones.get(n).dest1 + " Destino 2: " + nuevoEstado.vecCamiones.get(n).dest2);
                                    retVal.add(new Successor(S, nuevoEstado));    
                                }
                        }
                    }
                }      

        }
        return retVal;
    }

    
}
