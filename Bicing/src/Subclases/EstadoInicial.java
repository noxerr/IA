/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Subclases;

import IA.Bicing.Estacion;
import IA.Bicing.Estaciones;
import MainClasses.Estado;
import MainClasses.Furgoneta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ferran
 */
public class EstadoInicial{
    Estado e;
    public EstadoInicial(Estaciones e) {
        e = new Estado();
    }
    
    public Estado generaEstadoInicial(Estaciones e){  
        ArrayList<Estacion> over = new ArrayList();
        ArrayList<Estacion> under = new ArrayList();
        int bicisOver_Under = 0;
        int aux;
        for (Estacion e1 : e) {
            aux = e1.getNumBicicletasNext()-e1.getDemanda();
            if (aux > 0) over.add(e1);
            else under.add(e1);
            bicisOver_Under += aux;
        }
        Estado ei = new Estado(new ArrayList(), over, under, bicisOver_Under);
        return ei;
    }


}
