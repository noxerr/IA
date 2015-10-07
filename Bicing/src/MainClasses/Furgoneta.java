/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MainClasses;
/**
 *
 * @author Ferran
 */
public class Furgoneta {
     //IdD1 Desti1
     //IdD2 Desti2
     //IdS ESortida
     //NumBicis Numero de bicis que porta el camio
     private int desti1x, desti1y;
     private int desti2x, desti2y;
     private int sortidaX, sortidaY;
     public int NumBicis;
     public int maxBicis = 30;

    public Furgoneta(){
      desti1x = 0;
      desti1y = 0;
      desti2x = 0;
      desti2y = 0;
      sortidaX= 0;
      sortidaY= 0;
      NumBicis= 0;
    }    
    
    public int get_Desti1x(){
        return desti1x;
    }
    
    public int get_Desti1y(){
        return desti1y;
    }
    
    public int get_Desti2x(){
        return desti2x;
    }
    
    public int get_Desti2y(){
        return desti2y;
    }
    
    public int get_SortidaX(){
        return sortidaX;
    }
    
    public int get_SortidaY(){
        return sortidaY;
    }
    
    public void set_Desti1(int x, int y){
        this.desti1x=x;
        this.desti1y=y;
    }
    
    public void set_Desti2(int x, int y){
        this.desti2x=x;
        this.desti2y=y;
    }
    
    public void set_Sortida(int x, int y){
        this.sortidaX=x;
        this.sortidaY=y;
    }
    
    

}

