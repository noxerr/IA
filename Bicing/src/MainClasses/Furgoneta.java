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
     public int NumBicis;
     public int recorrido = 0;

    public Furgoneta(){
      origen = -1;
      dest1 = -1;
      dest2 = -1;
      NumBicis= 0;
    }    
   
}
