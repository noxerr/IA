/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subclases;

import aima.search.framework.GoalTest;

/**
 *
 * @author Dani
 */
public class EstadoFinalTest implements GoalTest{

    @Override
    public boolean isGoalState(Object o) {
        return false; //siempre retornara falso xk no podemos saber si hemos llegado al final
    }
    
}
