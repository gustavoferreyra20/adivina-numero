
package adivina.controlador;

import adivina.modelo.Modelo;
import adivina.vista.IVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        this.vista.addHandlerReiniciar( new HandlerReiniciar() );
        this.vista.iniciar();
    }
    
    private void jugar() {
        try{
            this.modelo.jugar(this.vista.getNumeroIngresado());
            this.vista.setAyuda(this.modelo.getNotificacion());
        }catch(NumberFormatException e){
            this.vista.notificarUsuarioError("Ingrese un valor numérico");
        }catch(IOException e){
            this.vista.notificarUsuarioError(e.getMessage());
        }
     
    }
            
    private void reiniciar() {
        this.modelo.reiniciar();
        this.vista.reiniciar();
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
