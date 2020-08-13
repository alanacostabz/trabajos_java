/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

/**
 *
 * @author bryan
 */
import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.*;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MarcoCliente mimarco = new MarcoCliente();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

class MarcoCliente extends JFrame {

    public MarcoCliente() {

        setBounds(600, 300, 280, 350);

        LaminaMarcoCliente milamina = new LaminaMarcoCliente();

        add(milamina);

        setVisible(true);

        addWindowListener(new EnvioOnline());
    }

}

//----------------------Envio de señal online------------------------
class EnvioOnline extends WindowAdapter {

    public void windowOpened(WindowEvent E) {
        try {
            Socket miSocket = new Socket("192.168.1.85", 9999);
            PaqueteEnvio data = new PaqueteEnvio();
            data.setMensaje(" online");
            ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
            paqueteDatos.writeObject(data);
            miSocket.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
//----------------------------------------------------------------------

class LaminaMarcoCliente extends JPanel implements Runnable {

    public LaminaMarcoCliente() {

        String nickUsuario = JOptionPane.showInputDialog("Nick: ");

        JLabel nNick = new JLabel("Nick: ");
        add(nNick);
        nick = new JLabel();

        nick.setText(nickUsuario);
        add(nick);

        JLabel texto = new JLabel("Online: ");

        add(texto);
        ip = new JComboBox();
        /*  ip.addItem("User 1");
        ip.addItem("User 2");
        ip.addItem("User 3");*/
       // ip.addItem("192.168.1.85");
        add(ip);

        campoChat = new JTextArea(12, 20);

        add(campoChat);

        campo1 = new JTextField(20);

        add(campo1);

        miboton = new JButton("Enviar");

        EnviaTexto miEvento = new EnviaTexto();

        miboton.addActionListener(miEvento);

        add(miboton);

        Thread miHilo = new Thread(this);
        miHilo.start();

    }

    @Override
    public void run() {
        try {
            ServerSocket servidorCliente = new ServerSocket(9090);
            Socket cliente;
            PaqueteEnvio paqueteRecibido;

            while (true) {
                cliente = servidorCliente.accept();
                ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
                paqueteRecibido = (PaqueteEnvio) flujoEntrada.readObject();
                if (!paqueteRecibido.getMensaje().endsWith(" online")) {
                    campoChat.append("\n" + paqueteRecibido.getNick() + ": " + paqueteRecibido.getMensaje());
                } else {

                   // campoChat.append("\n" + paqueteRecibido.getIps());
                   ArrayList <String> ipsMenu =  new ArrayList<String>();
                   ipsMenu = paqueteRecibido.getIps();
                   ip.removeAllItems();
                    for (String z : ipsMenu) {
                        ip.addItem(z);
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private class EnviaTexto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            campoChat.append("\n" + campo1.getText());
            try {
                // System.out.println(campo1.getText());

                Socket miSocket = new Socket("192.168.1.85", 9999);
                PaqueteEnvio datos = new PaqueteEnvio();
                datos.setNick(nick.getText());
                datos.setIp(ip.getSelectedItem().toString());
                datos.setMensaje(campo1.getText());

                ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream());
                paqueteDatos.writeObject(datos);
                miSocket.close();

                /*DataOutputStream flujoSalida = new DataOutputStream(miSocket.getOutputStream());
                flujoSalida.writeUTF(campo1.getText());
                flujoSalida.close();*/
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    private JTextField campo1;
    private JLabel nick;
    private JComboBox ip;
    private JButton miboton;

    private JTextArea campoChat;

}

class PaqueteEnvio implements Serializable {

    private String nick, ip, mensaje;
    private ArrayList<String> ips;

    public ArrayList<String> getIps() {
        return ips;
    }

    public void setIps(ArrayList<String> ips) {
        this.ips = ips;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
