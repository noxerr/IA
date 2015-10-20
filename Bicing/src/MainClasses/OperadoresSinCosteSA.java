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
 * @author david
 */
public class OperadoresSinCosteSA {
   
    public static void changeDestino1(Furgoneta c, int estacionDest, Estado es){
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
            c.beneficioAportado -= es.difDemandaBicis.get(estacionDest);
            c.bicisDest1 -= es.difDemandaBicis.get(estacionDest);
            es.sumaSobraFalta += es.difDemandaBicis.get(estacionDest);
            es.difDemandaBicis.set(estacionDest, 0);//ja no faltan bicis
        }
        else {
            es.sumaSobraFalta -= c.numBicis;
            es.renta += c.numBicis;
            c.beneficioAportado += c.numBicis;
            c.bicisDest1 += c.numBicis;
            es.difDemandaBicis.set(estacionDest, es.difDemandaBicis.get(estacionDest) + c.numBicis);//ja no faltan bicis
            c.numBicis = 0;
        }
    }
    
    public static void changeDestino2(Furgoneta c, int estacionDest, Estado es){
        c.dest2 = estacionDest; 
        Estacion e = Bicing.e.get(c.dest1);
        int xOrigen = e.getCoordX();
        int yOrigen = e.getCoordY();
        e = Bicing.e.get(estacionDest);
        c.recorridoDest1Dest2 += es.calculaDistancia(xOrigen,
                                            yOrigen,
                                            e.getCoordX(),
                                            e.getCoordY());
        c.costeAcumulado += (((int)(c.numBicis+9)/10))*(c.recorridoDest1Dest2/1000); 
        
        if (c.numBicis > -es.difDemandaBicis.get(estacionDest)) {
            c.numBicis += es.difDemandaBicis.get(estacionDest);
            es.renta -= es.difDemandaBicis.get(estacionDest);
            c.beneficioAportado -= es.difDemandaBicis.get(estacionDest);
            c.bicisDest2 -= es.difDemandaBicis.get(estacionDest);
            es.sumaSobraFalta += es.difDemandaBicis.get(estacionDest);
            es.difDemandaBicis.set(estacionDest, 0);//ja no faltan bicis
        }
        else {
            es.sumaSobraFalta -= c.numBicis;
            es.renta += c.numBicis;
            c.beneficioAportado += c.numBicis;
            c.bicisDest2 += c.numBicis;
            es.difDemandaBicis.set(estacionDest, es.difDemandaBicis.get(estacionDest) + c.numBicis);//ja no faltan bicis
            c.numBicis = 0;
        }
    }
    public static void changeOrigen(Furgoneta c, int origen, ArrayList<Integer> difDemanda, Estado es){
        difDemanda.set(c.origen, Bicing.difDemandaInicial.get(c.origen));
        difDemanda.set(c.dest1, difDemanda.get(c.dest1)-c.bicisDest1);
        if (c.dest2 != -1) difDemanda.set(c.dest2, difDemanda.get(c.dest2) - c.bicisDest2);
        c.origen = origen;
        c.numBicis = 0;
        int aux = Bicing.e.get(origen).getNumBicicletasNoUsadas() < difDemanda.get(origen) 
                ? Bicing.e.get(origen).getNumBicicletasNoUsadas() : difDemanda.get(origen);
        c.numBicis += aux > 30 ? 30 : aux;
        //c.numBicis += difDemanda.get(origen) > 30 ? 30 : difDemanda.get(origen);
        difDemanda.set(origen, Bicing.EstacionUsada);
        es.renta -= c.beneficioAportado;
        c.beneficioAportado = 0;
        c.recorridoDest1Dest2 = 0;
        c.recorridoOrigenDest1 = 0;
        c.costeAcumulado = 0;
        c.dest1 = -1;
        c.dest2 = -1;
        c.bicisDest1 = 0;
        c.bicisDest2 = 0;
        
    }
}
