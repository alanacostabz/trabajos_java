/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesadortextoll;

import com.sun.glass.events.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author bryan
 */
public class ProcesadorTextoll {

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

        /*  JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita");
        JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva");

        negrita.addActionListener(new StyledEditorKit.BoldAction());
        cursiva.addActionListener(new StyledEditorKit.ItalicAction());

        estilo.add(negrita);
        estilo.add(cursiva);*/
        //------------------------------------------------------------------------
        /*ConfiguraMenu("12", "Tamaño", "", 9, 12);
        ConfiguraMenu("16", "Tamaño", "", 9, 16);
        ConfiguraMenu("20", "Tamaño", "", 9, 18);
        ConfiguraMenu("24", "Tamaño", "", 9, 20);*/
        ButtonGroup tamañoLetra = new ButtonGroup();
        JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12");
        JRadioButtonMenuItem dieciceis = new JRadioButtonMenuItem("16");
        JRadioButtonMenuItem veinte = new JRadioButtonMenuItem("20");
        JRadioButtonMenuItem veinticuatro = new JRadioButtonMenuItem("24");

        veinticuatro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));

        tamañoLetra.add(doce);
        tamañoLetra.add(dieciceis);
        tamañoLetra.add(veinte);
        tamañoLetra.add(veinticuatro);

        doce.addActionListener(new StyledEditorKit.FontSizeAction("Cambia Tamaño", 12));
        dieciceis.addActionListener(new StyledEditorKit.FontSizeAction("Cambia Tamaño", 16));
        veinte.addActionListener(new StyledEditorKit.FontSizeAction("Cambia Tamaño", 20));
        veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("Cambia Tamaño", 24));

        tamaño.add(doce);
        tamaño.add(dieciceis);
        tamaño.add(veinte);
        tamaño.add(veinticuatro);

        //------------------------------------------------------------------------
        mibarra.add(fuente);
        mibarra.add(estilo);
        mibarra.add(tamaño);

        laminamenu.add(mibarra);

        add(laminamenu, BorderLayout.NORTH);

        miarea = new JTextPane();
        add(miarea, BorderLayout.CENTER);

        JPopupMenu emergente = new JPopupMenu();

        JMenuItem negritaE = new JMenuItem("Negrita");
        JMenuItem cursivaE = new JMenuItem("Cursiva");

        negritaE.addActionListener(new StyledEditorKit.BoldAction());
        cursivaE.addActionListener(new StyledEditorKit.ItalicAction());

        emergente.add(negritaE);
        emergente.add(cursivaE);

        //setComponentPopupMenu(emergente);
        miarea.setComponentPopupMenu(emergente);

        //-----------------------------------------------------------------------
        /*JToolBar barra = new JToolBar();
        JButton negritaBarra = new JButton(new ImageIcon(""));
        JButton cursivaBarra = new JButton(new ImageIcon(""));
        JButton subrrayarBarra = new JButton(new ImageIcon(""));
        JButton azulBarra = new JButton(new ImageIcon(""));
        JButton amarilloBarra = new JButton(new ImageIcon(""));
        JButton rojoBarra = new JButton(new ImageIcon(""));
        JButton centrado = new JButton(new ImageIcon(""));
        JButton justificado = new JButton(new ImageIcon(""));
        JButton aDerecha = new JButton(new ImageIcon(""));
        JButton aIzquierda = new JButton(new ImageIcon(""));
        negritaBarra.addActionListener(new StyledEditorKit.BoldAction());
        cursivaBarra.addActionListener(new StyledEditorKit.ItalicAction());
        subrrayarBarra.addActionListener(new StyledEditorKit.UnderlineAction());

        azulBarra.addActionListener(new StyledEditorKit.ForegroundAction("Pone azul", Color.BLUE));
        amarilloBarra.addActionListener(new StyledEditorKit.ForegroundAction("Pone azul", Color.YELLOW));
        rojoBarra.addActionListener(new StyledEditorKit.ForegroundAction("Pone azul", Color.RED));

        centrado.addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 0));
        justificado.addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
        aDerecha.addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 2));
        aIzquierda.addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 3));
        barra.add(negritaBarra);
        barra.add(cursivaBarra);
        barra.add(subrrayarBarra);
        barra.add(azulBarra);
        barra.add(amarilloBarra);
        barra.add(rojoBarra);
        barra.add(centrado);
        barra.add(justificado);
        barra.add(aDerecha);
        barra.add(aIzquierda);*/
        
        barra = new JToolBar();
        configuraBarra("").addActionListener(new StyledEditorKit.BoldAction());
        configuraBarra("").addActionListener(new StyledEditorKit.ItalicAction());
        configuraBarra("").addActionListener(new StyledEditorKit.UnderlineAction());
        barra.addSeparator();
        configuraBarra("").addActionListener(new StyledEditorKit.ForegroundAction("Pone azul", Color.BLUE));
        configuraBarra("").addActionListener(new StyledEditorKit.ForegroundAction("Pone rojo", Color.RED));
        configuraBarra("").addActionListener(new StyledEditorKit.ForegroundAction("Pone amarillo", Color.YELLOW));
        barra.addSeparator();
        configuraBarra("").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
        configuraBarra("").addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
        configuraBarra("").addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
        configuraBarra("").addActionListener(new StyledEditorKit.AlignmentAction("Justificado", 3));
        barra.setOrientation(1);
        add(barra, BorderLayout.WEST);

    }
    
    public JButton configuraBarra(String ruta){
        JButton boton = new JButton(new ImageIcon(ruta));
        barra.add(boton);
        return boton;
    }

    public void ConfiguraMenu(String rotulo, String menu, String tipoLetra, int estilos, int tam) {

        JMenuItem elemMenu = new JMenuItem(rotulo);
        if (menu == "Fuente") {
            fuente.add(elemMenu);

            if (tipoLetra == "Arial") {
                elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Arial"));
            } else if (tipoLetra == "Calibri") {
                elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Calibri"));
            } else if (tipoLetra == "Verdana") {
                elemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia letra", "Verdana"));
            }

        } else if (menu == "Estilo") {
            estilo.add(elemMenu);

            if (estilos == Font.BOLD) {

                elemMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));

                elemMenu.addActionListener(new StyledEditorKit.BoldAction());
            } else if (estilos == Font.ITALIC) {
                elemMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
                elemMenu.addActionListener(new StyledEditorKit.ItalicAction());
            }

        } else if (menu == "Tamaño") {
            tamaño.add(elemMenu);

            elemMenu.addActionListener(new StyledEditorKit.FontSizeAction("Cambia Tamaño", tam));

        }

    }

    JTextPane miarea;
    JMenu fuente, estilo, tamaño;
    Font letras;
    JButton negritaBarra,cursivaBarra,subrrayarBarra,azulBarra,amarilloBarra,rojoBarra, centrado, justificado, aDrecha, aIzquierda;
    JToolBar barra;
}
