/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MainClasses;
import IA.Bicing.*;
import java.util.List;

/**
 *
 * @author Ferran
 */
public class Estado {
    List<Camion> vecCamiones;
    Estaciones vecEstacion;
    int BicisTrasladadas;
    int BicisMalColocadas;
    
    Estado (List<Camion> lc, Estaciones e){
        this.vecCamiones = lc;
        this.vecEstacion = e;
        this.BicisMalColocadas = 0;
        this.BicisTrasladadas = 0;
    }
    
    //Operadores:
    //Pre: El Camion no esta Cargado
    //Post: El camion tiene una Estacion Salida i NumBicis
    void cargarCamion(Camion c, Estaciones e){
        //c.set_Sortida(e.getCoordX(), e.getCoordY());
        //c.set_NumBicis(e.getNumBicicletasNoUsadas());
    }
    
    void setDestino1(Camion c, Estaciones e){
        //c.set_Desti1(e.getCoordX(), e.getCoordY());
    }
    
    void setDestino2(Camion c, Estaciones e){
        //c.set_Desti1(e.getCoordX(), e.getCoordY());
    }
    
    void vaciarCamiones(){

    }
}
