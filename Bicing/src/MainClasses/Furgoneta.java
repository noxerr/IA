/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MainClasses;

import IA.Bicing.Estacion;

/**
 *
 * @author Ferran
 */
public class Furgoneta {
     //IdD1 Desti1
     //IdD2 Desti2
     //IdS ESortida
     //NumBicis Numero de bicis que porta el camio
     public int origen, dest1, dest2;
     public int numBicis;
     public int recorridoOrigenDest1 = 0;
     public int recorridoDest1Dest2 = 0;
     public int costeAcumulado = 0;
     public int beneficioAportado = 0;
     public int bicisDest1, bicisDest2;
     // Bicis con las que sale hacia el destino 2

    public Furgoneta(){
      origen = -1;
      dest1 = -1;
      dest2 = -1;
      numBicis= 0;
      bicisDest1 = 0; 
      bicisDest2 = 0;
    }
    
    @Override
    public String toString() {
        return ("Número de bicis: " + numBicis + " ");
    }
    
    @Override
    public Furgoneta clone() {
        Furgoneta f = new Furgoneta();
        f.origen = this.origen;
        f.dest1 = this.dest1;
        f.dest2 = this.dest2;
        f.numBicis = this.numBicis;
        f.recorridoOrigenDest1 = this.recorridoOrigenDest1;
        f.recorridoDest1Dest2 = this.recorridoDest1Dest2;
        f.costeAcumulado = this.costeAcumulado;
        f.beneficioAportado = this.beneficioAportado;
        return f;
    }
   
}

