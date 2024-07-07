/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package area;

/**
 *
 * @author bryan
 */
public class Rectangulo {
    private int base, altura, area;
    
    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }
    
    
    public void calculoArea() {
        area = base * altura;
    }
    
    public void imprimir() {
        calculoArea();
        System.out.println("El area es: " + area);
    }
}
