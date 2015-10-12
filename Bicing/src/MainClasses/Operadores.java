/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClasses;

import IA.Bicing.Estacion;
import java.util.ArrayList;


/**
 *
 * @author Dani
 */
public class Operadores {
    /*
    SetOrigen (camion c, ArrayList<int> difDemandaBicis)
ha de poner estacion a “usada”
ha de poner origen al camion (origen relativo al vector de difDemanda que es igual de largo y corresponde al de Estaciones
ha de actualizar las bicis que quedan en esa estacion que ha cogido, las bicis que tiene ahora el camion (todas las que le sobraban), actualizar la suma de (bicis sobran + bicis faltan) del heuristico, y actualizar la renta (la necesitaremos para saber lo k hemos ganado)
si la estacion ya tiene un camion k tenga esa d origen le ponemos un 1 en el vector de difDemandaBicis, si tiene un 1 es k no era negativa (xk sino no habriamos puesto un camion de origen ahi)

SetDestino1 (camion c)
Ha de definir el desti del camió
ha de actualizar las bicis que quedan en esa estacion que ha dejado,  las bicis que tiene ahora el camion (todas las que le sobraban), actualizar la suma de (bicis sobran + bicis faltan) del heuristico, y actualizar la renta (la necesitaremos para saber lo k hemos ganado)

    */
    
    // Actualiza demanda y resta bicis
    public static void setDestino1(Furgoneta c, int estacionDest, ArrayList<Integer> difDemanda){
        c.dest1 = estacionDest; 
        if (c.numBicis > -difDemanda.get(estacionDest)) {
            c.numBicis += difDemanda.get(estacionDest);
            difDemanda.set(estacionDest, 0);//ja no faltan bicis
        }
        else {
            difDemanda.set(estacionDest, difDemanda.get(estacionDest) + c.numBicis);//ja no faltan bicis
            c.numBicis = 0;
        }
    }
    
    public static void setDestino2(Furgoneta c, int j){
        c.dest2 = j; 
    }
    public static void setOrigen(Furgoneta c, int j){
        c.origen = j;
    }
    //añadir op switch origen o switch destinos o commutar destino1/2 
    
}
