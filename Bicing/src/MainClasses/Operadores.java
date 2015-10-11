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
    //Operadores:
    //Pre: El Camion no esta Cargado
    //Post: El camion tiene una Estacion Salida i numBicis
    public static void cargarCamion(Furgoneta c, Estacion e){
        //c.set_Sortida(e.getCoordX(), e.getCoordY());
        c.numBicis = e.getNumBicicletasNoUsadas();
        //falta actualizar estacion
    }
    //tener cuidado xk si no cargams todas las bicis k sobran en una estacion, nadie mas las puede cargar
    public static void restaurarCamion(Furgoneta c, Estacion e, int bicisQueQuiereDejar){
        //c.set_Sortida(e.getCoordX(), e.getCoordY());
        c.numBicis += e.getNumBicicletasNoUsadas() > (-c.numBicis) ? (-c.numBicis) : e.getNumBicicletasNoUsadas();
    }
    
    public static void llenarEstacion(Furgoneta c, int bicisQuePuedeDescargar, int destino, int origen){
        //c.numBicis -= bicisQuePuedeDescargar;
        //nueva.setDemanda(nueva.getNumBicicletasNext()+bicisQuePuedeDescargar);
        //vieja.setNumBicicletasNoUsadas(vieja.getNumBicicletasNoUsadas()-bicisQuePuedeDescargar);
    }
    
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
    
    //añadir op switch origen o switch destinos o commutar destino1/2 
    
}
