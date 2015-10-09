/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainClasses;

import IA.Bicing.Estacion;


/**
 *
 * @author Dani
 */
public class Operadores {
    //Operadores:
    //Pre: El Camion no esta Cargado
    //Post: El camion tiene una Estacion Salida i NumBicis
    public static void cargarCamion(Furgoneta c, Estacion e){
        //c.set_Sortida(e.getCoordX(), e.getCoordY());
        c.NumBicis = e.getNumBicicletasNoUsadas();
        //falta actualizar estacion
    }
    //tener cuidado xk si no cargams todas las bicis k sobran en una estacion, nadie mas las puede cargar
    public static void restaurarCamion(Furgoneta c, Estacion e, int bicisQueQuiereDejar){
        //c.set_Sortida(e.getCoordX(), e.getCoordY());
        c.NumBicis += e.getNumBicicletasNoUsadas() > (-c.NumBicis) ? (-c.NumBicis) : e.getNumBicicletasNoUsadas();
    }
    
    public static void llenarEstacion(Furgoneta c, int bicisQuePuedeDescargar, int destino, int origen){
        //c.NumBicis -= bicisQuePuedeDescargar;
        //nueva.setDemanda(nueva.getNumBicicletasNext()+bicisQuePuedeDescargar);
        //vieja.setNumBicicletasNoUsadas(vieja.getNumBicicletasNoUsadas()-bicisQuePuedeDescargar);
    }
    
    public static void setDestino1(Furgoneta c, int j){
        c.dest1 = j; 
    }
    
    public static void setDestino2(Furgoneta c, int j){
        c.dest2 = j; 
    }
    
    //añadir op switch origen o switch destinos o commutar destino1/2 
    
}
