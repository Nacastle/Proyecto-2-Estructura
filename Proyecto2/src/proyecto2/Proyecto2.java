/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Alexis
 */
public class Proyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        muestraContenido("./Prueba.txt");
    }
    
    
    public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            //System.out.println(cadena);
            //contadorTab(cadena);
            System.out.println(nombrePersona(cadena,contadorTab(cadena)));
            //obtenerCuenta(cadena);
        }
        b.close();
    }
    
    public static int contadorTab(String x){
        int pos1=-1;
        int numeroTab=0;
        int bandera=0;
        while(bandera==0){
            pos1=x.indexOf('\t',pos1+1);
            if(pos1!=-1){
                numeroTab++;
            }else{
                bandera=1;
            }
        }
        //System.out.println("No de saltos: "+numeroTab);
        return numeroTab;
        
        //System.out.println("Lugar encontrar. "+ pos1);
    }
    
    public static String nombrePersona(String x, int a){
        return x.substring(a);
    }
}
