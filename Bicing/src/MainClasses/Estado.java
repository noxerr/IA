/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MainClasses;
import IA.Bicing.*;
/**
 *
 * @author Ferran
 */
public class Estado {

    Camion[] vecCamiones;
    Estaciones vecEstacion;

    Estado(int nC, Estaciones e){
        this.vecCamiones = new Camion[nC];
        vecEstacion = e;
    }
    
    Estado (Camion[] vc, Estaciones e){
        this.vecCamiones = vc;
        this.vecEstacion = e;
    }
    
}
