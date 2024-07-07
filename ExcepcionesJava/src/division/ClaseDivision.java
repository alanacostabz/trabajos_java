package division;
import java.util.Scanner;
/**
 *
 * @author bryan
 */
public class ClaseDivision {
    public static void main(String[] args) {
        int valor1, valor2, resultado;
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Dame el primer valor: ");
            valor1 = sc.nextInt();

            System.out.print("Dame el segundo valor: ");
            valor2 = sc.nextInt();

            resultado = valor1/valor2;

            System.out.println("División es igual a " + resultado);
        } catch(Exception e) {
            System.out.println("Error" + e);
        } finally {
            System.out.println("Operación concluida");
        }
        
     
        
        
    }
}
