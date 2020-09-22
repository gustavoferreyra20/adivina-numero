/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivina.controlador;

import adivina.modelo.Modelo;
import adivina.vista.IVista;
import adivina.vista.VistaSwing;

/**
 *
 * @author ferre
 */
public class Principal {
    
    public static void main(String[] args) {
        IVista vista = new VistaSwing("Adivinador");
        Modelo modelo = new Modelo();
        Controlador juego = new Controlador(vista, modelo);
        juego.iniciar();
    }
}
