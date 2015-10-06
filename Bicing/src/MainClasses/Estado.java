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
    int bicisSobranTotal;
    int bicisFaltanTotal;
    
    Estado (List<Camion> lc, Estaciones e){
        vecCamiones = lc;
        vecEstacion = e;
    }
    
    Estado (List<Camion> lc, Estaciones e, int bicisSobranTotal, int bicisFaltanTotal){
        this.vecCamiones = lc;
        this.vecEstacion = e;
        this.bicisSobranTotal = bicisSobranTotal;
        this.bicisFaltanTotal = bicisFaltanTotal;
    }
    
    
}
