
package proyecto2;

import java.util.ArrayList;

public class Persona {
    public String Nombre;
    public Persona Jefe;
    public Lista<Persona> subordinado = new Lista();
    //public ArrayList<Persona> subordinado = new ArrayList<>();

    public Persona() {
    }

    public Persona(String Nombre, Persona Jefe) {
        this.Nombre = Nombre;
        this.Jefe = Jefe;
    }
    
}
