/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.domino;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Usuario
 */
public class Utilitaria {
    
    
    public ArrayList<Ficha> crearManoJugador(){
        ArrayList<Ficha> mano_Sis= new ArrayList<>();
        Random lado1= new Random();
        Random lado2= new Random();
        for(int i=0;i<5;i++){
            Ficha fic= new Ficha(lado1.nextInt(1, 7),lado2.nextInt(1, 7));
            mano_Sis.add(fic);
        }
        FichaComodin fic_C= new FichaComodin();
        fic_C.setLado1(lado1.nextInt(1, 7));
        fic_C.setLado2(lado2.nextInt(1, 7));
        mano_Sis.add(fic_C);
        
        return mano_Sis;
    }
}
