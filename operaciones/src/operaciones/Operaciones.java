/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

/**
 *
 * @author bryan
 */
public class Operaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Suma operacion1 =  new Suma();
        Multiplica operacion2 = new Multiplica();
        Resta operacion3 = new Resta();
        Divide operacion4 = new Divide();
        
        System.out.println(operacion1.calculo(7,8));
        System.out.println(operacion2.calculo(7,8));
        System.out.println(operacion3.calculo(7,8));
        System.out.println(operacion4.calculo(7,8));
    }
    
}
