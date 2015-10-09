/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Subclases;

import IA.Bicing.Estacion;
import IA.Bicing.Estaciones;
import MainClasses.Bicing;
import MainClasses.Estado;
import MainClasses.Furgoneta;
import java.util.ArrayList;

/**
 *
 * @author Ferran
 */
public class EstadoInicial extends Estado{

    public EstadoInicial(Estaciones e, int numBicis) {
        super(Bicing.furgos);
        generaEstadoInicial(e);
    }

    private void generaEstadoInicial(Estaciones e){  
        int k = 0;
        for (int i = 0; i < Bicing.furgos; i++){
            this.vecCamiones.add(new Furgoneta());
        }
        /*
        Bicing.e.stream().forEach((_item) -> {
            difDemandaBicis.add(0);
        });
        */
        int aux2;
        for (Estacion e1 : Bicing.e) {
            aux2 = e1.getNumBicicletasNext()-e1.getDemanda();
            aux2 = aux2 > 0 ? 0 : aux2; //aux sera negatiu o 0 ja que així podem contar els diners que guanyem
            difDemandaBicis.add(aux2);
        }
        Bicing.difDemandaInicial = new ArrayList(difDemandaBicis);
        for (int i = 0; i < e.size(); i++) {
            int aux = e.get(i).getNumBicicletasNext()- e.get(i).getDemanda();
            if (aux > 0){
                if(k < Bicing.furgos){
                    vecCamiones.get(k).origen = i;
                    vecCamiones.get(k).NumBicis = aux<Bicing.maxBici?aux:Bicing.maxBici;
                    System.out.println("i: " + i + ". get: " + vecCamiones.get(k).origen + ". bicis: " + vecCamiones.get(k).NumBicis);
                    k++;
                }
                estacOver.add(i);
                bicisSobranTotal += aux;
            }
            else {
                estacUnder.add(i);
                bicisFaltanTotal += aux;
            }
        }
        System.out.println("..: " + super.toString());
    }
}
