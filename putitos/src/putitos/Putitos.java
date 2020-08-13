/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package putitos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author bryan
 */
public class Putitos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader archivo;
        BufferedReader inputFile = null;
        HashMap<String, Integer> tabla = new HashMap();

        try {
            archivo = new FileReader("prueba.txt");
            inputFile = new BufferedReader(archivo);
        } catch (FileNotFoundException ex) {
            System.out.println("Error al abrir al archivo");
            System.exit(0);
        }
        String cadena = null;
        String pal = null;
        StringTokenizer t;

        try {
            while ((cadena = inputFile.readLine()) != null) {
                t = new StringTokenizer(cadena);
                String[] result = cadena.split(" ");
                while (t.hasMoreTokens()) {
                    pal = t.nextToken().toLowerCase();
                    pal = pal.replaceAll("[^a-zA-Z]", "");

                    if (tabla.containsKey(pal)) {
                        int contador = tabla.get(pal);

                        tabla.put(pal, contador += 1);
                    } else {
                        tabla.put(pal, 1);
                    }

                }

            }
            Set<String> keySet = tabla.keySet();
            ArrayList<String> listOfKeys = new ArrayList<>(keySet);
            Integer d = null;
            Collections.sort(listOfKeys);
            for (int i = 0; i < tabla.size(); i++) {

                for (int j = 0; j < tabla.size(); j++) {
                    d = tabla.get(listOfKeys.get(i));
                }

                System.out.println(listOfKeys.get(i) + "," + d);

            }

        } catch (IOException ex) {
            System.out.println("Error al cargar el archivo");
            System.exit(0);
        }

    }

}
