/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.domino;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Jugador {
    private String nombre;
    private ArrayList<Ficha> mano;

    public Jugador(String nombre, ArrayList<Ficha> mano) {
        this.nombre = nombre;
        this.mano = mano;
    }

    public String getNombre() {
        return nombre;
    }
    
    public Ficha getFicha(int i){
        if (i>=mano.size()){
            return null;
        }
        else
            return mano.get(i);
    }
    
    public void removerFicha(Ficha f){
        int place=mano.indexOf(f);
        if (place!=-1){
            mano.remove(f);     
        }            
    }
    
    public void imprimirMano(){
        
        for(int i=0;i<mano.size();i++){
           if (i==mano.size()-1){
               System.out.println(mano.get(i));
           }
           else
                System.out.print(mano.get(i)+"-");
        }
    }

    public ArrayList<Ficha> getMano() {
        return mano;
    }
    
        
}
