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
public enum Resultado {
    MAYOR("Muy alto"),
    MENOR("Muy bajo"),
    IGUAL("Correcto");

    private String mensaje;

    private Resultado(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    

    
    
}
