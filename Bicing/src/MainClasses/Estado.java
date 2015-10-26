/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MainClasses;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Ferran
 */
public class Estado {
    public ArrayList<Furgoneta> vecCamiones;
    public ArrayList<Integer> estacOver, estacUnder, difDemandaBicis;
    public int renta, sumaSobraFalta;
    //public int difBicis; //Bicis que Sobran en estaciones - bicis que faltan en estaciones
    
    public Estado(int numCamiones){
        this(new ArrayList(numCamiones), new ArrayList(), new ArrayList(), new ArrayList(), 0, 0);
    }
    
    public Estado (ArrayList<Furgoneta> lc, ArrayList<Integer> over, ArrayList<Integer> under, 
            ArrayList<Integer> difDemanda, int renta, int sumaSobraFalta){

        this.vecCamiones = new ArrayList<Furgoneta>();
        for(Furgoneta f: lc){
            this.vecCamiones.add(f.clone());
        }

       
        this.estacOver = new ArrayList((Collection) over.clone());
        this.estacUnder = new ArrayList((Collection) under.clone());
        this.difDemandaBicis = new ArrayList((Collection) difDemanda.clone());
        //for (int i : difDemanda) this.difDemandaBicis.add(i);
        this.sumaSobraFalta = sumaSobraFalta;
        this.renta = renta;
    }
    
    public int calculaDistancia(int origenX, int origenY, int destX, int destY){
        return Math.abs(origenX - destX) + Math.abs(origenY - destY);
    }
    
    @Override
    public String toString() {
        //aqui imprimir el estado bien
        int recorrido = 0;
        String retVal = "\nRenta total: " + renta + "\nCamiones destino: \n";
        for (Furgoneta f : vecCamiones){ 
            
            retVal += "bicis: " + 
                    f.numBicis + " Origen: "+ 
                    f.origen +". Dest: " +  
                    f.dest1 + " . Dest2: "+ 
                    f.dest2 + " \tRec. D1: " +
                    f.recorridoOrigenDest1+" \tRec. D2: "+
                    f.recorridoDest1Dest2+" \tBicis finales: "+
                    f.numBicis;
            /* Chivato distancia recorrida
            
            if(f.origen!=-1){
                    retVal +=Bicing.e.get(f.origen).getCoordX() + ","+Bicing.e.get(f.origen).getCoordY()+ " - " + Bicing.e.get(f.dest1).getCoordX() + ","+Bicing.e.get(f.dest1).getCoordY();
            }
            if(f.dest2!=-1){
                retVal+="\t| "+Bicing.e.get(f.dest2).getCoordX() + ","+Bicing.e.get(f.dest2).getCoordY();
            }*/
            retVal +="\n";
            recorrido += f.recorridoOrigenDest1+f.recorridoDest1Dest2;
            
        }
        
        retVal += "\nAhora difDemanda: ";
        for (int f : difDemandaBicis) retVal += f + " | ";
        retVal += "\nRenta Recorrido Tiempo: \nRenta: " + renta + "\tRecorrido: " + recorrido + "\t";
        return retVal;

    }
}
