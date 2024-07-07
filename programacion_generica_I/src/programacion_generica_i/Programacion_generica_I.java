/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_generica_i;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author bryan
 */
public class Programacion_generica_I {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* Empleado listaEmpleados[]= new Empleado[3];
        
        listaEmpleados[0] = new Empleado("Alan",45,2500);
        listaEmpleados[1] = new Empleado("Bryan",40,3500);
        listaEmpleados[2] = new Empleado("Messi",50,1500);*/
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();

        listaEmpleados.ensureCapacity(12);

        listaEmpleados.add(new Empleado("Alan", 45, 2500));
        listaEmpleados.add(new Empleado("Bryan", 40, 3500));
        listaEmpleados.add(new Empleado("Messi", 50, 1500));
        listaEmpleados.add(new Empleado("Alan", 45, 2500));
        listaEmpleados.add(new Empleado("Bryan", 40, 3500));
        listaEmpleados.add(new Empleado("Messi", 50, 1500));
        listaEmpleados.add(new Empleado("Alan", 45, 2500));
        listaEmpleados.add(new Empleado("Bryan", 40, 3500));
        listaEmpleados.add(new Empleado("Messi", 50, 1500));
        listaEmpleados.add(new Empleado("Alan", 45, 2500));
        listaEmpleados.add(new Empleado("Bryan", 40, 3500));
        listaEmpleados.add(new Empleado("Messi", 50, 1500));

        //listaEmpleados.trimToSize();
        // listaEmpleados.add(new Empleado("Ronaldo",45,2500));
        // listaEmpleados.set(1,new Empleado("Olga",50,1500));
        System.out.println(listaEmpleados.get(4).dameDatos());

        System.out.println(listaEmpleados.size());

        /*for (Empleado e : listaEmpleados) {
            System.out.println(e.dameDatos());
        }*/
        
        
        Iterator <Empleado> miIterador = listaEmpleados.iterator();
        while (miIterador.hasNext()) {
            System.out.println(miIterador.next().dameDatos());
        }
        
        
        
 /*for (int i = 0; i < listaEmpleados.size(); i++) {

            Empleado e = listaEmpleados.get(i);

            System.out.println(e.dameDatos());
        }*/
       /* Empleado arrayEmpleados[] = new Empleado[listaEmpleados.size()];

        listaEmpleados.toArray(arrayEmpleados);
        
        for (int i = 0; i < arrayEmpleados.length; i++) {
            System.out.println(arrayEmpleados[i].dameDatos());
        }*/
    }

}

class Empleado {

    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;

    }

    public String dameDatos() {
        return "El empleado se llama " + nombre + " Tiene " + edad + " años y un salario de " + salario;
    }

    private String nombre;
    private int edad;
    private double salario;

}
