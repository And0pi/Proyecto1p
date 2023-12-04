/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.domino;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Domino {

    public static void main(String[] args) {
       
        Juego juego=new Juego();
        juego.agregarjugador("Jugador0");
        juego.agregarjugador("Jugador1");
        boolean sepuedejugar=true;
        while(!juego.getJugadores().get(1).getMano().isEmpty()&&sepuedejugar){
            int i=0;
            sepuedejugar=false;
            Jugador jugador=juego.getJugadores().get(1);
            System.out.println("Ingrese 0 para terminar la partida");
            System.out.println(jugador.getNombre()+":");
            System.out.println("Mano-> "+jugador.getMano());
            System.out.println("Linea de juego-> "+juego.getLineajuego());
            
            boolean valido=true;
                
                do{ 
                    System.out.println("Seleccione la posicion de la ficha que desea jugar");
                    Scanner op= new Scanner(System.in);
                    int eleccion=op.nextInt();
                    
                    
                    if(eleccion==0){
                        sepuedejugar=false;
                        System.out.println("Gracias por jugar");
                        break;
                    }
                    if(eleccion>0&&eleccion<=jugador.getMano().size()){
                    Ficha ficha=jugador.getMano().get(eleccion-1);
                    if(juego.agregarFichaLinea(ficha, jugador)){
                        System.out.println(ficha+" Movimiento valido");
                        valido=false;
                        sepuedejugar=true;
                        jugador.removerFicha(ficha);
                        System.out.println("Linea juego"+juego.getLineajuego());
                        Domino.jugadorCompu(juego,juego.getJugadores().get(0),juego.getJugadores().get(0).getMano());
                
                        break;
                    }
                    
                   
                    else
                        System.out.println(ficha+" Movimiento no valido");
                    }
                    i++;        
                    }while(valido);

                

            
        }
        System.out.println("No mas movimientos, gracias por jugar");
    }
        public static boolean jugadorCompu(Juego juego,Jugador jugador,ArrayList<Ficha> mano){
            boolean sepuedejugar=true;
            while(!juego.getJugadores().get(1).getMano().isEmpty()&&sepuedejugar){
            sepuedejugar=false;
            System.out.println(jugador.getNombre()+":");
            System.out.println("Mano-> "+jugador.getMano());
            System.out.println("Linea de juego-> "+juego.getLineajuego());
            boolean valido=true;
            for(Ficha ficha:mano){
                if(juego.agregarFichaLinea(ficha, jugador)){
                    System.out.println(ficha+" Movimiento valido");
                    sepuedejugar=true;
                    jugador.removerFicha(ficha);
                    System.out.println("Linea juego"+juego.getLineajuego());
                    return true;
                    
                    }
                    
                    else
                        System.out.println(ficha+" Movimiento no valido");
            
            }
            return false;
        }
        return false;
    }
}
    
    
