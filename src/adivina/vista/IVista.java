/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivina.vista;

import java.awt.event.ActionListener;

/**
 *
 * @author ferre
 */
public interface IVista {
    
    void addHandlerJugar(ActionListener al);
    
    int getNumeroIngresado();
    
    void notificarUsuario(String mensaje);
    
    void notificarUsuarioError(String mensaje);
    
    void setAyuda(String ayuda);
    
    void setIntentos(int i);
    
    void resetNumero();
    
    void resetIntentos();
    
    void addHandlerReiniciar(ActionListener al);
    
    void iniciar();
}
