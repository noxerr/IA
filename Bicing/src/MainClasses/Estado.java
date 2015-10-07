/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MainClasses;
import IA.Bicing.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ferran
 */
public class Estado {
    List<Camion> vecCamiones;
    public ArrayList<Estacion> estacOver, estacUnder;
    public int bicisSobranTotal, bicisFaltanTotal;
    
    Estado (List<Camion> lc, ArrayList<Estacion> over, ArrayList<Estacion> under, 
            int bicisSobranTotal, int bicisFaltanTotal){
        this.vecCamiones = lc;
        this.estacOver = new ArrayList(over);
        this.estacUnder = new ArrayList(under);
        this.bicisSobranTotal = bicisSobranTotal;
        this.bicisFaltanTotal = bicisFaltanTotal;
    }
    
    /*public int getBicisSobran(){
        return this.bicisSobranTotal;
    }
    
    public int getBicisFaltan(){
        return this.bicisFaltanTotal;
    }
    
    public int setBicisSobran(int bicis){
        return this.bicisSobranTotal = bicis;
    }
    
    public int setBicisFaltan(int bicis){
        return this.bicisFaltanTotal = bicis;
    }*/
    
    
}
