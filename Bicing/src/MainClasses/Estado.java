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
    public List<Furgoneta> vecCamiones;
    public ArrayList<Estacion> estacOver, estacUnder;
    public int difBicis; //Bicis que Sobran en estaciones - bicis que faltan en estaciones
    
    public Estado(int numCamiones){
        this(new ArrayList(numCamiones), new ArrayList(), new ArrayList(), 0);
    }
    
    public Estado (List<Furgoneta> lc, ArrayList<Estacion> over, ArrayList<Estacion> under, 
            int difBicis){
        this.vecCamiones = lc;
        this.estacOver = new ArrayList(over);
        this.estacUnder = new ArrayList(under);
        this.difBicis = difBicis;
    }  
    
    @Override
    public String toString() {
        //aqui imprimir el estado bien
        String retVal = "| Diferencia entre bicis \npositivas y negativas: " + difBicis;
        return retVal;
    }
}
