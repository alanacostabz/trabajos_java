/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author bryan
 */
public class CuentaUsuarios {
    public static void main(String[] args) {
        Cliente cl1 = new Cliente("Alan Acosta","0001",200000);
        Cliente cl2 = new Cliente("Bryan Baez","0002",250000);
        Cliente cl3 = new Cliente("Hayley Williams","0003",300000);
        Cliente cl4 = new Cliente("Barbara Palvin","0004",100000);
        Cliente cl5 = new Cliente("Barbara Palvin","0004",100000);
        
        Set<Cliente> clientesBanco = new HashSet<Cliente>();
        clientesBanco.add(cl1);
        clientesBanco.add(cl2);
        clientesBanco.add(cl3);
        clientesBanco.add(cl4);
        clientesBanco.add(cl5);
        
     /*  for (Cliente cliente : clientesBanco) {
            
         //   System.out.println(cliente.getNombre() + " " + cliente.getNoCuenta() + " " + cliente.getSaldo());
         
           if (cliente.getNombre().equals("Bryan Baez")) {
               clientesBanco.remove(cliente);
           }
            
        }
       */
       for (Cliente cliente : clientesBanco) {
            
        System.out.println(cliente.getNombre() + " " + cliente.getNoCuenta() + " " + cliente.getSaldo());
         
            
        }
       
       Iterator <Cliente> it = clientesBanco.iterator();
        while (it.hasNext()) {
            String nombreCliente = it.next().getNombre();
            
            if (nombreCliente.equals("Bryan Baez")) {
                it.remove();
            }
        }
      
      /*Iterator<Cliente> it = clientesBanco.iterator();
        while (it.hasNext()) {
            String nom_Cliente = it.next().getNombre();
            System.out.println(nom_Cliente);
        }*/
    }
}
