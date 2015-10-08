package MainClasses;

import IA.Bicing.*;
import Subclases.EstadoFinalTest;
import Subclases.EstadoInicial;
import Subclases.LocalSearchHeuristicFunction;
import Subclases.Successores;
import Subclases.SuccessoresSA;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dani
 */
public class Bicing {
    public static Estaciones e;
    public static Estaciones momentaneo;
    public static int furgos = 5, bicis = 1250, estac = 25;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Para generar los escenarios deberéis hacer 
        //que la proporción entre estaciones y bicicletas sea como mínimo 1 a 50.
        e = new Estaciones(estac, bicis, Estaciones.EQUILIBRIUM, 1234);
        momentaneo = (Estaciones)e.clone();
        Estado estatInicial = new EstadoInicial(e, furgos, bicis);
        BicingHillClimbingSearch(estatInicial);
        BicingSimulatedAnnealingSearch(estatInicial);
    }
    
    private static void BicingHillClimbingSearch(Estado estatInicial){
        System.out.println("\nHill Climbing search:");
        System.out.print("------");
        try {
            Problem problem = new Problem(estatInicial, new Successores(), new EstadoFinalTest(),
                    new LocalSearchHeuristicFunction());
            Search searchHClimbing = new HillClimbingSearch();
            SearchAgent agent = new SearchAgent(problem, searchHClimbing);
            System.out.println();
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception ex) {
            Logger.getLogger(Bicing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void BicingSimulatedAnnealingSearch(Estado estatInicial){
        System.out.println("\n\nSimulated Annealing search:");
        System.out.print("------");
        try {
            Problem problem = new Problem(estatInicial, new SuccessoresSA(), new EstadoFinalTest(),
                    new LocalSearchHeuristicFunction());
            //int steps, slitter (t max), k, lambda
            Search searchSAnnealing = new SimulatedAnnealingSearch(2000, 100, 5, 0.001);
            //SimulatedAnnealingSearch search =  new SimulatedAnnealingSearch(2000,100,5,0.001);
            SearchAgent agent = new SearchAgent(problem, searchSAnnealing);
            System.out.println();
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception ex) {
            Logger.getLogger(Bicing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void printInstrumentation(Properties properties) {
        Iterator keys = properties.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String property = properties.getProperty(key);
            System.out.println(key + " : " + property);
        }
        
    }
    
    private static void printActions(List actions) {
        /*for (Object action1 : actions) {
            System.out.println(action1);
        }*/
        System.out.println(actions.get(actions.size()-1));
        /*actions.stream().map((action1) -> (String) action1).forEach((action) -> {
                System.out.println(action);
        });*/
    }
    
}










