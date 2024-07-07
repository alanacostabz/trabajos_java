/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libredisposicion;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author bryan
 */
public class LibreDisposicion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MarcoLibre mimarco = new MarcoLibre();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MarcoLibre extends JFrame {

    public MarcoLibre() {
        setBounds(450, 350, 350, 400);
        LaminaLibre milamina = new LaminaLibre();
        add(milamina);
        setVisible(true);
    }

}

class LaminaLibre extends JPanel {

    public LaminaLibre() {

        //setLayout(null);
        setLayout(new enColumnas());

        JLabel nombre = new JLabel("Nombre: ");
        JLabel apellido = new JLabel("Apellido: ");
        JLabel edad = new JLabel("Edad: ");
        JLabel escuela = new JLabel("Escuela: ");

        JTextField cNombre = new JTextField();
        JTextField cApellido = new JTextField();
        JTextField cEdad = new JTextField();
        JTextField cEscuela = new JTextField();

        /* nombre.setBounds(20,20,80,10);
        cNombre.setBounds(100,20,100,20);
        
        apellido.setBounds(20,60,80,15);
        cApellido.setBounds(100,55,100,20);*/
        add(nombre);
        add(cNombre);
        
        add(apellido);
        add(cApellido);
        
        add(edad);
        add(cEdad);
        
        add(escuela);
        add(cEscuela);
    }
}

class enColumnas implements LayoutManager {

    @Override
    public void addLayoutComponent(String name, Component comp) {

    }

    @Override
    public void removeLayoutComponent(Component comp) {

    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void layoutContainer(Container miContenedor) {
        int contador = 0;
        
        int d = miContenedor.getWidth();
        x = d/2;
        int n = miContenedor.getComponentCount();

        for (int i = 0; i < n; i++) {
            
            contador++;
            
            Component c = miContenedor.getComponent(i);
            c.setBounds(x-100,y,100,20);
            
            x+=100;
            
            if (contador%2 == 0) {
                x= d/2;
                y+=40;
            }
                
            

        }
    }
    private int x;
    private int y = 20;

}
