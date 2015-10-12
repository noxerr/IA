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
    public int renta, sumaSobraFalta, distancia;
    //public int difBicis; //Bicis que Sobran en estaciones - bicis que faltan en estaciones
    
    public Estado(int numCamiones){
        this(new ArrayList(numCamiones), new ArrayList(), new ArrayList(), new ArrayList(), 0, 0, 0);
    }
    
    public Estado (ArrayList<Furgoneta> lc, ArrayList<Integer> over, ArrayList<Integer> under, 
            ArrayList<Integer> difDemanda, int renta, int sumaSobraFalta, int distancia){

        this.vecCamiones = new ArrayList<Furgoneta>();
        for(Furgoneta f: lc){
            this.vecCamiones.add(f.clone());
        }

       
        this.estacOver = new ArrayList(over);
        this.estacUnder = new ArrayList(under);
        this.difDemandaBicis = new ArrayList(difDemanda);
        this.sumaSobraFalta = sumaSobraFalta;
        this.renta = renta;
        this.distancia = distancia;
    }
    
    public int calculaDistancia(int origenX, int origenY, int destX, int destY){
        return Math.abs(origenX - destX) + Math.abs(origenY - destY);
    }
    
    @Override
    public String toString() {
        //aqui imprimir el estado bien
        String retVal = "\nDistancia recorrida: " + distancia +"\nRenta total: " + renta + "\nCamiones destino: \n";
        for (Furgoneta f : vecCamiones) retVal += "bicis: " + 
                                        f.numBicis + " Origen: "+ 
                                        f.origen +". Dest: " +  
                                        f.dest1 + " . Dest2: "+ 
                                        f.dest2 + 
                                        "\n";
        retVal += "\nAhora difDemanda: ";
        for (int f : difDemandaBicis) retVal += f + " | ";
        return retVal;
    }
}
