/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_propias;

/**
 *
 * @author bryan
 */
class Empleado{

public Empleado(String nombre, int edad, double salario) {
    this.nombre=nombre;
    this.edad=edad;
    this.salario=salario;
    
}

public String dameDatos(){
    return "El empleado se llama " + nombre + ", Tiene: " + edad +" años" + " y un salario de " + salario; 
            }

private String nombre;
private int edad;
private double salario;

}
