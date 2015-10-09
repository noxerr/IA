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
    public ArrayList<Furgoneta> vecCamiones;
    public ArrayList<Integer> estacOver, estacUnder, difDemandaBicis;
    public int bicisFaltanTotal, bicisSobranTotal, renta;
    //public int difBicis; //Bicis que Sobran en estaciones - bicis que faltan en estaciones
    
    public Estado(int numCamiones){
        this(new ArrayList(numCamiones), new ArrayList(), new ArrayList(), new ArrayList(), 0, 0, 0);
    }
    
    public Estado (ArrayList<Furgoneta> lc, ArrayList<Integer> over, ArrayList<Integer> under, 
            ArrayList<Integer> difDemanda, int bicisFaltan, int bicisSobran, int renta){
        this.vecCamiones = new ArrayList(lc);
        this.estacOver = new ArrayList(over);
        this.estacUnder = new ArrayList(under);
        this.difDemandaBicis = new ArrayList(difDemanda);
        this.bicisFaltanTotal = bicisFaltan;
        this.bicisSobranTotal = bicisSobran;
        this.renta = renta;
    }  
    
    @Override
    public String toString() {
        //aqui imprimir el estado bien
        String retVal = "\n|Renta total: " + -renta + "\nCamiones destino: ";
        for (Furgoneta f : vecCamiones) retVal += "bicis: " + f.NumBicis + ". Dest: " +  f.dest1 + " | ";
        retVal += "\nAhora difDemanda: ";
        for (int f : difDemandaBicis) retVal += f + " | ";
        return retVal;
    }
}
