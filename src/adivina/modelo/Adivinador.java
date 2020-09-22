/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivina.modelo;

import java.util.ArrayList;

/**
 *
 * @author ferre
 */
public class Adivinador {
    
    private ArrayList<Integer> historial;
    private int numeroIngresado;
    private int numeroSecreto;
    private int MAX_INTENTOS;

    public Adivinador(int numeroIngresado, int numeroSecreto, int MAX_INTENTOS, ArrayList<Integer> historial) {
        this.numeroIngresado = numeroIngresado;
        this.numeroSecreto = numeroSecreto;
        this.MAX_INTENTOS = MAX_INTENTOS;
        this.historial = historial;
    }

    
    
    public Resultados adivinar(){
        if (this.numeroIngresado == numeroSecreto){
             //this.vista.notificarUsuario("Exacto! Usted adivinó en "+(this.historial.size()+1)+" intentos");
             //this.reiniciar();
            return Resultados.IGUAL;
        }else{
            this.historial.add( this.numeroIngresado );
            if ( this.numeroIngresado < this.numeroSecreto ){
                return Resultados.MENOR;
            }else{
                //this.vista.setAyuda("Muy alto");
                return Resultados.MAYOR;
            }          
            /*this.vista.setIntentos( MAX_INTENTOS - this.historial.size());
            this.vista.resetNumero();*/
        }
       
    }
    
}
