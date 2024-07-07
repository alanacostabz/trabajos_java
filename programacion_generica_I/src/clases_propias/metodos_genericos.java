/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_propias;

import java.util.GregorianCalendar;

/**
 *
 * @author bryan
 */
public class metodos_genericos {
    
    public static void main(String[] args) {
        
        String nombres[] = {"Alan","Maritza","Acosta"};
        System.out.println(MisMatrices.getMenor(nombres));
      /*  Empleado cr7=new Empleado("cr7",8,3);
        Empleado messi=new Empleado("messi",8,3);
        Empleado mbappe=new Empleado("mbappe",8,3);
        
        Empleado misEmpleados[]={cr7,messi,mbappe};
        
        System.out.println(MisMatrices.getMenor(misEmpleados));*/
      GregorianCalendar fechas[]= {new GregorianCalendar(2018,07,12), new GregorianCalendar(2018,07,12),
      new GregorianCalendar(2018,07,12)};
        System.out.println(MisMatrices.getMenor(fechas));
        
        /*String elementos=MisMatrices.getElementos(nombres);
        System.out.println(elementos);
        Empleado listaEmpleados[] = {new Empleado("Alan",45,400),
            new Empleado("Alan",45,400),
            new Empleado("Alan",45,400),
            new Empleado("Alan",45,400),
            new Empleado("Alan",45,400)
        };
        System.out.println(MisMatrices.getElementos(listaEmpleados));*/
    }
    
}

class MisMatrices{
    public static <T extends Comparable> T getMenor(T[]a){
        if (a==null||a.length==0) {
            return null;
        }
        T elementoMenor=a[0];
        
        for (int i = 1; i <a.length ; i++) {
            
            if (elementoMenor.compareTo(a[i])>0) {
                elementoMenor=a[i];
            }
            
        }
        return elementoMenor;
    }
}


