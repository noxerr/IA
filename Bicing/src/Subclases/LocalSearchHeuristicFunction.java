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
public class LocalSearchHeuristicFunction implements HeuristicFunction {
/*
    el coste en euros por kilómetro recorrido es ((nb + 9) div 10), donde
div es la división entera. Tener en cuenta las bicis EN EL MOMENTO CONCRETO que lleva
    la furgo, ya que al dejar bicis en la 1a estacion ya no tiene tantas bicis.
    ademas -1€ x bici k aleje de la demanda
    +1€ x bici que haga que la estacion se acerque a la demanda
    */
    @Override
    public double getHeuristicValue(Object o) {
        //calcular coste mirando la diferencia d bicis actual con la vieja en cada estacion
        return -((Estado) o).renta;
        //return ((Estado) o).sumaSobraFalta;
    }

}
