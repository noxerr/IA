package MainClasses;

import IA.Bicing.*;
import java.util.ArrayList;

/**
 *
 * @author Dani
 */
public class Bicing {
    public static Estaciones e;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        e = new Estaciones(10, 5, 0, 1);
        ArrayList<Estacion> over = new ArrayList();
        ArrayList<Estacion> under = new ArrayList();
        int bicisOver = 0, bicisUnder = 0;
        for (int i = 0; i < e.size(); i++){
        }
        Estado estatInicial = new Estado(new ArrayList(30), over, under, bicisOver, bicisUnder);
        
        //okok.... pepiiitonono
        //NO
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
