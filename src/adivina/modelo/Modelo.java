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
    private int intentosRestantes;
    private static final int MIN_NUM = 1; 
    private static final int MAX_NUM = 100; 
    private static final int MAX_INTENTOS = 7;
    private String notificacion;
    private Adivinador adivinador;
    private Boolean juegoTerminado;
    private String ayuda;
    
    public void generarHistorial(){
        this.historial = new ArrayList<>();
    }

    public void iniciar() {
        this.juegoTerminado = false;
        this.generarNumero();
        this.historial = new ArrayList<>();
        this.intentosRestantes = MAX_INTENTOS;
        this.adivinador = new Adivinador(this.numeroSecreto);
        setAyudaBase();
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
            throw new IOException("Ingrese un número entre " + MIN_NUM + " y " + MAX_NUM + "inclusives"); 
        }
    }
    
    private void numRepetido() throws IOException{
         if (this.historial.contains( this.numeroIngresado )){
             throw new IOException("Ya ingresaste ese número"); 
         }
    }
    
    private void adivinaMayorMenor(){
               
        this.historial.add( this.numeroIngresado );
        this.notificacion = (adivinador.adivinar(this.numeroIngresado).getMensaje());
        this.intentosRestantes--;
        this.juegoTerminado = adivinador.getEsCorrecto();
        this.checkIntentos();
              
    }
    
    public void setAyudaBase(){
        this.ayuda = "Tienes 7 intentos para adivinar un numero entre 1 y 100, si divides donde podría estar el número por 2, no podrás perder nunca.";
    }
    
    public String getNotificacion(){
        return this.notificacion;
    }
    
    public String getAyuda(){
        return this.ayuda;
    }
    
    public boolean getJuegoTerminado(){
        return this.juegoTerminado;
    }
    
    public int getIntentosRestantes(){
        return this.intentosRestantes;
    }

    public void reiniciar() {
        this.iniciar();
    }

    private void checkIntentos() {
        if ( !this.juegoTerminado && this.intentosRestantes - 1 < 0){
            this.notificacion = "Te quedaste sin intentos, el numero era el " + this.numeroSecreto;
            this.juegoTerminado = true;
        }
    }
    
    
}
