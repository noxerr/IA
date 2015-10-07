package MainClasses;

import IA.Bicing.*;
import Subclases.EstadoFinalTest;
import Subclases.LocalSearchHeuristicFunction;
import Subclases.Successors;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.HillClimbingSearch;
import aima.search.informed.SimulatedAnnealingSearch;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dani
 */
public class Bicing {
    public static Estaciones e;
    public static int Furgos = 5;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Para generar los escenarios deberéis hacer 
        //que la proporción entre estaciones y bicicletas sea como mínimo 1 a 50.
        e = new Estaciones(25, 1250, Estaciones.EQUILIBRIUM, 1);
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
        Estado estatInicial = new Estado(new ArrayList(), over, under, bicisOver_Under);
        
        Problem problem = new Problem(estatInicial, new Successors(), new EstadoFinalTest(), new LocalSearchHeuristicFunction());
        Search searchHClimbing = new HillClimbingSearch();
        Search searchSAnnealing = new SimulatedAnnealingSearch();
        try {
            SearchAgent agent = new SearchAgent(problem, searchHClimbing);
        } catch (Exception ex) {
            Logger.getLogger(Bicing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

/*
Estacion:
//coordenadas
int x, y;
//número de bicicletas que no se moverán en la hora actual
int BicisNoMueven
//el número de bicicletas que habrá al ﬁnal de la hora
int bicisQueVendran
//demanda prevista de bicicletas para la próxima hora
int Demanda
 
Estats:

Struct camio{
     //IdD1 Desti1
     //IdD2 Desti2
     //IdS ESortida
     //NumBicis Numero de bicis que porta el camio
     int idd1, idd2, ids, NumBicis;
}


vector<camio>[numCamions] vecCamions;
vector<Estacion>[numEstacions] vecEstacions;


EstatInicial:

Ordenem vecEstacions de menor a major (-x,-y,…,a,b) 
Situem a cada estacio començant per vecEstacions[0]
//Situem a cada camió una estació de sortida on sobren bicis
for (int i=0; i<vecEstacions.size() and vecEstacions[i]<0 and i<vecCamions; i++){
	vecCamions[i].ESortida = vecEstacions[i].coordenades;
	vecCamions[i].NumBicis = abs(vecEstacions[i]);
}
//Escollim el primer desti de cada camio
for(int i = 0; i<vecCamions.size() and vecEstacions[vecEstacions.size()-i]>0;i++){
	vecCamions[i].Desti1 = vecEstacions[vecEstacions.size()-i];
	//el camio porta 30b i la estacio ni falten 8 Then aux=30+(-8)=22
	int aux = vecCamions[i].NumBicis+vecEstacions[vecEstacions.size()-i];
vecEstacions[vecEstacions.size()-i]=vecCamions[i].NumBicis-aux;
vecCamions[i].NumBicis=aux;	
}
ordena vecEstacions;
//Escollim el segon desti de cada camio
for(int i = 0; i<vecCamions.size() and vecEstacions[vecEstacions.size()-i]>0;i++){
	vecCamions[i].Desti2 = vecEstacions[vecEstacions.size()-i];
	//el camio porta 30b i la estacio ni falten 8 Then aux=30+(-8)=22
	int aux = vecCamions[i].NumBicis+vecEstacions[vecEstacions.size()-i];
vecEstacions[vecEstacions.size()-i]=vecCamions[i].NumBicis-aux;
vecCamions[i].NumBicis=aux;	

*/
