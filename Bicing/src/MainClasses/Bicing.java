package MainClasses;

import IA.Bicing.*;
import Subclases.EstadoFinalTest;
import Subclases.EstadoInicial;
import Subclases.EstadoInicialOperadoresCambioHC;
import Subclases.EstadoInicialOperadoresCambioHCSinCoste;
import Subclases.EstadoInicialSA;
import Subclases.EstadoInicialSASinCoste;
import Subclases.LocalSearchHeuristicFunctionWithTransport;
import Subclases.HeuristicFunctionOld;
import Subclases.SuccessoresSA;
import Subclases.SuccessoresSASinCoste;
import Subclases.SucesoresSinCoste;
import Subclases.Successores;
import Subclases.SuccessoresOpNuevo;
import Subclases.SucesoresSinCosteOpNuevo;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dani
 */
public class Bicing {
    public static Estaciones e;
    public static ArrayList<Integer> difDemandaInicial; //diferencia positiva es que sobran bicis
    public static int furgos = 5, bicis = 1250, estac = 25, maxBici = 30;
    //public static int furgos = 15, bicis = 3750, estac = 75, maxBici = 30;
    //public static int furgos = 20, bicis = 5000, estac = 100, maxBici = 30;
    //public static int furgos = 25, bicis = 6250, estac = 125, maxBici = 30;
    //public static int furgos = 10, bicis = 2500, estac = 50, maxBici = 30;
    public static int EstacionUsada = 6001;

    public static void main(String[] args) {
        
        
        long t1,t2,t3;
        int semilla = 1234;
        int modo = 1;
        e = new Estaciones(estac, bicis, Estaciones.EQUILIBRIUM, semilla);
        
        
        /**
         * Parámetros para SA
         */
        int steps = 5000;
        int stiter = 100;
        int k = 15;
        double lamb = 0.001;

        Estado estatInicial;
        Estado estatInicialSA;
        Scanner in = new Scanner(System.in);
        int opt=-1;
        
        while (opt!=0){
            System.out.println("\n\n--------------------------------\nBienvenido a Bicing\n--------------------------------");
            System.out.println("Selecciona una opción:");
            System.out.println("1. Ejecutar HC sin costes");
            System.out.println("2. Ejecutar HC con costes");
            System.out.println("3. Ejecutar SA sin costes");
            System.out.println("4. Ejecutar SA con costes");
            System.out.println("5. Cambiar parámetros generales");
            System.out.println("6. Cambiar parámetros SA");
            System.out.println("7. Ver parámetros actuales");
            System.out.println("0. Salir");
            System.out.println("\nOpción: ");
            opt = in.nextInt();
            if(opt!=0){
            switch(opt){
                case 1:
                    /* HC sin costes */
                    t1 = System.nanoTime();
                    estatInicial = new EstadoInicial(e, bicis);
                    t2 = System.nanoTime();
                    BicingHillClimbingSearch(estatInicial, false, false);
                    t3 = System.nanoTime();
                    printTime(t1,t2,t3);
                    break;
                case 2:
                      /* HC con costes */
                    t1 = System.nanoTime();
                    estatInicial = new EstadoInicial(e, bicis);
                    t2 = System.nanoTime();
                    BicingHillClimbingSearch(estatInicial, true, false);
                    t3 = System.nanoTime();
                    printTime(t1,t2,t3);
                    break;
                case 3:
                    /* SA sin costes */
                    t1 = System.nanoTime();
                    estatInicialSA = new EstadoInicialSASinCoste(e, bicis);
                    t2 = System.nanoTime();
                    BicingSimulatedAnnealingSearch(estatInicialSA, false, steps, stiter, k, lamb);
                    t3 = System.nanoTime();
                    printTime(t1,t2,t3);
                    break;
                case 4:
                    /* SA con costes */
                    t1 = System.nanoTime();
                    estatInicialSA = new EstadoInicialSA(e, bicis);
                    t2 = System.nanoTime();
                    BicingSimulatedAnnealingSearch(estatInicialSA, true, steps, stiter, k, lamb);
                    t3 = System.nanoTime();
                    printTime(t1,t2,t3);
                    break;
                case 5:
                    System.out.println("Número de estaciones:");
                    estac = in.nextInt();
                    System.out.println("Número de bicis:");
                    bicis = in.nextInt();
                    System.out.println("Número de furgonetas:");
                    furgos = in.nextInt();
                    System.out.println("Introduce\n1: Demanda normal\n2: Hora punta");
                    modo = (in.nextInt()==1) ? Estaciones.EQUILIBRIUM : Estaciones.RUSH_HOUR;
                    System.out.println("Semilla:");
                    semilla = in.nextInt();
                    e = new Estaciones(estac, bicis, modo, semilla);
                    break;
                case 6:
                    System.out.println("Steps:");
                    steps = in.nextInt();
                    System.out.println("Max it:");
                    stiter = in.nextInt();
                    System.out.println("k:");
                    k = in.nextInt();
                    System.out.println("Lambda:");
                    lamb = in.nextDouble();
                    break;
                case 7:
                    System.out.println("------------ GENERAL -----------------------");
                    System.out.println("Estaciones: "+estac);
                    System.out.println("Bicis: "+bicis);
                    System.out.println("Furgonetas: "+furgos);
                    System.out.println("Demanda: " + ((modo==1) ? "Equilibrada" : "Hora punta"));
                    System.out.println("Semilla: "+semilla);
                    System.out.println("-------------- SA --------------------------");
                    System.out.println("Steps: "+steps);
                    System.out.println("Max it: "+stiter);
                    System.out.println("k: "+k);
                    System.out.println("Lambda: "+lamb);
                    System.out.println("--------------------------------------------");
                    break;
                    
            }
                difDemandaInicial = new ArrayList<Integer>();
                System.out.println("Pulsa cualquier tecla para continuar...");
                try
                {
                    System.in.read();
                }  
                catch(Exception e)
                {}  
            }
            
            
            
        }
        
        
        
        
       
        
     
////        /* HC sin costes nuevo OP*/
//        t1 = System.nanoTime();
//        estatInicial = new EstadoInicialOperadoresCambioHCSinCoste(e, bicis);
//        t2 = System.nanoTime();
//        BicingHillClimbingSearch(estatInicial, false, true);
//        t3 = System.nanoTime();
//        printTime(t1,t2,t3);
////        
////        
////        /* HC con costes nuevo Op */
//        t1 = System.nanoTime();
//        estatInicial = new EstadoInicialOperadoresCambioHC(e, bicis);
//        t2 = System.nanoTime();
//        BicingHillClimbingSearch(estatInicial, true, true);
//        t3 = System.nanoTime();
//        printTime(t1,t2,t3);

        
        
        
        
        
        
        
        
    }
    
    
    private static void printTime(long t1, long t2, long t3){
        //System.out.println("Tiempo en generar Estado: " + (t2 - t1)/1000000 + ". Tiempo en SA con Coste: " + (t3 - t2)/1000000);
        //System.out.println("Tiempo total: " + (t3 - t1)/1000000);
        System.out.println((t3 - t1)/1000000 + " ms");
    }
    
    private static void BicingHillClimbingSearch(Estado estatInicial, boolean coste, boolean nuevoOp){
        System.out.print("\n-------------------------------------------------------------");
        System.out.println("\nHill Climbing search " + ((coste) ? "con coste y " : "sin coste y ")
                + ((nuevoOp) ? "\nOperadores Change (como SA):" : "\nOperadores Set (como al principio):"));
        System.out.print("-------------------------------------------------------------");
        Problem problem;
        try {
            if(coste && !nuevoOp){
                problem = new Problem(estatInicial, new Successores(), new EstadoFinalTest(),
                    new LocalSearchHeuristicFunctionWithTransport());
            }else if (!nuevoOp){
                problem = new Problem(estatInicial, new SucesoresSinCoste(), new EstadoFinalTest(),
                    new LocalSearchHeuristicFunctionWithTransport());
            }
            else if(coste && nuevoOp){
                problem = new Problem(estatInicial, new SuccessoresOpNuevo(), new EstadoFinalTest(),
                    new LocalSearchHeuristicFunctionWithTransport());
            }else {
                problem = new Problem(estatInicial, new SucesoresSinCosteOpNuevo(), new EstadoFinalTest(),
                    new LocalSearchHeuristicFunctionWithTransport());
            }
            Search searchHClimbing = new HillClimbingSearch();
            SearchAgent agent = new SearchAgent(problem, searchHClimbing);
            System.out.println();
            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());
        } catch (Exception ex) {
            Logger.getLogger(Bicing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void BicingSimulatedAnnealingSearch(Estado estatInicial, boolean coste, int steps, int stiter , int k , double lamb){
        System.out.print("\n-------------------------------------------------------------");
        System.out.println("\nSimulated Annealing search " + ((coste) ? "con coste:" : "sin coste:"));
        System.out.println("Params:\n\tSteps:\t"+ steps + "\n\tStiter:\t" + stiter + "\n\tk:\t"+k + "\n\tLambda:\t"+lamb);
        System.out.print("-------------------------------------------------------------");
        Problem problem;
        try {
            if(coste){
                problem = new Problem(estatInicial, new SuccessoresSA(), new EstadoFinalTest(),
                    new LocalSearchHeuristicFunctionWithTransport());
            }else{
                problem = new Problem(estatInicial, new SuccessoresSASinCoste(), new EstadoFinalTest(),
                    new LocalSearchHeuristicFunctionWithTransport());
            }
            
            //int steps, slitter (t max), k, lambda
            Search searchSAnnealing = new SimulatedAnnealingSearch(steps, stiter, k, lamb);
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
        if (actions.size() > 0) System.out.print(actions.get(actions.size()-1));
        /*actions.stream().map((action1) -> (String) action1).forEach((action) -> {
                System.out.println(action);
        });*/
    }
    
}










