
package adivina.controlador;

import adivina.vista.IVista;
import adivina.vista.VistaSwing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

class Controlador {
    
    private ArrayList<Integer> historial;               // de aca
    private int numeroSecreto;
    private int numeroIngresado;
    private static final int MIN_NUM = 1; 
    private static final int MAX_NUM = 100; 
    private static final int MAX_INTENTOS = 7;          // hasta aca, en el modelo
    
    private IVista vista;

    Controlador(IVista vista) {
        this.vista = vista;
    }
    
    public void iniciar() {
        this.generarNumero();
        this.historial = new ArrayList<>();
        this.vista.addHandlerJugar( new HandlerJugar() );
        this.vista.addHandlerReiniciar( new HandlerReiniciar() );
        this.vista.iniciar();
    }
    
    private void generarNumero() {
        Random rnd = new Random();
        this.numeroSecreto = rnd.nextInt((MAX_NUM - MIN_NUM + 1)) + MIN_NUM;
    }
    
    private void jugar() {
        try{
            this.numeroIngresado = this.vista.getNumeroIngresado();
            this.fueraDeLimites();
            this.numRepetido();
            this.adivinaMayorMenor();
        }catch(NumberFormatException e){
            this.vista.notificarUsuarioError("Ingrese un valor numérico");
        }catch(IOException e){
            this.vista.notificarUsuarioError(e.getMessage());
        }
     
    }
    
    private void numRepetido() throws IOException{
         if (this.historial.contains( this.numeroIngresado )){
             throw new IOException("Ya ingresaste ese número"); 
         }
    }
    
    private void adivinaMayorMenor(){
       if (this.numeroIngresado == numeroSecreto){
             this.vista.notificarUsuario("Exacto! Usted adivinó en "+(this.historial.size()+1)+" intentos");
             this.reiniciar();
        }else if ( MAX_INTENTOS - this.historial.size() -1 > 0 ){
            this.historial.add( this.numeroIngresado );
            if ( this.numeroIngresado < this.numeroSecreto ){
                this.vista.setAyuda("Muy bajo");
            }else{
                this.vista.setAyuda("Muy alto");
            }          
            this.vista.setIntentos( MAX_INTENTOS - this.historial.size());
            this.vista.resetNumero();
        }else{
            this.vista.notificarUsuario("Te quedaste sin intentos, el numero era el "+this.numeroSecreto);
            this.reiniciar();
        }
    }
    
    private void fueraDeLimites() throws IOException{
        if (this.numeroIngresado < MIN_NUM || this.numeroIngresado > MAX_NUM){
            throw new IOException("Ingrese un número entre "+MIN_NUM+" y "+MAX_NUM); 
        }
    }
    
    private void reiniciar() {
        this.vista.setAyuda(null);
        this.historial.clear();
        this.vista.resetNumero();
        this.vista.resetIntentos();
        this.generarNumero();
    }
    
    private class HandlerJugar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jugar();
        }
        
    }
    
    private class HandlerReiniciar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            reiniciar();
        }
    }
    
    
}
