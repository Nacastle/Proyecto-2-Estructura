
package proyecto2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Proyecto2 {

    //public static ArrayList<ListitaTab> GenList = new ArrayList<>();
    
    public static Lista<ListitaTab> GenList = new Lista();
    
    public static void main(String[] args) throws IOException {
        muestraContenido("./Prueba1.txt");
        imprimir();
    }
    
    
    public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        Persona person;
        int indice, subindice;
        int MinTabs;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {            
            person = new Persona();
            person.Nombre = nombrePersona(cadena,contadorTab(cadena));
            MinTabs = contadorTab(cadena)-1;
            subindice = posLista(MinTabs);
            if (ExLista(contadorTab(cadena))) {
                indice = posLista(contadorTab(cadena));
                GenList.recuperar(indice).listaPersona.insertar(person, GenList.recuperar(indice).listaPersona.fin());
                //GenList.get(indice).listaPersona.add(person);
            }else{
                GenList.insertar(new ListitaTab(contadorTab(cadena)), GenList.fin());
                //GenList.add(new ListitaTab(contadorTab(cadena)));
                GenList.recuperar(GenList.fin()-1).listaPersona.insertar(person, GenList.recuperar(GenList.fin()-1).listaPersona.fin());
                //GenList.get(GenList.size()-1).listaPersona.add(person);
            }
            person.Jefe = GenList.recuperar(subindice).listaPersona.recuperar(GenList.recuperar(subindice).listaPersona.fin()-1);
            //person.Jefe = GenList.get(subindice).listaPersona.get(GenList.get(subindice).listaPersona.size()-1);
            person.Jefe.subordinado.insertar(person, person.Jefe.subordinado.fin());
            //person.Jefe.subordinado.add(person);
            //System.out.println(nombrePersona(cadena,contadorTab(cadena)));
            //obtenerCuenta(cadena);
        }
        b.close();
    }
    /*
    public static void imprimir(){
        for (int i = 0; i < GenList.size(); i++) {
            for (int j = 0; j < GenList.get(i).listaPersona.size(); j++) {
                if (i == 0) {
                    System.out.print("\t\t\t\t\t\t"+GenList.get(i).listaPersona.get(j).Nombre+"\t");
                }else if(i==1){
                    System.out.print("\t\t\t"+GenList.get(i).listaPersona.get(j).Nombre+"\t");
                }else if (i == 2){
                    System.out.print(""+GenList.get(i).listaPersona.get(j).Nombre+"\t");
                }else{
                    System.out.print("\t\t"+GenList.get(i).listaPersona.get(j).Nombre+"\t");
                }
                
            }
            System.out.println();
        }
    }
    */
    
    public static void imprimir(){
        for (int i = 1; i < GenList.fin(); i++) {
            for (int j = 1; j < GenList.recuperar(i).listaPersona.fin(); j++) {
                if (i == 0) {
                    System.out.print("\t\t\t\t\t\t"+GenList.recuperar(i).listaPersona.recuperar(j).Nombre+"\t");
                }else if(i==1){
                    System.out.print("\t\t\t"+GenList.recuperar(i).listaPersona.recuperar(j).Nombre+"\t");
                }else if (i == 2){
                    System.out.print(""+GenList.recuperar(i).listaPersona.recuperar(j).Nombre+"\t");
                }else{
                    System.out.print("\t\t"+GenList.recuperar(i).listaPersona.recuperar(j).Nombre+"\t");
                }
                
            }
            System.out.println();
        }
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
    
    public static boolean ExLista(int tab){
        boolean veri = false;
        for (int i = 1; i < GenList.fin(); i++) {
            if (tab == /*GenList.get(i).Tab*/ GenList.recuperar(i).Tab) {
                veri = true;
            }
        }
        return veri;
    }
    
    public static int posLista(int tab){
        int respuesta = 1;
        for (int i = 1; i < GenList.fin(); i++) {
            if (tab == /*GenList.get(i).Tab*/ GenList.recuperar(i).Tab) {
                respuesta = i;
            }
        }
        return respuesta;
    }
}
