/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Subclases;

import MainClasses.Estado;
import aima.search.framework.HeuristicFunction;
/**
 *
 * @author Ferran
 */
public class LocalSearchHeuristicFunctionWithTransport implements HeuristicFunction {

    @Override
    public double getHeuristicValue(Object o) {
        //calcular coste mirando la diferencia d bicis actual con la vieja en cada estacion
        return -((Estado)o).renta;
    }
}
