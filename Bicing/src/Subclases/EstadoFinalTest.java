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

    //Le pasan un estado y retorna cierto si es final
    @Override
    public boolean isGoalState(Object o) {
        return false; //nunca sabemos si el estado es final en realidad, es como el viajante de comercio
    }
    
}
