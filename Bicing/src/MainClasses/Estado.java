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
    public ArrayList<Integer> estacOver, estacUnder;
    public int bicisFaltanTotal, bicisSobranTotal, renta;
    //public int difBicis; //Bicis que Sobran en estaciones - bicis que faltan en estaciones
    
    public Estado(int numCamiones){
        this(new ArrayList(numCamiones), new ArrayList(), new ArrayList(), 0, 0, 0);
    }
    
    public Estado (List<Furgoneta> lc, ArrayList<Integer> over, ArrayList<Integer> under, 
            int bicisFaltan, int bicisSobran, int renta){
        this.vecCamiones = lc;
        this.estacOver = new ArrayList(over);
        this.estacUnder = new ArrayList(under);
        this.bicisFaltanTotal = bicisFaltan;
        this.bicisSobranTotal = bicisSobran;
        this.renta = renta;
        if (this.vecCamiones.size() < 1) {
            int i = 0;
            while(i < Bicing.furgos){
                this.vecCamiones.add(new Furgoneta());
                i++;
            }
        }
    }  
    
    @Override
    public String toString() {
        //aqui imprimir el estado bien
        String retVal = "| Diferencia entre bicis \npositivas: " + bicisSobranTotal + ". Y negativas: "
                + bicisFaltanTotal + "\nRenta total: " + -renta;
        return retVal;
    }
}
