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
public class Juego {
    private ArrayList<Ficha> lineajuego;
    private ArrayList<Jugador> jugadores;

    public Juego() {
        this.lineajuego = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        
    }
        
    public void agregarjugador(String nombre){
        Utilitaria c= new Utilitaria();
        Jugador j1=new Jugador(nombre, c.crearManoJugador());
        jugadores.add(j1);
    }
    
    public int obtenerValorInicioLinea(){
        Ficha t=lineajuego.get(0);
        return t.getLado1();
    }
    
    public int obtenerValorFinLinea(){
        int tamano=lineajuego.size()-1;
        Ficha t=lineajuego.get(tamano);
        return t.getLado2(); 
    }
    
    public void mostrarLinea(){
        for(int i=0;i<lineajuego.size();i++){
           if (i==lineajuego.size()-1){
               System.out.println(lineajuego.get(i));
           }
           else
                System.out.print(lineajuego.get(i)+"-");
        }
    }
    private void actualizarValorFinLinea() {
    if (!lineajuego.isEmpty()) {
        Ficha ultimaFicha = lineajuego.get(lineajuego.size() - 1);
        int valorFinLinea = ultimaFicha.getLado2();
    }
}
    
    public boolean agregarFichaLinea(Ficha f, Jugador j){
        if(f instanceof Ficha){
            if(lineajuego.isEmpty()){
                lineajuego.add(f);
                System.out.println("Movimiento valido");
                return true;
            }
            else if(f.getLado1()==obtenerValorFinLinea()){
                    lineajuego.add(f);
                    j.removerFicha(f);
                    System.out.println("Movimiento valido");
                    return true;
                    
                }
            else if(f.getLado2()==obtenerValorInicioLinea()){
                lineajuego.add(0, f);
                j.removerFicha(f);
                System.out.println("Movimiento valido");
                return true;
            }
        }
        if(f instanceof FichaComodin){
            if(lineajuego.isEmpty()){
                lineajuego.add(f);
                System.out.println("Movimiento valido");
                j.removerFicha(f);
                return true;
            }
            else
            {
            System.out.println("Ingrese la posicion donde lo desea agregar: ");
            System.out.println("1. Inicio");
            System.out.println("2. Final");
            
            Scanner l=new Scanner(System.in);
            int opcion=l.nextInt();
            if (opcion==1){
                lineajuego.add(0, f);
                j.removerFicha(f);
                actualizarValorFinLinea();
                return true;
            }
            if (opcion==2){
                int x=lineajuego.size();
                lineajuego.add(x, f);
                j.removerFicha(f);
                actualizarValorFinLinea();
                return true;
            }
            else
                System.out.println("El numero introducido no corresponde a ninguna opcion");
        }
            
        }

        return false;
    }    

    public ArrayList<Ficha> getLineajuego() {
        return lineajuego;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    
}
