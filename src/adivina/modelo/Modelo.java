/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivina.modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ferre
 */
public class Modelo {    
    
    private ArrayList<Integer> historial;             
    private int numeroSecreto;
    private int numeroIngresado;
    private static final int MIN_NUM = 1; 
    private static final int MAX_NUM = 100; 
    private static final int MAX_INTENTOS = 7;
    private String notificacion;
    
    public void generarHistorial(){
        this.historial = new ArrayList<>();
    }

    public void iniciar() {
         this.generarNumero();
         this.historial = new ArrayList<>();
    }
    
    private void generarNumero() {
        Random rnd = new Random();
        this.numeroSecreto = rnd.nextInt((MAX_NUM - MIN_NUM + 1)) + MIN_NUM;
    }

    public void jugar(int numeroIngresado) throws IOException {
        this.numeroIngresado = numeroIngresado;
            this.fueraDeLimites();
            this.numRepetido();
            this.adivinaMayorMenor();
    }
    
    private void fueraDeLimites() throws IOException{
        if (this.numeroIngresado < MIN_NUM || this.numeroIngresado > MAX_NUM){
            throw new IOException("Ingrese un número entre "+MIN_NUM+" y "+MAX_NUM); 
        }
    }
    
    private void numRepetido() throws IOException{
         if (this.historial.contains( this.numeroIngresado )){
             throw new IOException("Ya ingresaste ese número"); 
         }
    }
    
    private void adivinaMayorMenor(){
       
        Adivinador adivinador = new Adivinador(this.numeroIngresado, this.numeroSecreto, this.MAX_INTENTOS, this.historial);
        
        if ( MAX_INTENTOS - this.historial.size() -1 > 0 ){
        this.notificacion = (adivinador.adivinar().getMensaje());
        switch(adivinador.adivinar()){
            case MAYOR :
        }
        }else{
            this.notificacion = "Te quedaste sin intentos, el numero era el "+this.numeroSecreto;
            this.reiniciar();
        }
      
    }
    
    public String getNotificacion(){
        return this.notificacion;
    }

    public void reiniciar() {
        this.historial.clear();
        this.generarNumero();
    }
    
    
}
