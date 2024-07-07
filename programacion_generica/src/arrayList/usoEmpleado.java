/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayList;

/**
 *
 * @author bryan
 */
public class usoEmpleado {
    
    public static void main(String[] args) {
        
        Empleado listaEmpleados[]= new Empleado[3];
        
        listaEmpleados[0] = new Empleado("Alan",45,2500);
        listaEmpleados[1] = new Empleado("Bryan",40,3500);
        listaEmpleados[2] = new Empleado("Messi",50,1500);

        
        for (Empleado e : listaEmpleados) {
            System.out.println(e.dameDatos());
        }
        
    }
    
}

class Empleado{
    
    public Empleado(String nombre, int edad, double salario){
        this.nombre=nombre;
        this.edad=edad;
        this.salario=salario;
        
    }
    
    public String dameDatos(){
        return "El empleado se llama " + nombre + "Tiene " + edad + " años y un salario de " + salario;
    }
    
    private String nombre;
    private int edad;
    private double salario;
    
}


