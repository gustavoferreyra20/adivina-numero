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
    
    private int numeroSecreto;
    private Boolean esCorrecto = false;

    public Adivinador(int numeroSecreto) {
        this.numeroSecreto = numeroSecreto;
    }

    
    
    public Resultados adivinar(int numeroIngresado){
        if (numeroIngresado == numeroSecreto){
            this.esCorrecto = true;
            return Resultados.IGUAL;
        }else{
            if ( numeroIngresado < this.numeroSecreto ){
                return Resultados.MENOR;
            }else{
                return Resultados.MAYOR;
            }          
        }
       
    }
    
    public boolean esCorrecto(){
        return esCorrecto;
    }
    
}
