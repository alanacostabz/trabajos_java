/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas;

/**
 *
 * @author bryan
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;
import javax.swing.*;

public class Marco_Dialogos extends JFrame {

    public Marco_Dialogos() {
        setTitle("Prueba de diálogos");
        setBounds(500, 300, 600, 450);
        JPanel laminaCuadricula = new JPanel();
        laminaCuadricula.setLayout(new GridLayout(2, 3));

        String primero[] = {"Mensaje", "Confirmar", "Opción", "Entrada"};
        laminaTipo = new Lamina_Botones("Tipo", primero);
        laminaTipoMensajes = new Lamina_Botones("Tipo de Mensaje", new String[]{
            "ERROR_MESSAGE",
            "INFORMATION_MESSAGE",
            "WARNING_MESSAGE",
            "QUESTION_MESSAGE",
            "PLAIN_MESSAGE"

        });
        laminaMensaje = new Lamina_Botones("Mensaje", new String[]{
            "Cadena",
            "Ícono",
            "Componente",
            "Otros",
            "Object[]"

        });

        laminaConfirmar = new Lamina_Botones("Confirmar", new String[]{
            "DEFAULT_OPTION",
            "YES_NO_OPTION",
            "YES_NO_CANCEL_OPTION",
            "OK_CANCEL_OPTION"

        });

        laminaOpcion = new Lamina_Botones("Opción", new String[]{
            "String[]",
            "Icon[]",
            "Object[]"

        });

        laminaEntrada = new Lamina_Botones("Entrada", new String[]{
            "Campo de texto",
            "Combo"

        });

        setLayout(new BorderLayout());

        laminaCuadricula.add(laminaTipo);
        laminaCuadricula.add(laminaTipoMensajes);
        laminaCuadricula.add(laminaMensaje);
        laminaCuadricula.add(laminaConfirmar);
        laminaCuadricula.add(laminaOpcion);
        laminaCuadricula.add(laminaEntrada);

        //Construimos la lamina inferior
        JPanel lamina_mostrar = new JPanel();
        JButton botonMostrar = new JButton("Mostrar");
        botonMostrar.addActionListener(new AccionMostrar());
        lamina_mostrar.add(botonMostrar);
        add(lamina_mostrar, BorderLayout.SOUTH);

        add(laminaCuadricula, BorderLayout.CENTER);

    }

    //-----------------------------------Proporciona el Mensaje------------------------------------
    public Object dameMensaje() {
        String s = laminaMensaje.dameSeleccion();
        if (s.equals("Cadena")) {
            return cadenaMensaje;
        } else if (s.equals("Ícono")) {
            return iconoMensaje;
        } else if (s.equals("Componente")) {
            return componenteMensaje;
        } else if (s.equals("Otros")) {
            return objetoMensaje;
        } else if (s.equals("Object[]")) {
            return new Object[]{
                cadenaMensaje,
                iconoMensaje,
                componenteMensaje,
                objetoMensaje

            };
        } else {
            return null;
        }

    }
    //-------------------Devuelve el tipo de ícono y tambien numero de botones en confirmar-------------------------------------------------

    public int dameTipo(Lamina_Botones lamina) {

        String s = lamina.dameSeleccion();

        if (s.equals("ERROR_MESSAGE") || s.equals("YES_NO_OPTION")) {

            return 0;

        } else if (s.equals("INFORMATION_MESSAGE") || s.equals("YES_NO_CANCEL_OPTION")) {

            return 1;

        } else if (s.equals("WARNING_MESSAGE") || s.equals("OK_CANCEL_OPTION")) {
            return 2;
        } else if (s.equals("QUESTION_MESSAGE")) {
            return 3;
        } else if (s.equals("PLAIN_MESSAGE") || s.equals("DEFAULT_OPTION")) {
            return -1;
        } else {
            return 0;
        }
    }

    //--------------------------------------DA OPCIONES LAMINA OPCION------------------------------
    public Object[] dameOpciones(Lamina_Botones lamina) {

        String s = lamina.dameSeleccion();

        if (s.equals("String[]")) {
            return new String[]{"Amarillo", "Azul", "Rojo"};
        } else if (s.equals("Icon[]")) {
            return new Object[]{new ImageIcon("src/ps.gif"), new ImageIcon("src/ps.gif")};
        } else if (s.equals("Object[]")) {
            return new Object[]{
                cadenaMensaje,
                iconoMensaje,
                componenteMensaje,
                objetoMensaje

            };

        } else {
            return null;
        }

    }

    //---------------------------------------------------------------------------------------------
    private class AccionMostrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //   System.out.println(laminaConfirmar.dameSeleccion());

            if (laminaTipo.dameSeleccion().equals("Mensaje")) {
                JOptionPane.showMessageDialog(Marco_Dialogos.this, dameMensaje(), "Título", dameTipo(laminaTipoMensajes));
            } else if (laminaTipo.dameSeleccion().equals("Confirmar")) {
                JOptionPane.showConfirmDialog(Marco_Dialogos.this, dameMensaje(), "Título", dameTipo(laminaTipo), dameTipo(laminaTipoMensajes));
            } else if (laminaTipo.dameSeleccion().equals("Entrada")) {

                if (laminaEntrada.dameSeleccion().equals("Campo de texto")) {
                    JOptionPane.showInputDialog(Marco_Dialogos.this, dameMensaje(), "Título", dameTipo(laminaTipoMensajes));
                } else {
                    JOptionPane.showInputDialog(Marco_Dialogos.this, dameMensaje(), "Título", dameTipo(laminaTipoMensajes), null, new String[]{"PS4", "XBOX ONE", "Nintendo"}, "PS4F");
                }

            } else if (laminaTipo.dameSeleccion().equals("Opción")) {
                JOptionPane.showOptionDialog(Marco_Dialogos.this, dameMensaje(), "Título", 0, dameTipo(laminaTipoMensajes), null, dameOpciones(laminaOpcion), null);
            }
        }

    }

    private Lamina_Botones laminaTipo, laminaTipoMensajes, laminaMensaje, laminaConfirmar, laminaOpcion, laminaEntrada;
    private String cadenaMensaje = "Mensaje";
    private Icon iconoMensaje = new ImageIcon("src/ps.gif");
    private Object objetoMensaje = new Date();
    private Component componenteMensaje = new Lamina_Ejemplo();

}

class Lamina_Ejemplo extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
        g2.setPaint(Color.YELLOW);
        g2.fill(rectangulo);
    }

}
