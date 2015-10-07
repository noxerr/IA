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
    void cargarCamion(Camion c, Estacion e){
        c.set_Sortida(e.getCoordX(), e.getCoordY());
        c.NumBicis = e.getNumBicicletasNoUsadas();
        //falta actualizar estacion
    }
    
    void cargaCamionConLoJusto(Camion c, Estacion e){
        c.set_Sortida(e.getCoordX(), e.getCoordY());
        c.NumBicis += e.getNumBicicletasNoUsadas() > (-c.NumBicis) ? (-c.NumBicis) : e.getNumBicicletasNoUsadas();
    }
    
    void llenarEstacion(Camion c, int bicisQuePuedeDescargar, Estacion e){
        c.NumBicis -= bicisQuePuedeDescargar;
        e.setDemanda(e.getNumBicicletasNext()+bicisQuePuedeDescargar);
    }
    
    void setDestino1(Camion c, Estacion e){
        c.set_Desti1(e.getCoordX(), e.getCoordY());
    }
    
    void setDestino2(Camion c, Estacion e){
        c.set_Desti1(e.getCoordX(), e.getCoordY());
    }
    
}
