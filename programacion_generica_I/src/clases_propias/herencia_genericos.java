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
public class herencia_genericos {
    
    public static void main(String[] args) {
        
       /* Empleado admin= new Empleado("Maritza",23,7000);
        Jefe DirComercial= new Jefe("Alan",23,20000);
        Empleado nuevoEmpleado=DirComercial;*/
       
      pareja<Empleado> Administrativa=new pareja<Empleado>();
       pareja<Jefe> dirComercial=new pareja<Jefe>();
      /* pareja<Empleado> nuevoEmpleado=dirComercial;*/
      pareja.imprimirTrabajador(Administrativa);
      pareja.imprimirTrabajador(dirComercial);
    }
    
}
