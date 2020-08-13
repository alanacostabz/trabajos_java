/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import javax.swing.*;

import java.awt.*;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MarcoServidor mimarco = new MarcoServidor();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

class MarcoServidor extends JFrame implements Runnable {

    public MarcoServidor() {

        setBounds(1200, 300, 280, 350);

        JPanel milamina = new JPanel();

        milamina.setLayout(new BorderLayout());

        areatexto = new JTextArea();

        milamina.add(areatexto, BorderLayout.CENTER);

        add(milamina);

        setVisible(true);

        Thread miHilo = new Thread(this);
        miHilo.start();

    }

    @Override
    public void run() {
        try {
            ServerSocket servidor = new ServerSocket(9999);
            String nick, ip, mensaje;
            ArrayList <String> listIP = new ArrayList<String>(); 
            PaqueteEnvio paqueteRecibido;
            while (true) {

                Socket miSocket = servidor.accept();

                ObjectInputStream paqueteDatos = new ObjectInputStream(miSocket.getInputStream());
                paqueteRecibido = (PaqueteEnvio) paqueteDatos.readObject();

                nick = paqueteRecibido.getNick();
                ip = paqueteRecibido.getIp();
                mensaje = paqueteRecibido.getMensaje();

                // DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream());
                //   String mensajeTexto = flujoEntrada.readUTF();
                //  areatexto.append("\n" + mensajeTexto);
                if (mensaje.equals(" online")) {

                    areatexto.append("\n" + nick + ": " + mensaje + " para: " + ip);
                    Socket enviaDestinatario = new Socket(ip, 9090);
                    ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                    paqueteReenvio.writeObject(paqueteRecibido);
                    paqueteReenvio.close();
                    miSocket.close();
                    enviaDestinatario.close();
                } else {
        //--------------------------DETECTA ONLINE--------------------------------
                    InetAddress localizacion = miSocket.getInetAddress();
                    String ipRemota = localizacion.getHostAddress();
                    System.out.println("Onine con : " + ipRemota);
                    listIP.add(ipRemota);
                    for (String z : listIP) {
                        System.out.println("Array: " + z);
                    }
        // -----------------------------------------------------------------------
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private JTextArea areatexto;
}
