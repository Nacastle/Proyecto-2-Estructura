/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.util.ArrayList;

/**
 *
 * @author Alexis
 */
public class Persona {
    public String Nombre;
    public Persona Jefe;
    public ArrayList<Persona> subordinado = new ArrayList<>();

    public Persona() {
    }

    public Persona(String Nombre, Persona Jefe) {
        this.Nombre = Nombre;
        this.Jefe = Jefe;
    }
    
}
