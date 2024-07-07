
package sopareview;

import java.io.BufferedReader;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.IOException;

import java.util.HashMap;
import java.util.Iterator;

import java.util.Scanner;

public class SopaReview {

    public static final int REVIEW = 0; //estas constantes son las columnas que tiene mi csv 

    public static final int BRAND = 1;

    public static final int VARIETY = 2;

    public static final int STYLE = 3;

    public static final int COUNTRY = 4;

    public static final int STARS = 5;

    public static void main(String[] args) {

        FileReader archivo;

        BufferedReader inputFile = null;

        try {

            // TODO code application logic here
            archivo = new FileReader("maruchan.csv");

            inputFile = new BufferedReader(archivo);

        } catch (FileNotFoundException ex) {

            System.out.println("Error al abrir el archivo");

            System.exit(0);

        } //hasta aquí es lo mismo que cuando lees un txt

        String registro = null;
        String marca = null;
        String stars = null;

        HashMap<String, Integer> tabla = new HashMap(); //creas un hashmap

        try {

            // Leer el archivo linea x linea
            registro = inputFile.readLine();

            while ((registro = inputFile.readLine()) != null) {

                // mostrar registro completo
                String[] campos = registro.split(",");

                marca = campos[BRAND]; 
                stars = campos[STARS];

                if (tabla.containsKey(stars)) { //busca si esta la palabra stars en el registro

                   Integer m = (Integer) tabla.get(marca); //jala el nombre, en mi caso es de un una marca
                   

                  tabla.replace(marca, new Integer(m.intValue() + 1));//agrega al hashmap el nombre de la marca y le asigna una llave (esto si la marca se repite varias veces)
                    

                } else {

//              
                    tabla.put(marca, new Integer(1));
                    

                }

            }

            inputFile.close();

            Iterator<String> iterator = tabla.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                System.out.println(key);
            }

        } catch (IOException ex) {

            System.out.println("Error al cerrar el archivo");

            System.exit(0);

        }

         Scanner teclado = new Scanner(System.in);

        System.out.println("Review a buscar:");

        marca = teclado.nextLine();

        Integer d = tabla.get(marca);

        System.out.println("Hay " + d + " productos de la marca " + marca);
         
    }

}
