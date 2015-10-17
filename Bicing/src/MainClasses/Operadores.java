/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClasses;

import IA.Bicing.Estacion;
import java.util.ArrayList;
import javafx.beans.binding.NumberBinding;


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
    public static void setDestino1(Furgoneta c, int estacionDest, Estado es){
        c.dest1 = estacionDest; 
        Estacion e = Bicing.e.get(c.origen);
        int xOrigen = e.getCoordX();
        int yOrigen = e.getCoordY();
        e = Bicing.e.get(estacionDest);
        c.recorridoOrigenDest1 += es.calculaDistancia(xOrigen,
                                            yOrigen,
                                            e.getCoordX(),
                                            e.getCoordY());
        c.costeAcumulado = (((int)(c.numBicis+9)/10))*(c.recorridoOrigenDest1/1000);
        
        if (c.numBicis > -es.difDemandaBicis.get(estacionDest)) {
            c.numBicis += es.difDemandaBicis.get(estacionDest);
            es.renta -= es.difDemandaBicis.get(estacionDest);
            es.sumaSobraFalta += es.difDemandaBicis.get(estacionDest);
            es.difDemandaBicis.set(estacionDest, 0);//ja no faltan bicis
        }
        else {
            es.sumaSobraFalta -= c.numBicis;
            es.renta += c.numBicis;
            es.difDemandaBicis.set(estacionDest, es.difDemandaBicis.get(estacionDest) + c.numBicis);//ja no faltan bicis
            c.numBicis = 0;
        }
        es.renta -= c.costeAcumulado;
    }
    
    public static void setDestino2(Furgoneta c, int estacionDest, Estado es){
        c.dest2 = estacionDest; 
        Estacion e = Bicing.e.get(c.dest1);
        int xOrigen = e.getCoordX();
        int yOrigen = e.getCoordY();
        e = Bicing.e.get(estacionDest);
        c.recorridoDest1Dest2 += es.calculaDistancia(xOrigen,
                                            yOrigen,
                                            e.getCoordX(),
                                            e.getCoordY());
        //int auxi = c.numBicis > -es.difDemandaBicis.get(estacionDest) ? -es.difDemandaBicis.get(estacionDest) : c.numBicis;
        //System.out.println("Val auxi: " + auxi + ". Gasto: " + ((int)(c.numBicis+9)/10)*(c.recorridoDest1Dest2/1000));
        //if ( ((int)(c.numBicis+9)/10)*(c.recorridoDest1Dest2/1000) >  auxi){
        
            c.costeAcumulado += (((int)(c.numBicis+9)/10))*(c.recorridoDest1Dest2/1000); 

            if (c.numBicis > -es.difDemandaBicis.get(estacionDest)) {
                c.numBicis += es.difDemandaBicis.get(estacionDest);
                es.renta -= es.difDemandaBicis.get(estacionDest);
                es.sumaSobraFalta += es.difDemandaBicis.get(estacionDest);
                es.difDemandaBicis.set(estacionDest, 0);//ja no faltan bicis
            }
            else {
                es.sumaSobraFalta -= c.numBicis;
                es.renta += c.numBicis;
                es.difDemandaBicis.set(estacionDest, es.difDemandaBicis.get(estacionDest) + c.numBicis);//ja no faltan bicis
                c.numBicis = 0;
            }
            es.renta -= c.costeAcumulado;
        //}
    }
    public static void setOrigen(Furgoneta c, int origen, ArrayList<Integer> difDemanda){
        c.origen = origen;
        /*int aux = Bicing.e.get(origen).getNumBicicletasNoUsadas() < difDemanda.get(origen) 
                ? Bicing.e.get(origen).getNumBicicletasNoUsadas() : difDemanda.get(origen);
        c.numBicis += aux > 30 ? 30 : aux;*/
        c.numBicis = difDemanda.get(origen) > 30 ? 30 : difDemanda.get(origen);
        difDemanda.set(origen, Bicing.EstacionUsada);
    }
    //añadir op switch origen o switch destinos o commutar destino1/2 
    
}
