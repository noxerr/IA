package MainClasses;

import IA.Bicing.*;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Dani
 */
public class Bicing {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estaciones e;
        //pruebacommit
        //commit2
        //int i;
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
     //x1y1 Desti1
     //x2y2 Desti2
     //sxsy ESortida
     //NumBicis Numero de bicis que porta el camio
     int x1, y1, x2, y2, sx,sy,NumBicis;
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
