
package adivina.controlador;

import adivina.modelo.Modelo;
import adivina.vista.IVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

class Controlador {
    
    private IVista vista;
    private Modelo modelo;

    Controlador(IVista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void iniciar() {
        this.modelo.iniciar();
        this.vista.addHandlerJugar( new HandlerJugar() );
        this.vista.addHandlerEnter( new HandlerEnter() );
        this.vista.addHandlerReiniciar( new HandlerReiniciar() );
        this.vista.addHandlerAyuda( new HandlerAyuda() );
        this.vista.setIntentos(this.modelo.getIntentosRestantes());
        this.vista.iniciar();
    }
    
    private void jugar() {
        try{
            this.modelo.jugar(this.vista.getNumeroIngresado());
            this.vista.setAyuda(this.modelo.getNotificacion());
            this.vista.setIntentos(this.modelo.getIntentosRestantes());
            this.juegoTerminado(this.modelo.getJuegoTerminado());
        }catch(NumberFormatException e){
            this.vista.notificarUsuarioError("Ingrese un valor numérico");
        }catch(IOException e){
            this.vista.notificarUsuarioError(e.getMessage());
        }
     
    }
            
    private void reiniciar() {
        this.modelo.reiniciar();
        this.vista.reiniciar();
        this.vista.setIntentos(this.modelo.getIntentosRestantes());
    }

    private void juegoTerminado(boolean juegoTerminado) {
        if(juegoTerminado){
            this.vista.juegoTerminado();
        }else{
            this.vista.resetNumero();
        }
    }
    
    private class HandlerJugar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jugar();
        }
        
    }
    
    private class HandlerEnter implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                jugar();
            }
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
           
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
           
        }
    }
    
    private class HandlerReiniciar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            reiniciar();
        }
    }
    
    private class HandlerAyuda implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ayuda();
        }
    }
    
     private void ayuda() {
            this.vista.mostrarAyuda(this.modelo.getAyuda());
        }
    
}
