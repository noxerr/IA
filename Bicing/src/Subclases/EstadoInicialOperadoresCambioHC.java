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
import MainClasses.Operadores;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Ferran
 */
public class EstadoInicialOperadoresCambioHC extends Estado{

    public EstadoInicialOperadoresCambioHC(Estaciones e, int numBicis) {
        super(Bicing.furgos);
        generaEstadoInicial(e);
    }

    private void generaEstadoInicial(Estaciones e){  
        int k = 0;
        for (int i = 0; i < Bicing.furgos; i++){
            this.vecCamiones.add(new Furgoneta());
        }
        
        for (Estacion e1 : Bicing.e) {
            difDemandaBicis.add(e1.getNumBicicletasNext()-e1.getDemanda()); 
        }
        Bicing.difDemandaInicial = new ArrayList((Collection) difDemandaBicis.clone());
        for (int i = 0; i < e.size(); i++) {
            int aux = e.get(i).getNumBicicletasNext()- e.get(i).getDemanda();
            if (aux > 0){
                estacOver.add(i);
                sumaSobraFalta += aux;
            }
            else if(aux < 0){
                estacUnder.add(i);
                sumaSobraFalta -= aux;
            }
        }
        
        //Iniciamos con origenes y destinos random
        int origen = 0, dest = 0;
        for(int n = 0; n < vecCamiones.size(); n++){
            if (origen < estacOver.size()){
                if (dest < estacUnder.size()){
                    Operadores.setOrigen(vecCamiones.get(n), estacOver.get(origen), 
                                    difDemandaBicis);
                    Operadores.changeDestino1(vecCamiones.get(n), estacUnder.get(dest), 
                            this);
                    dest++;
                }
                origen++;
            }
        }
         
        
        System.out.println("Estaciones que necesitan bicis: " + estacUnder.size() + " " + estacUnder);
        String retVal = "";
        for (int f : difDemandaBicis) retVal += f + " | ";
        System.out.println("DiffDemanda: " + retVal);
       // System.out.println("Estado inicial\n----------------\n " + super.toString());
    }
}
