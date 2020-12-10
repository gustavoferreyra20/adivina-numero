/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivina.modelo;

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

    
    
    public Resultado adivinar(int numeroIngresado){
        if (numeroIngresado == numeroSecreto){
            this.esCorrecto = true;
            return Resultado.IGUAL;
        }else{
            if ( numeroIngresado < this.numeroSecreto ){
                return Resultado.MENOR;
            }else{
                return Resultado.MAYOR;
            }          
        }
       
    }
    
    public boolean getEsCorrecto(){
        return esCorrecto;
    }
    
}
