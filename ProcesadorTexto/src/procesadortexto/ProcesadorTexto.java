/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesadortexto;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 *
 * @author bryan
 */
public class ProcesadorTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MenuProcesador mimarco = new MenuProcesador();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MenuProcesador extends JFrame {

    public MenuProcesador() {
        setBounds(500, 300, 550, 400);
        LaminaProcesador milamina = new LaminaProcesador();
        add(milamina);
        setVisible(true);
    }

}

class LaminaProcesador extends JPanel {

    public LaminaProcesador() {
        setLayout(new BorderLayout());

        JPanel laminamenu = new JPanel();
        JMenuBar mibarra = new JMenuBar();

        //------------------------------------------------------------------------
        fuente = new JMenu("Fuente");
        estilo = new JMenu("Estilo");
        tamaño = new JMenu("Tamaño");
        //------------------------------------------------------------------------
        ConfiguraMenu("Arial", "Fuente", "Arial", 9, 10);
        ConfiguraMenu("Calibri", "Fuente", "Calibri", 9, 10);
        ConfiguraMenu("Verdana", "Fuente", "Verdana", 9, 10);
        //------------------------------------------------------------------------
        ConfiguraMenu("Negrita", "Estilo", "", Font.BOLD, 1);
        ConfiguraMenu("Cursiva", "Estilo", "", Font.ITALIC, 1);
        //------------------------------------------------------------------------
        ConfiguraMenu("12", "Tamaño", "", 9, 12);
        ConfiguraMenu("16", "Tamaño", "", 9, 16);
        ConfiguraMenu("20", "Tamaño", "", 9, 18);
        ConfiguraMenu("24", "Tamaño", "", 9, 20);
        //------------------------------------------------------------------------

        mibarra.add(fuente);
        mibarra.add(estilo);
        mibarra.add(tamaño);

        laminamenu.add(mibarra);

        add(laminamenu, BorderLayout.NORTH);

        miarea = new JTextPane();
        add(miarea, BorderLayout.CENTER);

    }

    public void ConfiguraMenu(String rotulo, String menu, String tipoLetra, int estilos, int tam) {

        JMenuItem elemMenu = new JMenuItem(rotulo);
        if (menu == "Fuente") {
            fuente.add(elemMenu);
        } else if (menu == "Estilo") {
            estilo.add(elemMenu);
        } else if (menu == "Tamaño") {
            tamaño.add(elemMenu);

        }
        elemMenu.addActionListener(new GestionaEventos(rotulo,tipoLetra,estilos,tam));
    }

    private class GestionaEventos implements ActionListener {

        String tipoTexto, menu;
        int estiloLetra, tamañoLetra;
        
        GestionaEventos(String elemento, String texto2, int estilo2, int tamLetra2){
            tipoTexto =  texto2;
            estiloLetra =  estilo2;
            tamañoLetra = tamLetra2;
            menu = elemento;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            letras = miarea.getFont();
            
            if (menu == "Arial" || menu == "Calibri" || menu == "Verdana") {
                estiloLetra=letras.getStyle();
                tamañoLetra = letras.getSize();
                
            } else if (menu == "Cursiva" || menu == "Negrita") {
                
                if (letras.getSize() == 1 || letras.getStyle() == 2) {
                    estiloLetra = 3;
                }
                tipoTexto =  letras.getFontName();
                tamañoLetra = letras.getSize();
            } else if (menu == "12" || menu == "16" || menu == "20" || menu == "24"){
                estiloLetra = letras.getStyle();
                tipoTexto = letras.getFontName();
            }

            miarea.setFont(new Font(tipoTexto, estiloLetra, tamañoLetra));
            System.out.println("Tipo: " + tipoTexto + " Estilo: " + estiloLetra + " Tamaño: " + tamañoLetra);

        }

    }

    JTextPane miarea;
    JMenu fuente, estilo, tamaño;
    Font letras;
}
