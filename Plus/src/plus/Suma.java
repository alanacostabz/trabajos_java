/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plus;

/**
 *
 * @author bryan
 */
public class Suma {
    private int vUno, vDos, resultado;
    
    public Suma(int vUno, int vDos) {
        this.vUno = vUno;
        this.vDos = vDos;
    }
    
    public void Operacion() {
        resultado = vUno + vDos;
    }
    
    public void Imprimir() {
        Operacion();
        System.out.println("El resultado es: " + resultado );
    }
}
